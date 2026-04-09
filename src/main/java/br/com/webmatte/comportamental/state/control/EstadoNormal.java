package br.com.webmatte.comportamental.state.control;

import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class EstadoNormal implements EstadoCelular {

    @Override
    public String analisarAtividadeCelular(Double nivelMetabolico, Double taxaDivisao) {
        return "Célula em estado normal: Metabolismo " + nivelMetabolico +
                ", Taxa de divisão " + taxaDivisao + " - Funcionamento adequado";
    }

    @Override
    public String getStatus() {
        return "NORMAL";
    }

    @Override
    public boolean isCancerigena() {
        return false;
    }

    @Override
    public void detectarMutacao() {
        log.info("Monitorando mutações celulares...");
    }

    @Override
    public String dividir() {
        return "Divisão celular normal executada";
    }

    @Override
    public void aplicarTratamento() {
        log.info("Nenhum tratamento necessário - célula saudável");
    }

    @Override
    public String divisao() {
        return "Divisão celular em ritmo normal";
    }

}
