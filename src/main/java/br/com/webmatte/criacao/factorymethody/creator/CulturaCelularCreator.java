package br.com.webmatte.criacao.factorymethody.creator;

import br.com.webmatte.criacao.factorymethody.emissor.CulturaBacteriana;
import br.com.webmatte.criacao.factorymethody.emissor.CulturaCelularAnimal;
import br.com.webmatte.criacao.factorymethody.interfaces.CulturaCelular;

/**
 * @author Anderson Matte
 */
public class CulturaCelularCreator {

    public static final int BACTERIANA = 0;
    public static final int ANIMAL = 1;

    public CulturaCelular criar(int tipoCultura) {

        if (tipoCultura == BACTERIANA) {
            return new CulturaBacteriana();
        } else if (tipoCultura == ANIMAL) {
            return new CulturaCelularAnimal();
        } else {
            throw new IllegalArgumentException("Tipo de cultura celular não encontrado no sistema.");
        }
    }

}
