package br.com.webmatte.comportamental.observer.interfaces;

import br.com.webmatte.comportamental.observer.control.Acao;

/**
 * @author Anderson Matte
 */
public interface AcaoObserver {

    void notificaAlteracao(Acao acao);

}
