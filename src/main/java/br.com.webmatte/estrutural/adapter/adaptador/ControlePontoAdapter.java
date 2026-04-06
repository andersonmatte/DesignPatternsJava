package br.com.webmatte.estrutural.adapter.adaptador;

import br.com.webmatte.estrutural.adapter.control.ControlePonto;
import br.com.webmatte.estrutural.adapter.control.ControlePontoNovo;
import br.com.webmatte.estrutural.adapter.entity.Funcionario;

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
