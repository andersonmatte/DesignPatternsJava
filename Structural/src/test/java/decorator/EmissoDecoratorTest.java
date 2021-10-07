package decorator;

import decorator.control.EmissorDecoratorCompressao;
import decorator.control.EmissorDecoratorCriptografia;
import decorator.control.EmissorSimples;
import decorator.interfaces.Emissor;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class EmissoDecoratorTest {

    String mensagemCriptografia = "Mensagem a ser criptografada ";
    String mensagem = "Mensagem a ser comprimida ";

    @Test
    public void testaEmissorCriptografia() {
        Emissor emissorCriptografia = new EmissorDecoratorCriptografia(new EmissorSimples());
        emissorCriptografia.envia(this.mensagemCriptografia);
    }

    @Test
    public void testaEmissorCompressao() {
        Emissor emissorCompressao = new EmissorDecoratorCompressao(new EmissorSimples());
        emissorCompressao.envia(this.mensagem);
    }

    @Test
    public void testaEmissorCriptografiaCompressao() {
        Emissor emissorCriptografiaCompressao = new EmissorDecoratorCriptografia(new EmissorDecoratorCompressao(new EmissorSimples()));
        emissorCriptografiaCompressao.envia(this.mensagemCriptografia + this.mensagem);
    }

}
