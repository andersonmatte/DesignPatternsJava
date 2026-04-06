package br.com.webmatte.comportamental.observer.control;

import br.com.webmatte.comportamental.observer.interfaces.AcaoObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class Corretora implements AcaoObserver {

    private String nome;

    public Corretora(String nome) {
        this.nome = nome;
    }

    @Override
    public void notificaAlteracao(Acao acao) {
        log.info("Corretor {} sendo notificada: ", this.nome);
        log.info("A ação " + acao.getCodigo() + " teve o seu valor alterado para " + acao.getValor());
    }

}
