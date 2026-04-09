package br.com.webmatte.estrutural.adapter.control;

import br.com.webmatte.estrutural.adapter.entity.AmostraBio;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AnalisadorUnificado {

    public void analisar(AmostraBio amostra, String formato) {
        if ("FASTA".equalsIgnoreCase(formato)) {
            logCommonAnalysisInfo(amostra, "FASTA");
            log.info("Formato: FASTA - Inicia com '>'");
        } else if ("GENBANK".equalsIgnoreCase(formato)) {
            logCommonAnalysisInfo(amostra, "GenBank");
            log.info("Formato: GenBank - Contém metadados estruturados");
        } else {
            log.warn("Formato não suportado: {}", formato);
        }
    }

    private void logCommonAnalysisInfo(AmostraBio amostra, String formato) {
        log.info("Analisando amostra {}: {}", formato, amostra.getCodigo());
        log.info("Sequência: {}", amostra.getSequenciaDNA());
    }

}
