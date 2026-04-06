package br.com.webmatte.estrutural.adapter.control;

import br.com.webmatte.estrutural.adapter.entity.AmostraBio;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AnalisadorUnificado {

    public void analisar(AmostraBio amostra, String formato) {
        if ("FASTA".equalsIgnoreCase(formato)) {
            log.info("Analisando amostra FASTA: " + amostra.getCodigo());
            log.info("Sequência: " + amostra.getSequenciaDNA());
            log.info("Formato: FASTA - Inicia com '>'");
        } else if ("GENBANK".equalsIgnoreCase(formato)) {
            log.info("Analisando amostra GenBank: " + amostra.getCodigo());
            log.info("Sequência: " + amostra.getSequenciaDNA());
            log.info("Formato: GenBank - Contém metadados estruturados");
        } else {
            log.warn("Formato não suportado: " + formato);
        }
    }

    private String getDataAtualFormatada() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formatter);
    }

}
