package br.com.webmatte.estrutural.adapter.control;

import br.com.webmatte.estrutural.adapter.entity.Funcionario;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Anderson Matte
 */
@Slf4j
public class ControlePontoNovo {

    public void registrar(Funcionario funcionario, Boolean entrada) {
        if (Boolean.TRUE.equals(entrada)) {
            log.info("Entrada: " + funcionario.getNome() + " às " + this.getRetornaDataAtualFormatado());
        } else {
            log.info("Saída: {} às {}", funcionario.getNome(), this.getRetornaDataAtualFormatado());
        }
    }

    private String getRetornaDataAtualFormatado() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formatter);
    }

}
