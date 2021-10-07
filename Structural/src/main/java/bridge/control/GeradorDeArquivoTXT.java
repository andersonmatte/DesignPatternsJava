package bridge.control;

import bridge.interfaces.GeradorDeArquivo;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Anderson Matte
 */
public class GeradorDeArquivoTXT implements GeradorDeArquivo {

    @Override
    public void gerar(String conteudo) {
        try {
            PrintStream printStream = new PrintStream("NovoArquivo.txt");
            printStream.println(conteudo);
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
