package br.com.webmatte.estrutural.composite.control;

import br.com.webmatte.estrutural.composite.interfaces.ComponenteSequencia;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public record Nucleotideo(String base, String posicao) implements ComponenteSequencia {

    @Override
    public void exibirSequencia() {
        log.info("Nucleotideo: {} na posição {}", base, posicao);
    }

    @Override
    public int getTamanho() {
        return 1; // Um nucleotideo tem tamanho 1
    }

}
