package command.commands;

import command.control.Player;
import command.interfaces.Comando;

/**
 * @author Anderson Matte
 */
public class AumentaVolume implements Comando {

    private Player player;
    private int volume;

    public AumentaVolume(Player player, int volume) {
        this.player = player;
        this.volume = volume;
    }

    @Override
    public void executa() {
        this.player.aumentaVolume(this.volume);
    }

}
