package command;

import command.commands.AumentaVolume;
import command.commands.DiminuiVolume;
import command.commands.TocandoMusica;
import command.control.ListaComandos;
import command.control.Player;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class ListaComandosTest {

    @Test
    public void testaListaComandos() {
        Player player = new Player();
        ListaComandos listaComandos = new ListaComandos();
        listaComandos.adiciona(new TocandoMusica(player, "musica01.mp3"));
        listaComandos.adiciona(new AumentaVolume(player, 3));
        listaComandos.adiciona(new DiminuiVolume(player, 2));
        listaComandos.adiciona(new TocandoMusica(player, "musica02.mp3"));
        listaComandos.executa();
    }

}
