package br.com.webmatte.estrutural.facade.control;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class Financeiro {

    public void fatura(String cliente, String produto) {
        log.info("Fatura: ");
        log.info("Cliente: " + cliente);
        log.info("Produto: {}", produto);
    }

}
