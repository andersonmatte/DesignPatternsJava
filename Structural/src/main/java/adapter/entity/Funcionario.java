package adapter.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Funcionario {

    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

}
