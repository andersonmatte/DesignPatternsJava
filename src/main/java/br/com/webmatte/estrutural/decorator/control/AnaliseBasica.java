package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.AnaliseBio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anderson Matte
 */
public class AnaliseBasica implements AnaliseBio {

    private static final Logger log = LoggerFactory.getLogger(AnaliseBasica.class);

    @Override
    public void executarAnalise(String amostra) {
        log.info("Executando análise básica da amostra: {}", amostra);
        log.info("Análise de sequência iniciada");
        log.info("Processando dados genéticos...");
        log.info("Análise básica concluída");
    }

}
