package observer.interfaces;

import observer.control.Acao;

/**
 * @author Anderson Matte
 */
public interface AcaoObserver {

    void notificaAlteracao(Acao acao);

}
