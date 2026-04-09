package br.com.webmatte.comportamental.mediator.control;

import br.com.webmatte.comportamental.mediator.colleague.AlinhadorSequencias;
import br.com.webmatte.comportamental.mediator.colleague.AnalisadorExpressao;
import br.com.webmatte.comportamental.mediator.colleague.ValidadorDados;

import java.util.ArrayList;
import java.util.List;

public class SistemaBioinformaticaMediator {

    private final List<Object> componentes = new ArrayList<>();
    private final List<String> historicoMensagens = new ArrayList<>();

    public void adicionarComponente(Object componente) {
        componentes.add(componente);
    }

    public void removerComponente(Object componente) {
        componentes.remove(componente);
    }

    public int getTotalComponentes() {
        return componentes.size();
    }

    public boolean temComponente(Object componente) {
        return componentes.contains(componente);
    }

    public void broadcast(String mensagem, String origem) {
        historicoMensagens.add(mensagem);

        for (Object componente : componentes) {
            if (componente instanceof AnalisadorExpressao analisador && !origem.equals("ANALISADOR")) {
                analisador.receberMensagem(mensagem, origem);
            } else if (componente instanceof AlinhadorSequencias alinhador && !origem.equals("ALINHADOR")) {
                alinhador.receberMensagem(mensagem, origem);
            } else if (componente instanceof ValidadorDados validador && !origem.equals("VALIDADOR")) {
                validador.receberMensagem(mensagem, origem);
            }
        }
    }

    public void enviarMensagemEspecifica(String mensagem, String origem, String destino) {
        historicoMensagens.add(mensagem);

        for (Object componente : componentes) {
            if (destino.equals("ANALISADOR") && componente instanceof AnalisadorExpressao analisador) {
                analisador.receberMensagem(mensagem, origem);
            } else if (destino.equals("ALINHADOR") && componente instanceof AlinhadorSequencias alinhador) {
                alinhador.receberMensagem(mensagem, origem);
            } else if (destino.equals("VALIDADOR") && componente instanceof ValidadorDados validador) {
                validador.receberMensagem(mensagem, origem);
            }
        }
    }

    public int getTotalMensagensEnviadas() {
        return historicoMensagens.size();
    }

    public boolean temNoHistorico(String mensagem) {
        return historicoMensagens.contains(mensagem);
    }
}
