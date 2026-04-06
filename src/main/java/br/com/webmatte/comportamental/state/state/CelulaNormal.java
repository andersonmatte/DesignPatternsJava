package br.com.webmatte.comportamental.state.state;

import br.com.webmatte.comportamental.state.control.Celula;
import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;

/**
 * @author Anderson Matte
 */
public class CelulaNormal implements EstadoCelular {

    private Celula celula;

    public CelulaNormal(Celula celula) {
        this.celula = celula;
    }

    @Override
    public String analisarAtividadeCelular(Double nivelMetabolico, Double taxaDivisao) {
        return "Célula normal com metabolismo " + nivelMetabolico + " e taxa de divisão " + taxaDivisao;
    }

    @Override
    public String getStatus() {
        return "Normal";
    }

    @Override
    public boolean isCancerigena() {
        return false;
    }

    @Override
    public void detectarMutacao() {
        celula.setEstado(new CelulaCancerigena(celula));
    }

    @Override
    public String dividir() {
        return "Célula normal dividindo-se";
    }

    @Override
    public void aplicarTratamento() {
        // Células normais não precisam de tratamento
    }

    @Override
    public String divisao() {
        return "Célula normal dividindo-se";
    }
}
