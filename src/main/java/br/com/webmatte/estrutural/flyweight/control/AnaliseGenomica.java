package br.com.webmatte.estrutural.flyweight.control;

import br.com.webmatte.estrutural.flyweight.factory.DadoGeneticoFlyweightFactory;
import br.com.webmatte.estrutural.flyweight.interfaces.DadoGeneticoFlyweight;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AnaliseGenomica {

    private List<DadoGeneticoFlyweight> dadosCompartilhados = new ArrayList<>();

    public void adicionarDadoCompartilhado(DadoGeneticoFlyweight dado) {
        dadosCompartilhados.add(dado);
    }

    public void executarAnalise(String nomeAnalise) {
        log.info("=== INICIANDO ANÁLISE GENÔMICA COM FLYWEIGHT ===");
        log.info("Análise: {}", nomeAnalise);

        // Reutiliza dados genéticos compartilhados
        DadoGeneticoFlyweight dadoProteina = DadoGeneticoFlyweightFactory.getDado(DadoProteina.class);
        dadosCompartilhados.add(dadoProteina);

        for (DadoGeneticoFlyweight dado : dadosCompartilhados) {
            dado.exibirDado("GENE_" + nomeAnalise, "Análise de expressão gênica");
        }

        log.info("Memória otimizada: {} dados compartilhados", dadosCompartilhados.size());
        log.info("=== ANÁLISE CONCLUÍDA ===");
    }

}
