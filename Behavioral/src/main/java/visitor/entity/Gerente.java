package visitor.entity;

import lombok.Getter;
import lombok.Setter;
import visitor.interfaces.AtualizadorFuncionario;

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
