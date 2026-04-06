package br.com.webmatte.comportamental.observer.control;

import br.com.webmatte.comportamental.observer.interfaces.AcaoObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class LaboratorioPesquisa implements AcaoObserver {

    private String nome;

    public LaboratorioPesquisa(String nome) {
        this.nome = nome;
    }

    @Override
    public void notificaAlteracao(Gene gene) {
        log.info("Laboratório {} sendo notificado: ", this.nome);
        log.info("O gene " + gene.getCodigo() + " teve sua mutação alterada para " + gene.getTipoMutacao());
        log.info("Sequência afetada: " + gene.getSequencia());
    }

}
