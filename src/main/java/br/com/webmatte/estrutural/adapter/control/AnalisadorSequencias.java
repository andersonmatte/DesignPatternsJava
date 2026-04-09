package br.com.webmatte.estrutural.adapter.control;

import br.com.webmatte.estrutural.adapter.entity.AmostraBio;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AnalisadorSequencias {

    public void analisarFASTA(AmostraBio amostra) {
        logAnalise(amostra, "FASTA", "Inicia com '>'");
    }

    public void analisarGenBank(AmostraBio amostra) {
        logAnalise(amostra, "GenBank", "Contém metadados estruturados");
    }

    private void logAnalise(AmostraBio amostra, String formato, String descricao) {
        log.info("Analisando amostra {}: {}", formato, amostra.getCodigo());
        log.info("Sequência: {}", amostra.getSequenciaDNA());
        log.info("Formato: {} - {}", formato, descricao);
    }

}
