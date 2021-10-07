package bridge.control;

import bridge.interfaces.Documento;
import bridge.interfaces.GeradorDeArquivo;

import java.io.FileNotFoundException;
import java.io.PrintStream;

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
        try {
            StringBuffer buffer = new StringBuffer();
            PrintStream printStream = new PrintStream("Recibo.txt");
            buffer.append("Recibo de Pagamento ");
            buffer.append("\nEmpresa: " + this.emissor);
            buffer.append("\nCliente: " + this.favorecido);
            buffer.append("\nValor " + this.valor);
            this.geradorDeArquivo.gerar(buffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
