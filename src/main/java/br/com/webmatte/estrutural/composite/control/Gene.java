package br.com.webmatte.estrutural.composite.control;

import br.com.webmatte.estrutural.composite.interfaces.ComponenteSequencia;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class Gene implements ComponenteSequencia {

    private String nome;
    private String sequencia;

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

    public String getNome() {
        return nome;
    }

    public String getSequencia() {
        return sequencia;
    }

}
