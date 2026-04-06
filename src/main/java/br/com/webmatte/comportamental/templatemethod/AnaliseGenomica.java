package br.com.webmatte.comportamental.templatemethod;

/**
 * @author Anderson Matte
 */
public class AnaliseGenomica extends PipelineAnaliseBiologica {

    @Override
    protected void realizarAnaliseEspecifica() {
        this.resultadoAnalise += "Iniciando análise genômica específica\n";
        this.resultadoAnalise += "Sequenciamento do genoma completo\n";
        this.resultadoAnalise += "Identificação de variantes genéticas\n";
        this.resultadoAnalise += "Anotação funcional dos genes\n";
    }

}
