package br.com.webmatte.comportamental.mediator.colleague;

import br.com.webmatte.comportamental.mediator.control.SistemaBioinformaticaMediator;

public class AnalisadorExpressao {

    private SistemaBioinformaticaMediator mediator;
    private boolean mensagemRecebida = false;
    private String ultimaMensagemRecebida;
    private String origemUltimaMensagem;

    public AnalisadorExpressao(SistemaBioinformaticaMediator mediator) {
        this.mediator = mediator;
        this.mediator.adicionarComponente(this);
    }

    public void enviarMensagem(String mensagem, String origem) {
        mediator.broadcast(mensagem, origem);
    }

    public void enviarMensagemEspecifica(String mensagem, String origem, String destino) {
        mediator.enviarMensagemEspecifica(mensagem, origem, destino);
    }

    public void receberMensagem(String mensagem, String origem) {
        this.mensagemRecebida = true;
        this.ultimaMensagemRecebida = mensagem;
        this.origemUltimaMensagem = origem;
    }

    public boolean recebeuMensagem() {
        return mensagemRecebida;
    }

    public String getUltimaMensagemRecebida() {
        return ultimaMensagemRecebida;
    }

    public String getOrigemUltimaMensagem() {
        return origemUltimaMensagem;
    }

    public void reset() {
        this.mensagemRecebida = false;
        this.ultimaMensagemRecebida = null;
        this.origemUltimaMensagem = null;
    }
}
