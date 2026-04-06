package br.com.webmatte.comportamental.command.commands;

import br.com.webmatte.comportamental.command.control.Player;
import br.com.webmatte.comportamental.command.interfaces.Comando;

/**
 * @author Anderson Matte
 */
public class TocandoMusica implements Comando {

    String nomeFile;
    private Player player;

    public TocandoMusica(Player player, String nomeFile) {
        this.player = player;
        this.nomeFile = nomeFile;
    }

    @Override
    public void executa() throws InterruptedException {
        this.player.play(this.nomeFile);
    }

}
