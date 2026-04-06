package br.com.webmatte.criacao.singlenton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Singleton - Sistema de Registro Médico")
class SingletonPatternTest {

    @Test
    @DisplayName("Deve retornar mesma instância em chamadas sucessivas")
    void deveRetornarMesmaInstanciaEmChamadasSucessivas() {
        // When
        var instancia1 = SistemaRegistroMedico.getInstance();
        var instancia2 = SistemaRegistroMedico.getInstance();
        var instancia3 = SistemaRegistroMedico.getInstance();

        // Then
        assertSame(instancia1, instancia2);
        assertSame(instancia2, instancia3);
    }

    @Test
    @DisplayName("Deve ser thread-safe em ambiente concorrente")
    void deveSerThreadSafeEmAmbienteConcorrente() throws InterruptedException, ExecutionException, TimeoutException {
        // Given
        ExecutorService executor = Executors.newFixedThreadPool(10);
        SistemaRegistroMedico[] instancias = new SistemaRegistroMedico[10];

        // When - Cria múltiplas instâncias concorrentemente
        CompletableFuture<Void>[] futures = IntStream.range(0, 10)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    instancias[i] = SistemaRegistroMedico.getInstance();
                }, executor))
                .toArray(CompletableFuture[]::new);

        // Espera todas as threads completarem
        CompletableFuture.allOf(futures).get(5, TimeUnit.SECONDS);
        executor.shutdown();

        // Then - Todas devem ser a mesma instância
        SistemaRegistroMedico primeiraInstancia = instancias[0];
        for (int i = 1; i < instancias.length; i++) {
            assertSame(primeiraInstancia, instancias[i],
                    "Instância " + i + " deveria ser a mesma que a primeira");
        }
    }

    @Test
    @DisplayName("Deve manter estado entre diferentes acessos")
    void deveManterEstadoEntreDiferentesAcessos() {
        // Given
        var instancia1 = SistemaRegistroMedico.getInstance();
        var instancia2 = SistemaRegistroMedico.getInstance();

        // When
        instancia1.adicionarPaciente("João Silva");
        instancia2.adicionarPaciente("Maria Santos");

        // Then - Ambas as referências devem ver os mesmos dados
        assertEquals(2, instancia1.getTotalPacientes());
        assertEquals(2, instancia2.getTotalPacientes());
        assertTrue(instancia1.buscarPaciente("João Silva"));
        assertTrue(instancia2.buscarPaciente("Maria Santos"));
    }
}
