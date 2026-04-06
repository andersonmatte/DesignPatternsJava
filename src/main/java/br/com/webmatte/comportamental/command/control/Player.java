package br.com.webmatte.comportamental.command.control;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author Anderson Matte
 */
@Slf4j
public class Player {

    private static final Random RANDOM = new Random();

    public void play(String nomeFile) throws InterruptedException {
        log.info("Tocando o arquivo {}", nomeFile);
        long duracao = Math.abs(RANDOM.nextLong() % 2000);
        log.info("Duração (s) :" + duracao / 1000.0);
        Thread.sleep(duracao);
        log.info("Fim");
    }

    public void aumentaVolume(int volume) {
        log.info("Aumentando o volume em " + volume);
    }

    public void diminuiVolume(int volume) {
        log.info("Diminuindo o volume em " + volume);
    }

}
