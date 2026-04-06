package br.com.webmatte.estrutural.facade.control;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
@Slf4j
public class Estoque {

    public void enviaProduto(String produto, String enderecoEntrega) {
        log.info("O produto {} \nserá entregue no endereço {} \naté as 20h do dia {}", produto, enderecoEntrega, LocalDate.now());
    }

}
