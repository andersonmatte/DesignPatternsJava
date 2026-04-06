package br.com.webmatte.comportamental.state.interfaces;

/**
 * @author Anderson Matte
 */
public interface EstadoCelular {

    String analisarAtividadeCelular(Double nivelMetabolico, Double taxaDivisao);

    String getStatus();

    boolean isCancerigena();

    void detectarMutacao();

    String dividir();

    void aplicarTratamento();

    String divisao();

}
