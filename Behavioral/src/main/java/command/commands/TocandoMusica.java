package command.commands;

import command.control.Player;
import command.interfaces.Comando;

/**
 * @author Anderson Matte
 */
public class TocandoMusica implements Comando {

    private Player player;
    String nomeFile;

    public TocandoMusica(Player player, String nomeFile) {
        this.player = player;
        this.nomeFile = nomeFile;
    }

    @Override
    public void executa() {
        try {
            this.player.play(this.nomeFile);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
