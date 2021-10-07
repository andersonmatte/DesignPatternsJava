package adapter.adaptador;

import adapter.control.ControlePonto;
import adapter.control.ControlePontoNovo;
import adapter.entity.Funcionario;

/**
 * @author Anderson Matte
 */
public class ControlePontoAdapter extends ControlePonto {

    public ControlePontoNovo controlePontoNovo = new ControlePontoNovo();

    public ControlePontoAdapter() {
        this.controlePontoNovo = new ControlePontoNovo();
    }

    public void registrarEntrada(Funcionario funcionario) {
        this.controlePontoNovo.registrar(funcionario, true);
    }

    public void registrarSaida(Funcionario funcionario) {
        this.controlePontoNovo.registrar(funcionario, false);
    }

}
