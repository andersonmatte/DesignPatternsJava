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

    public static CulturaCelular criarCultura(String tipo) {
        CulturaCelularCreator creator = new CulturaCelularCreator();

        return switch (tipo.toLowerCase()) {
            case "bacteriana" -> creator.criar(BACTERIANA);
            case "animal" -> creator.criar(ANIMAL);
            default -> throw new IllegalArgumentException("Tipo de cultura celular inválido: " + tipo);
        };
    }

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
