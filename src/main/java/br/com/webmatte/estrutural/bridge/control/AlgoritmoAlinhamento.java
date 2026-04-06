package br.com.webmatte.estrutural.bridge.control;

import br.com.webmatte.estrutural.bridge.interfaces.AlgoritmoProcessamento;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AlgoritmoAlinhamento implements AlgoritmoProcessamento {

    @Override
    public void processarDados(String dados) {
        log.info("Iniciando algoritmo de alinhamento de sequências");
        log.info("Dados recebidos: {}", dados);
        log.info("Executando alinhamento global (Needleman-Wunsch)");
        log.info("Score de alinhamento: +85");
        log.info("Identidade: 92.3%");
        log.info("Alinhamento concluído com sucesso");
    }

}
