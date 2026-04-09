package br.com.webmatte.comportamental.observer.control;

import br.com.webmatte.comportamental.observer.base.AcaoObserverBase;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class LaboratorioPesquisa extends AcaoObserverBase {

    private final String nome;

    public LaboratorioPesquisa(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    protected String getNotificacaoHeader() {
        return "Laboratório " + this.nome + " sendo notificado: ";
    }

    @Override
    protected String getMensagemFormato() {
        return "Gene %s mutado para %s na posição %s";
    }

}
