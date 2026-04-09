package br.com.webmatte.comportamental.visitor.control;

import br.com.webmatte.comportamental.visitor.entity.GeneProteina;
import br.com.webmatte.comportamental.visitor.entity.GeneRegulador;
import br.com.webmatte.comportamental.visitor.interfaces.AnalisadorGenetico;
import br.com.webmatte.util.LogUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class AnalisadorExpressaoGenica implements AnalisadorGenetico {

    @Override
    public void analisa(GeneProteina geneProteina) {
        LogUtil.logAnaliseGene(geneProteina.getNome(), "proteína");
        LogUtil.logProteina(geneProteina.getNome(), geneProteina.getProteinaCodificada());
        LogUtil.logSequencia("GeneProteina", geneProteina.getSequencia());
        LogUtil.logResultadoAnalise("expressão gênica", "Nível elevado de transcrição detectado");
    }

    @Override
    public void analisa(GeneRegulador geneRegulador) {
        LogUtil.logAnaliseGene(geneRegulador.getNome(), "regulador");
        LogUtil.logGeneRegulador(geneRegulador.getNome(), geneRegulador.getGeneAlvo());
        LogUtil.logSequencia("GeneRegulador", geneRegulador.getSequencia());
        LogUtil.logResultadoAnalise("regulatória", "Ativação do gene alvo confirmada");
    }

}
