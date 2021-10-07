package facade.control;

/**
 * @author Anderson Matte
 */
public class Financeiro {

    public void fatura(String cliente, String produto) {
        System.out.println("Fatura: ");
        System.out.println("Cliente: " + cliente);
        System.out.println("Produto: " + produto);
    }

}
