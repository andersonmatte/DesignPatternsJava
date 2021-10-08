package flyweight;

import flyweight.control.Apresentacao;
import flyweight.control.Slide;
import flyweight.factory.TemaFlyweightFactory;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class FlyweightTest {

    @Test
    public void testaFlyweight() {
        Apresentacao apresentacao = new Apresentacao();
        apresentacao.adicionaSlide(new Slide(TemaFlyweightFactory.getTema(TemaFlyweightFactory.ANDERSON_MATTE),
                "Repositório com exemplos de Desing Patterns em Java", "No desenvolvimento de um sistema, espera-se alguns requisitos que sejam garantidos, como por exemplo: desempenho, robustez, compreensão, facilidade na reutilização, modificação e uso.\n" +
                "\n" +
                "Os Design Patterns, também conhecidos como Padrões de Projeto, foram criados pelo arquiteto Christopher Alexander, " +
                "\nna década de 70. Durante esse período o arquiteto escreveu dois livros: “Pattern Language” e “Timeless Way of Building”. " +
                "\nEsses livros foram o exemplo de como Christopher pensava no modo para documentar esses padrões.\n"));

        apresentacao.adicionaSlide(new Slide(TemaFlyweightFactory.getTema(TemaFlyweightFactory.ASTERICO),
                "Repositório com exemplos de Desing Patterns em Java", "No desenvolvimento de um sistema, espera-se alguns requisitos que sejam garantidos, como por exemplo: desempenho, robustez, compreensão, facilidade na reutilização, modificação e uso.\n" +
                "\n" +
                "Os Design Patterns, também conhecidos como Padrões de Projeto, foram criados pelo arquiteto Christopher Alexander, " +
                "\nna década de 70. Durante esse período o arquiteto escreveu dois livros: “Pattern Language” e “Timeless Way of Building”. " +
                "\nEsses livros foram o exemplo de como Christopher pensava no modo para documentar esses padrões.\n"));

        apresentacao.adicionaSlide(new Slide(TemaFlyweightFactory.getTema(TemaFlyweightFactory.HIFEN),
                "Repositório com exemplos de Desing Patterns em Java", "No desenvolvimento de um sistema, espera-se alguns requisitos que sejam garantidos, como por exemplo: desempenho, robustez, compreensão, facilidade na reutilização, modificação e uso.\n" +
                "\n" +
                "Os Design Patterns, também conhecidos como Padrões de Projeto, foram criados pelo arquiteto Christopher Alexander, " +
                "\nna década de 70. Durante esse período o arquiteto escreveu dois livros: “Pattern Language” e “Timeless Way of Building”. " +
                "\nEsses livros foram o exemplo de como Christopher pensava no modo para documentar esses padrões.\n"));
        apresentacao.imprime();
    }

}
