package visitor.interfaces;

import visitor.entity.Gerente;
import visitor.entity.Programador;

/**
 * @author Anderson Matte
 */
public interface AtualizadorFuncionario {

    void atualiza(Gerente gerente);

    void atualiza(Programador programador);

}
