package visitor.entity;

import lombok.Getter;
import lombok.Setter;
import visitor.interfaces.Atualizavel;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public abstract class Funcionario implements Atualizavel {

    private String nome;
    private Double salario;

    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

}
