package br.com.webmatte.comportamental.strategy.control;

import br.com.webmatte.comportamental.strategy.interfaces.AlgoritmoAlinhamento;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Setter
@Slf4j
public class AnaliseBioinformatica {

    private AlgoritmoAlinhamento algoritmo;

    public void executarAlinhamento(String sequencia1, String sequencia2) {
        if (algoritmo == null) {
            throw new IllegalStateException("Nenhum algoritmo de alinhamento configurado");
        }

        String resultado = algoritmo.alinharSequencias(sequencia1, sequencia2);
        log.info(resultado);
    }
}
