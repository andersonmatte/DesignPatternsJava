package abstractFactory.interfaces;

/**
 * @author Anderson Matte
 */
public interface ComunicadorFactory {

    Emissor createEmissor();

    Receptor createRceptor();

}
