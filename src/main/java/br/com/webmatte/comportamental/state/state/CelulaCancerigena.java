package br.com.webmatte.comportamental.state.state;

import br.com.webmatte.comportamental.state.control.Celula;
import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;

/**
 * @author Anderson Matte
 */
public class CelulaCancerigena implements EstadoCelular {

    protected Celula celula;

    public CelulaCancerigena(Celula celula) {
        this.celula = celula;
    }

    @Override
    public String analisarAtividadeCelular(Double nivelMetabolico, Double taxaDivisao) {
        return "Célula cancerígena com metabolismo elevado " + nivelMetabolico + " e taxa de divisão anormal " + taxaDivisao;
    }

    @Override
    public String getStatus() {
        return "Cancerígena";
    }

    @Override
    public boolean isCancerigena() {
        return true;
    }

    @Override
    public void detectarMutacao() {
        // Célula já está cancerígena, não muda de estado
    }

    @Override
    public String dividir() {
        return "Célula cancerígena dividindo-se descontroladamente";
    }

    @Override
    public void aplicarTratamento() {
        celula.setEstado(new CelulaNormal(celula));
    }

    @Override
    public String divisao() {
        return "Célula cancerígena dividindo-se descontroladamente";
    }
}
