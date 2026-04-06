package br.com.webmatte.estrutural.adapter.control;

import br.com.webmatte.estrutural.adapter.entity.Funcionario;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Anderson Matte
 */
@Slf4j
public class ControlePonto {

    public void registrarEntrada(Funcionario funcionario) {
        log.info("Entrada: " + funcionario.getNome() + " às " + this.getRetornaDataAtualFormatado());
    }

    public void registrarSaida(Funcionario funcionario) {
        log.info("Saída: {} às {}", funcionario.getNome(), this.getRetornaDataAtualFormatado());
    }

    private String getRetornaDataAtualFormatado() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formatter);
    }

}
