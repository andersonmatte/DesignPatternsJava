package br.com.webmatte.comportamental.visitor.entity;

import br.com.webmatte.comportamental.visitor.interfaces.Atualizavel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public abstract class Funcionario implements Atualizavel {

    private String nome;
    private Double salario;

    protected Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

}
