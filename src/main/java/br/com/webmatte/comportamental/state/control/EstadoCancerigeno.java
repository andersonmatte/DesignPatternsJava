package br.com.webmatte.comportamental.state.control;

import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;

/**
 * @author Anderson Matte
 */
public class EstadoCancerigeno implements EstadoCelular {

    @Override
    public String analisarAtividadeCelular(Double nivelMetabolico, Double taxaDivisao) {
        return "Célula em estado cancerígeno: Metabolismo elevado " + nivelMetabolico +
                ", Taxa de divisão anormal " + taxaDivisao + " - Requer intervenção médica";
    }

    @Override
    public String getStatus() {
        return "CANCERÍGENO";
    }

    @Override
    public boolean isCancerigena() {
        return true;
    }

    @Override
    public void detectarMutacao() {
        System.out.println("Mutação cancerígena detectada!");
    }

    @Override
    public String dividir() {
        return "Divisão celular anormal e descontrolada";
    }

    @Override
    public void aplicarTratamento() {
        System.out.println("Aplicando tratamento quimioterápico...");
    }

    @Override
    public String divisao() {
        return "Divisão celular acelerada e anormal";
    }

}
