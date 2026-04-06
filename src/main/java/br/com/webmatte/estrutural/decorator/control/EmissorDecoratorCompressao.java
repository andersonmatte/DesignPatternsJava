package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.Emissor;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/**
 * @author Anderson Matte
 */
@Slf4j
public class EmissorDecoratorCompressao extends EmissorDecorator {

    public EmissorDecoratorCompressao(Emissor emissor) {
        super(emissor);
    }

    @Override
    public void envia(String mensagem) {
        log.info("Enviando mensagem comprimida");
        String mensagemComprimida;
        try {
            mensagemComprimida = comprime(mensagem);
        } catch (IOException e) {
            mensagemComprimida = mensagem;
            e.printStackTrace();
        }
        this.getEmissor().envia(mensagemComprimida);
    }

    private String comprime(String mensagem) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream, new Deflater());
        deflaterOutputStream.write(mensagem.getBytes());
        deflaterOutputStream.close();
        return new String(outputStream.toByteArray());
    }

}
