package br.com.webmatte.estrutural.adapter.adaptador;

import br.com.webmatte.estrutural.adapter.control.ControlePonto;
import br.com.webmatte.estrutural.adapter.control.ControlePontoNovo;
import br.com.webmatte.estrutural.adapter.entity.Funcionario;

/**
 * @author Anderson Matte
 */
public class ControlePontoAdapter extends ControlePonto {

    private final ControlePontoNovo controlePontoNovo;

    public ControlePontoAdapter() {
        this.controlePontoNovo = new ControlePontoNovo();
    }

    @Override
    public void registrarEntrada(Funcionario funcionario) {
        this.controlePontoNovo.registrar(funcionario, true);
    }

    @Override
    public void registrarSaida(Funcionario funcionario) {
        this.controlePontoNovo.registrar(funcionario, false);
    }

}
