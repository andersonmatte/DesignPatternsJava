package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.AnaliseBio;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AnaliseComRelatorio extends AnaliseDecorator {

    public AnaliseComRelatorio(AnaliseBio analise) {
        super(analise);
    }

    @Override
    public void executarAnalise(String amostra) {
        log.info("Adicionando camada de geração de relatório à análise");

        // Executa a análise base
        this.getAnalise().executarAnalise(amostra);

        // Gera relatório detalhado
        log.info("=== RELATÓRIO DE ANÁLISE ===");
        log.info("Amostra analisada: {}", amostra);
        log.info("Timestamp: {}", java.time.LocalDateTime.now());
        log.info("Analista: Sistema BioInfo v2.0");
        log.info("Status: Análise concluída com sucesso");
        log.info("===============================");
    }

}
