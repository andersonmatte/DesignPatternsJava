package flyweight.control;

import flyweight.interfaces.TemaFlyweight;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Slide {

    private TemaFlyweight temaFlyweight;
    private String titulo;
    private String conteudo;

    public Slide(TemaFlyweight temaFlyweight, String titulo, String conteudo) {
        this.temaFlyweight = temaFlyweight;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public void imprime() {
        this.temaFlyweight.imprime(this.titulo, this.conteudo);
    }

}
