package br.com.webmatte.comportamental.visitor.control;

import br.com.webmatte.comportamental.visitor.entity.Gerente;
import br.com.webmatte.comportamental.visitor.entity.Programador;
import br.com.webmatte.comportamental.visitor.interfaces.AtualizadorFuncionario;

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
