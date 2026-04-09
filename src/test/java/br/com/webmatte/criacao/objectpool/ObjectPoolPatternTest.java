package br.com.webmatte.criacao.objectpool;

import br.com.webmatte.criacao.objectpool.entity.EquipamentoLaboratorial;
import br.com.webmatte.criacao.objectpool.pool.EquipamentoPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Object Pool - Pool de Equipamentos")
class ObjectPoolPatternTest {

    private EquipamentoPool pool;

    @BeforeEach
    void setUp() {
        pool = new EquipamentoPool();
    }

    @Test
    @DisplayName("Deve adquirir equipamento do pool")
    void deveAdquirirEquipamentoDoPool() throws InterruptedException {
        // When
        EquipamentoLaboratorial equipamento = pool.adquirirEquipamento();

        // Then
        assertNotNull(equipamento);
        assertTrue(equipamento.isEmUso());
        assertEquals(4, pool.getEquipamentosDisponiveis()); // 5 - 1 = 4
    }

    @Test
    @DisplayName("Deve liberar equipamento para o pool")
    void deveLiberarEquipamentoParaOPool() throws InterruptedException {
        // Given
        EquipamentoLaboratorial equipamento = pool.adquirirEquipamento();
        assertEquals(4, pool.getEquipamentosDisponiveis());

        // When
        pool.liberarEquipamento(equipamento);

        // Then
        assertFalse(equipamento.isEmUso());
        assertEquals(5, pool.getEquipamentosDisponiveis()); // 4 + 1 = 5
    }

    @Test
    @DisplayName("Deve esperar quando não houver equipamentos disponíveis")
    void deveEsperarQuandoNaoHouverEquipamentosDisponiveis() throws InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        // Given - Adquire todos os equipamentos disponíveis
        EquipamentoLaboratorial[] equipamentos = new EquipamentoLaboratorial[5];
        for (int i = 0; i < 5; i++) {
            equipamentos[i] = pool.adquirirEquipamento();
        }

        assertEquals(0, pool.getEquipamentosDisponiveis());

        // When - Tenta adquirir outro equipamento em thread separada
        CompletableFuture<EquipamentoLaboratorial> future = CompletableFuture.supplyAsync(() -> {
            try {
                return pool.adquirirEquipamento();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Libera um equipamento após um pequeno delay
        CompletableFuture.runAsync(() -> pool.liberarEquipamento(equipamentos[0]),
                CompletableFuture.delayedExecutor(100, TimeUnit.MILLISECONDS));

        // Then - Deve conseguir adquirir após liberação
        EquipamentoLaboratorial equipamentoAdquirido = future.get(1, TimeUnit.SECONDS);
        assertNotNull(equipamentoAdquirido);
        assertEquals(0, pool.getEquipamentosDisponiveis()); // 0 + 1 - 1 = 0
    }

    @Test
    @DisplayName("Deve ser thread-safe em ambiente concorrente")
    void deveSerThreadSafeEmAmbienteConcorrente() throws InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        // Given
        ExecutorService executor = Executors.newFixedThreadPool(10);
        EquipamentoLaboratorial[] equipamentos = new EquipamentoLaboratorial[10];

        // When - Múltiplas threads tentam adquirir equipamentos
        CompletableFuture<Void>[] futures = IntStream.range(0, 10)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    try {
                        equipamentos[i] = pool.adquirirEquipamento();
                        if (equipamentos[i] != null) {
                            // Simula uso do equipamento com delay determinístico
                            CompletableFuture.runAsync(() -> pool.liberarEquipamento(equipamentos[i]),
                                    CompletableFuture.delayedExecutor(100, TimeUnit.MILLISECONDS));
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore interrupt flag
                        equipamentos[i] = null;
                    }
                }, executor))
                .toArray(CompletableFuture[]::new);

        // Espera todas as threads completarem
        CompletableFuture.allOf(futures).get(2, TimeUnit.SECONDS);
        executor.shutdown();

        // Aguarda de forma determinística que todos os equipamentos sejam liberados
        // Usa polling com CompletableFuture.delayedExecutor em vez de Thread.sleep
        CompletableFuture<Void> waitTask = CompletableFuture.runAsync(() -> {
            int attempts = 0;
            final int maxAttempts = 50; // 50 tentativas = 500ms máximo

            while (pool.getEquipamentosDisponiveis() != 5 && attempts < maxAttempts) {
                attempts++;
                // Usa delayedExecutor para polling sem Thread.sleep direto
                CompletableFuture.runAsync(() -> {
                        },
                        CompletableFuture.delayedExecutor(10, TimeUnit.MILLISECONDS)).join();
            }
        });

        // Espera com timeout razoável
        waitTask.get(1, TimeUnit.SECONDS);

        // Then - Verifica que o pool funciona corretamente em ambiente concorrente
        long adquiridosComSucesso = IntStream.range(0, 10)
                .filter(i -> equipamentos[i] != null)
                .count();

        assertTrue(adquiridosComSucesso >= 5); // Pelo menos 5 devem conseguir adquirir
        assertEquals(5, pool.getEquipamentosDisponiveis()); // Todos liberados
    }

    @Test
    @DisplayName("Deve gerenciar ciclo de vida dos equipamentos")
    void deveGerenciarCicloDeVidaDosEquipamentos() throws InterruptedException {
        // When & Then - Ciclo completo de uso
        EquipamentoLaboratorial equipamento = pool.adquirirEquipamento();
        assertNotNull(equipamento);
        assertEquals(4, pool.getEquipamentosDisponiveis());

        equipamento.setEmUso(true);
        pool.liberarEquipamento(equipamento);
        assertEquals(5, pool.getEquipamentosDisponiveis());
    }
}
