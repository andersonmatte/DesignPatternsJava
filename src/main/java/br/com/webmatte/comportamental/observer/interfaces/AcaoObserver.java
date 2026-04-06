package br.com.webmatte.comportamental.observer.interfaces;

import br.com.webmatte.comportamental.observer.control.Gene;

/**
 * @author Anderson Matte
 */
public interface AcaoObserver {

    void notificaAlteracao(Gene gene);

}
