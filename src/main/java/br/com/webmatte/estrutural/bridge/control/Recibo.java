package br.com.webmatte.estrutural.bridge.control;

import br.com.webmatte.estrutural.bridge.interfaces.Documento;
import br.com.webmatte.estrutural.bridge.interfaces.GeradorDeArquivo;

/**
 * @author Anderson Matte
 */
public class Recibo implements Documento {

    private String emissor;
    private String favorecido;
    private Double valor;
    private GeradorDeArquivo geradorDeArquivo;

    public Recibo(String emissor, String favorecido, Double valor, GeradorDeArquivo geradorDeArquivo) {
        this.emissor = emissor;
        this.favorecido = favorecido;
        this.valor = valor;
        this.geradorDeArquivo = geradorDeArquivo;
    }

    @Override
    public void gerarArquivo() {
        String buffer = "Recibo de Pagamento " +
                "\nEmpresa: " + this.emissor +
                "\nCliente: " + this.favorecido +
                "\nValor " + this.valor;
        this.geradorDeArquivo.gerar(buffer);
    }

}
