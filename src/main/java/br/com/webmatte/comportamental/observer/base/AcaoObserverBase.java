package br.com.webmatte.comportamental.observer.base;

import br.com.webmatte.comportamental.observer.control.Gene;
import br.com.webmatte.comportamental.observer.interfaces.AcaoObserver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AcaoObserverBase implements AcaoObserver {

    @Getter
    protected boolean notificado;
    @Getter
    protected int totalNotificacoes;
    protected List<String> notificacoes;

    protected AcaoObserverBase() {
        this.notificado = false;
        this.totalNotificacoes = 0;
        this.notificacoes = new ArrayList<>();
    }

    @Override
    public final void notificaAlteracao(Gene gene) {
        log.info(getNotificacaoHeader(), gene.getCodigo());
        log.info("O gene {} teve sua mutação alterada para {}", gene.getCodigo(), gene.getTipoMutacao());
        log.info("Sequência afetada: {}", gene.getSequencia());

        this.notificado = true;
        this.totalNotificacoes++;
        this.notificacoes.add(String.format(getMensagemFormato(),
                gene.getCodigo(), gene.getTipoMutacao(), gene.getSequencia()));
    }

    protected abstract String getNotificacaoHeader();

    protected abstract String getMensagemFormato();

    public String getUltimaNotificacao() {
        if (notificacoes.isEmpty()) {
            return "";
        }
        return notificacoes.get(notificacoes.size() - 1);
    }
}
