package command.commands;

import command.control.Player;
import command.interfaces.Comando;

/**
 * @author Anderson Matte
 */
public class DiminuiVolume implements Comando {

    private Player player;
    private int volume;

    public DiminuiVolume(Player player, int volume) {
        this.player = player;
        this.volume = volume;
    }

    @Override
    public void executa() {
        this.player.diminuiVolume(this.volume);
    }

}
