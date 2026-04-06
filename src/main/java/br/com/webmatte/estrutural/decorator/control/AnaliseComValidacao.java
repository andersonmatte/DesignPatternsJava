package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.AnaliseBio;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AnaliseComValidacao extends AnaliseDecorator {

    public AnaliseComValidacao(AnaliseBio analise) {
        super(analise);
    }

    @Override
    public void executarAnalise(String amostra) {
        log.info("Adicionando camada de validação à análise");
        log.info("Validando integridade da amostra: {}", amostra);

        if (amostra == null || amostra.trim().isEmpty()) {
            log.error("Amostra inválida! Análise cancelada.");
            return;
        }

        log.info("Amostra validada com sucesso");
        this.getAnalise().executarAnalise(amostra);
    }

}
