package command.control;

import command.interfaces.Comando;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class ListaComandos {

    private List<Comando> comandos = new ArrayList<Comando>();

    public void adiciona(Comando comando) {
        this.comandos.add(comando);
    }

    public void executa() {
        for (Comando comando : this.comandos) {
            comando.executa();
        }
    }

}
