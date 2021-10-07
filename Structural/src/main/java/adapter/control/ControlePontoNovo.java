package adapter.control;

import adapter.entity.Funcionario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Anderson Matte
 */
public class ControlePontoNovo {

    public void registrar(Funcionario funcionario, Boolean entrada) {
        if (entrada) {
            System.out.println("Entrada: " + funcionario.getNome() + " às " + this.getRetornaDataAtualFormatado());
        } else {
            System.out.println("Saída: " + funcionario.getNome() + " às " + this.getRetornaDataAtualFormatado());
        }
    }

    private String getRetornaDataAtualFormatado() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String agoraFormatado = agora.format(formatter);
        return agoraFormatado;
    }

}
