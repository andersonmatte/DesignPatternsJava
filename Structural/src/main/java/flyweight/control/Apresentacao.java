package flyweight.control;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class Apresentacao {

    private List<Slide> slides = new ArrayList<Slide>();

    public void adicionaSlide(Slide slide) {
        this.slides.add(slide);
    }

    public void imprime() {
        for (Slide slide : this.slides) {
            slide.imprime();
            System.out.println(slide);
        }
    }

}
