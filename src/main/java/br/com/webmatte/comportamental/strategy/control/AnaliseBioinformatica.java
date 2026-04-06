package br.com.webmatte.comportamental.strategy.control;

import br.com.webmatte.comportamental.strategy.interfaces.AlgoritmoAlinhamento;

/**
 * @author Anderson Matte
 */
public class AnaliseBioinformatica {

    private AlgoritmoAlinhamento algoritmo;

    public void setAlgoritmo(AlgoritmoAlinhamento algoritmo) {
        this.algoritmo = algoritmo;
    }

    public void executarAlinhamento(String sequencia1, String sequencia2) {
        if (algoritmo == null) {
            throw new IllegalStateException("Nenhum algoritmo de alinhamento configurado");
        }

        String resultado = algoritmo.alinharSequencias(sequencia1, sequencia2);
        System.out.println(resultado);
    }
}
