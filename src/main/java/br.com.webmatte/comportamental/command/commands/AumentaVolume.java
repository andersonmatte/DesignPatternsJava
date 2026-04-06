package br.com.webmatte.comportamental.command.commands;

import br.com.webmatte.comportamental.command.control.Player;
import br.com.webmatte.comportamental.command.interfaces.Comando;

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
