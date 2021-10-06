package objectPool.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Aluno {

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }
}
