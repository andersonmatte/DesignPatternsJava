package br.com.webmatte.comportamental.visitor.entity;

import br.com.webmatte.comportamental.visitor.interfaces.AtualizadorFuncionario;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Gerente extends Funcionario {

    private Integer id;

    public Gerente(String nome, Double salario, Integer id) {
        super(nome, salario);
        this.id = id;
    }

    public void aceita(AtualizadorFuncionario atualizadorFuncionario) {
        atualizadorFuncionario.atualiza(this);
    }

}
