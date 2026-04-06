package br.com.webmatte.criacao.abstractfactory.emissor;

import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoAnalise;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class EspectrometroMassa implements EquipamentoAnalise {

    @Override
    public String realizarAnalise(String amostra) {
        if (amostra != null) {
            log.info("Iniciando análise por espectrometria de massa da amostra: {}", amostra);
            log.info("Ionizando moléculas e detectando massa/ carga...");
            return "Análise espectrométrica concluída: " + amostra + " -> Massa: 1500.2 Da";
        } else {
            return "Amostra inválida para espectrometria";
        }
    }

}
