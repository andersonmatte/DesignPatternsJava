package br.com.webmatte.comportamental.state.control;

import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
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
        log.info("Mutação cancerígena detectada!");
    }

    @Override
    public String dividir() {
        return "Divisão celular anormal e descontrolada";
    }

    @Override
    public void aplicarTratamento() {
        log.info("Aplicando tratamento quimioterápico...");
    }

    @Override
    public String divisao() {
        return "Divisão celular acelerada e anormal";
    }

}
