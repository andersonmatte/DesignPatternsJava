package visitor.entity;

import lombok.Getter;
import lombok.Setter;
import visitor.interfaces.AtualizadorFuncionario;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Departamento {

    private String nome;
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void aceita(AtualizadorFuncionario atualizadorFuncionario) {
        for (Funcionario funcionario : this.funcionarios) {
            funcionario.aceita(atualizadorFuncionario);
        }
    }

}
