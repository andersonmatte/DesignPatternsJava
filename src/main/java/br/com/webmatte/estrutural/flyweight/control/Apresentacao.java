package br.com.webmatte.estrutural.flyweight.control;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
@Slf4j
public class Apresentacao {

    private List<Slide> slides = new ArrayList<>();

    public void adicionaSlide(Slide slide) {
        this.slides.add(slide);
    }

    public void imprime() {
        for (Slide slide : this.slides) {
            slide.imprime();
            log.info(String.valueOf(slide));
        }
    }

}
