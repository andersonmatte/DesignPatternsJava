package br.com.webmatte.comportamental.command.control;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author Anderson Matte
 */
@Slf4j
public class SequenciadorDNA {

    private static final Random RANDOM = new Random();

    public void sequenciarGene(String gene) throws InterruptedException {
        log.info("Sequenciando o gene: {}", gene);
        long duracao = Math.abs(RANDOM.nextLong() % 2000);
        log.info("Tempo de processamento (s): {}", duracao / 1000.0);
        Thread.sleep(duracao);
        log.info("Sequenciamento concluído");
    }

    public void aumentarExpressaoGenica(int nivel) {
        log.info("Aumentando a expressão gênica em {} unidades", nivel);
    }

    public void diminuirExpressaoGenica(int nivel) {
        log.info("Diminuindo a expressão gênica em {} unidades", nivel);
    }

}
