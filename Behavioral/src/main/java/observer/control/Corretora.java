package observer.control;

import observer.interfaces.AcaoObserver;

/**
 * @author Anderson Matte
 */
public class Corretora implements AcaoObserver {

    private String nome;

    public Corretora(String nome) {
        this.nome = nome;
    }

    @Override
    public void notificaAlteracao(Acao acao) {
        System.out.println("Corretor " + this.nome + " sendo notificada: ");
        System.out.println("A ação " + acao.getCodigo() + " teve o seu valor alterado para " + acao.getValor());
    }

}
