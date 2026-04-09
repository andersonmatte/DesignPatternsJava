package br.com.webmatte.comportamental.mediator.colleague;

import br.com.webmatte.comportamental.mediator.control.SistemaBioinformaticaMediator;
import lombok.Getter;

public class AnalisadorExpressao {

    private final SistemaBioinformaticaMediator mediator;
    private boolean mensagemRecebida = false;
    @Getter
    private String ultimaMensagemRecebida;
    @Getter
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

    public void reset() {
        this.mensagemRecebida = false;
        this.ultimaMensagemRecebida = null;
        this.origemUltimaMensagem = null;
    }
}
