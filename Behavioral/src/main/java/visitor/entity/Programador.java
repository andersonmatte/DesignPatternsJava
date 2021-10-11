package visitor.entity;

import lombok.Getter;
import lombok.Setter;
import visitor.interfaces.AtualizadorFuncionario;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Programador extends Funcionario {

    private String linguagem;

    public Programador(String nome, Double salario, String linguagem) {
        super(nome, salario);
        this.linguagem = linguagem;
    }

    public void aceita(AtualizadorFuncionario atualizadorFuncionario) {
        atualizadorFuncionario.atualiza(this);
    }

}
