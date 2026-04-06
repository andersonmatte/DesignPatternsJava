package br.com.webmatte.comportamental.visitor.interfaces;

import br.com.webmatte.comportamental.visitor.entity.Gerente;
import br.com.webmatte.comportamental.visitor.entity.Programador;

/**
 * @author Anderson Matte
 */
public interface AtualizadorFuncionario {

    void atualiza(Gerente gerente);

    void atualiza(Programador programador);

}
