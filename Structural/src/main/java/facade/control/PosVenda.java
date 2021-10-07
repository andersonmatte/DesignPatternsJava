package facade.control;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class PosVenda {

    public void agendaContatoComCliente(String cliente, String produto) {
        System.out.println("Entrar em contato com o cliente: " + cliente
                + " \nsobre o produto adquirido " + produto
                + " \nno dia " + LocalDate.now());
    }

}
