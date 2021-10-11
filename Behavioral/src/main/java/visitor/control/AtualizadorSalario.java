package visitor.control;

import visitor.entity.Gerente;
import visitor.entity.Programador;
import visitor.interfaces.AtualizadorFuncionario;

/**
 * @author Anderson Matte
 */
public class AtualizadorSalario implements AtualizadorFuncionario {

    @Override
    public void atualiza(Gerente gerente) {
        gerente.setSalario(gerente.getSalario() * 2.3D);
    }

    @Override
    public void atualiza(Programador programador) {
        programador.setSalario(programador.getSalario() * 2.3D);
    }

}
