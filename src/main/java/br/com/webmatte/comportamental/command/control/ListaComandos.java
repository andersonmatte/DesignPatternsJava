package br.com.webmatte.comportamental.command.control;

import br.com.webmatte.comportamental.command.exception.ComandoExecutionException;
import br.com.webmatte.comportamental.command.interfaces.Comando;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class ListaComandos {

    private List<Comando> comandos = new ArrayList<>();

    public void adiciona(Comando comando) {
        this.comandos.add(comando);
    }

    public void executa() {
        for (Comando comando : this.comandos) {
            try {
                comando.executa();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new ComandoExecutionException("Command execution was interrupted", e);
            }
        }
    }

}
