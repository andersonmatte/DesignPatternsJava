package br.com.webmatte.estrutural.composite.control;

import br.com.webmatte.estrutural.composite.interfaces.ComponenteSequencia;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class Nucleotideo implements ComponenteSequencia {

    private String base;
    private String posicao;

    public Nucleotideo(String base, String posicao) {
        this.base = base;
        this.posicao = posicao;
    }

    @Override
    public void exibirSequencia() {
        log.info("Nucleotideo: {} na posição {}", base, posicao);
    }

    @Override
    public int getTamanho() {
        return 1; // Um nucleotideo tem tamanho 1
    }

    public String getBase() {
        return base;
    }

    public String getPosicao() {
        return posicao;
    }

}
