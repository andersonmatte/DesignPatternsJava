package adapter.control;

import adapter.entity.Funcionario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Anderson Matte
 */
public class ControlePonto {

    public void registrarEntrada(Funcionario funcionario) {
        System.out.println("Entrada: " + funcionario.getNome() + " às " + this.getRetornaDataAtualFormatado());
    }

    public void registrarSaida(Funcionario funcionario) {
        System.out.println("Saída: " + funcionario.getNome() + " às " + this.getRetornaDataAtualFormatado());
    }

    private String getRetornaDataAtualFormatado() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String agoraFormatado = agora.format(formatter);
        return agoraFormatado;
    }

}
