package br.com.webmatte.criacao.abstractfactory.emissor;

import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoAnalise;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class SequenciadorDNA implements EquipamentoAnalise {

    @Override
    public String realizarAnalise(String amostra) {
        if (amostra != null) {
            log.info("Iniciando sequenciamento de DNA da amostra: {}", amostra);
            log.info("Processando bases nitrogenadas...");
            return "Sequenciamento DNA concluído: " + amostra + " -> ATCG-GCTA-TACG";
        } else {
            return "Amostra inválida para sequenciamento";
        }
    }

}
