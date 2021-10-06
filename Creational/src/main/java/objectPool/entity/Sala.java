package objectPool.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Sala {

    private String nome;

    public Sala(String nome) {
        this.nome = nome;
    }

}
