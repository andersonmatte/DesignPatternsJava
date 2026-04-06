package br.com.webmatte.comportamental.visitor.entity;

import br.com.webmatte.comportamental.visitor.interfaces.AtualizadorFuncionario;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Departamento {

    private String nome;
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void aceita(AtualizadorFuncionario atualizadorFuncionario) {
        for (Funcionario funcionario : this.funcionarios) {
            funcionario.aceita(atualizadorFuncionario);
        }
    }

}
