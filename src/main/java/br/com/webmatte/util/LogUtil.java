package br.com.webmatte.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Utility class for standardized logging across the bioinformatics system.
 * Provides consistent log message formats and reduces code duplication.
 * @author Anderson Matte
 */
@Slf4j
public class LogUtil {

    private LogUtil() {
        /* This utility class should not be instantiated */
    }

    /**
     * Logs sequence information in a standardized format.
     * @param context  The context/source of the sequence (e.g., "Gene", "Proteína")
     * @param sequence The actual sequence data
     */
    public static void logSequencia(String context, String sequence) {
        log.info("Sequência [{}]: {}", context, sequence);
    }

    /**
     * Logs gene analysis information.
     * @param geneName     The name of the gene being analyzed
     * @param analysisType The type of analysis being performed
     */
    public static void logAnaliseGene(String geneName, String analysisType) {
        log.info("Analisando gene [{}]: {}", geneName, analysisType);
    }

    /**
     * Logs protein information.
     * @param proteinName    The name of the protein
     * @param encodedProtein The encoded protein data
     */
    public static void logProteina(String proteinName, String encodedProtein) {
        log.info("Proteína codificada [{}]: {}", proteinName, encodedProtein);
    }

    /**
     * Logs regulatory gene information.
     * @param regulatorName The name of the regulatory gene
     * @param targetGene    The target gene
     */
    public static void logGeneRegulador(String regulatorName, String targetGene) {
        log.info("Gene regulador [{}] -> Gene alvo: {}", regulatorName, targetGene);
    }

    /**
     * Logs analysis results in a standardized format.
     * @param analysisType The type of analysis
     * @param result       The analysis result
     */
    public static void logResultadoAnalise(String analysisType, String result) {
        log.info("Análise [{}]: {}", analysisType, result);
    }
}
