package br.com.webmatte.comportamental.mediator.control;

import br.com.webmatte.comportamental.mediator.entity.AmstraGenetica;
import br.com.webmatte.comportamental.mediator.entity.AnalisadorSequencia;
import br.com.webmatte.comportamental.mediator.exception.AnalisadorInterruptedException;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
@Slf4j
public class CoordenadorAnaliseGenomica {

    private List<AnalisadorSequencia> analisadoresDisponiveis = new ArrayList<>();
    private List<AmstraGenetica> amostrasEspera = new ArrayList<>();

    @Synchronized
    public void adicionaAnalisadorDisponivel(AnalisadorSequencia analisador) {
        log.info("Analisador {} voltou para a fila de processamento.", analisador.getId());
        this.analisadoresDisponiveis.add(analisador);
        synchronized (this) {
            this.notifyAll();
        }
    }

    public void processaAmostra(AmstraGenetica amostra) {
        AnalisadorSequencia analisador = this.esperaAnalisador(amostra);
        log.info("Analisador {} processando a amostra genética {}", analisador.getId(), amostra.getCodigo());
        synchronized (this) {
            this.analisadoresDisponiveis.add(analisador);
            this.notifyAll();
        }
    }

    private AnalisadorSequencia esperaAnalisador(AmstraGenetica amostra) {
        this.amostrasEspera.add(amostra);
        synchronized (this) {
            while (this.analisadoresDisponiveis.isEmpty() || !this.amostrasEspera.get(0).equals(amostra)) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AnalisadorInterruptedException("Thread interrupted while waiting for analyzer", e);
                }
            }
            this.amostrasEspera.remove(0);
            return this.analisadoresDisponiveis.remove(0);
        }
    }

}
