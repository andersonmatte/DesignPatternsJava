package br.com.webmatte.comportamental.observer.observer;

import br.com.webmatte.comportamental.observer.control.Gene;
import br.com.webmatte.comportamental.observer.interfaces.AcaoObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AnalistaGenetico implements AcaoObserver {

    private String nome;
    private boolean notificado;
    private int totalNotificacoes;
    private List<String> notificacoes;

    public AnalistaGenetico(String nome) {
        this.nome = nome;
        this.notificado = false;
        this.totalNotificacoes = 0;
        this.notificacoes = new ArrayList<>();
    }

    @Override
    public void notificaAlteracao(Gene gene) {
        log.info("Analista Genético {} sendo notificado: ", this.nome);
        log.info("O gene " + gene.getCodigo() + " teve sua mutação alterada para " + gene.getTipoMutacao());
        log.info("Sequência afetada: " + gene.getSequencia());

        this.notificado = true;
        this.totalNotificacoes++;
        this.notificacoes.add(String.format("Gene %s mutado para %s na posição %s",
                gene.getCodigo(), gene.getTipoMutacao(), gene.getSequencia()));
    }

    public boolean isNotificado() {
        return notificado;
    }

    public int getTotalNotificacoes() {
        return totalNotificacoes;
    }

    public String getUltimaNotificacao() {
        if (notificacoes.isEmpty()) {
            return "";
        }
        return notificacoes.get(notificacoes.size() - 1);
    }

}
