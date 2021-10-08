package command.control;

/**
 * @author Anderson Matte
 */
public class Player {

    public void play(String nomeFile) throws InterruptedException {
        System.out.println("Tocando o arquivo " + nomeFile);
        long duracao = (long) (Math.random() * 2000);
        System.out.println("Duração (s) :" + duracao / 1000.0);
        Thread.sleep(duracao);
        System.out.println("Fim");
    }

    public void aumentaVolume(int volume) {
        System.out.println("Aumentando o volume em " + volume);
    }

    public void diminuiVolume(int volume) {
        System.out.println("Diminuindo o volume em " + volume);
    }

}
