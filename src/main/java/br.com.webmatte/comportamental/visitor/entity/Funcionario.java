package br.com.webmatte.comportamental.visitor.entity;

import lombok.Getter;
import lombok.Setter;
import br.com.webmatte.comportamental.visitor.interfaces.Atualizavel;

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
