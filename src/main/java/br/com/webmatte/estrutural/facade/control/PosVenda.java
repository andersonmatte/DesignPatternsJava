package br.com.webmatte.estrutural.facade.control;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
@Slf4j
public class PosVenda {

    public void agendaContatoComCliente(String cliente, String produto) {
        log.info("Entrar em contato com o cliente: {} \nsobre o produto adquirido {} \nno dia {}", cliente, produto, LocalDate.now());
    }

}
