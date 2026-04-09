package br.com.webmatte.estrutural.composite.control;

import br.com.webmatte.estrutural.composite.interfaces.ComponenteSequencia;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Getter
@Slf4j
public class Gene implements ComponenteSequencia {

    private final String nome;
    private final String sequencia;

    public Gene(String nome, String sequencia) {
        this.nome = nome;
        this.sequencia = sequencia;
    }

    @Override
    public void exibirSequencia() {
        log.info("Gene: {} - Sequência: {}", nome, sequencia);
    }

    @Override
    public int getTamanho() {
        return sequencia.length();
    }

}
