package br.com.webmatte.comportamental.templatemethod;

/**
 * @author Anderson Matte
 */
public abstract class PipelineAnaliseBiologica {

    protected String resultadoAnalise = "";

    public void executarPipelineCompleto(String amostra) {
        this.prepararAmostra(amostra);
        this.realizarAnaliseEspecifica();
        this.gerarRelatorio();
    }

    private void prepararAmostra(String amostra) {
        this.resultadoAnalise += "Preparando amostra: " + amostra + "\n";
        this.resultadoAnalise += "Extração de DNA/RNA completada\n";
        this.resultadoAnalise += "Purificação da amostra realizada\n";
    }

    private void gerarRelatorio() {
        this.resultadoAnalise += "Gerando relatório final da análise\n";
        this.resultadoAnalise += "Análise concluída com sucesso\n";
    }

    public String getResultadoAnalise() {
        return resultadoAnalise;
    }

    protected abstract void realizarAnaliseEspecifica();

}
