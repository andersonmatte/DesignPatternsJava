package br.com.webmatte.comportamental.templatemethod;

/**
 * @author Anderson Matte
 */
public class AnaliseProteomica extends PipelineAnaliseBiologica {

    @Override
    protected void realizarAnaliseEspecifica() {
        this.resultadoAnalise += "Iniciando análise proteômica específica\n";
        this.resultadoAnalise += "Separação de proteínas por eletroforese\n";
        this.resultadoAnalise += "Identificação por espectrometria de massa\n";
        this.resultadoAnalise += "Quantificação e análise funcional\n";
    }

}
