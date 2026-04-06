package br.com.webmatte.estrutural.flyweight.temas;

import br.com.webmatte.estrutural.flyweight.interfaces.DadoGeneticoFlyweight;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class DadoProteina implements DadoGeneticoFlyweight {

    private String nomeProteina;
    private String sequenciaAminoacidos;

    public DadoProteina() {
        this.nomeProteina = "Hemoglobina";
        this.sequenciaAminoacidos = "VLSPADKTNVKAAW";
    }

    @Override
    public void exibirDado(String nomeGene, String informacao) {
        log.info("=== DADO GENÉTICO COMPARTILHADO ===");
        log.info("Proteína: {}", nomeProteina);
        log.info("Sequência de Aminoácidos: {}", sequenciaAminoacidos);
        log.info("Gene associado: {}", nomeGene);
        log.info("Informação adicional: {}", informacao);
        log.info("Memória otimizada - dados compartilhados entre múltiplas análises");
    }

}
