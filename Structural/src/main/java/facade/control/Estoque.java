package facade.control;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class Estoque {

    public void enviaProduto(String produto, String enderecoEntrega) {
        System.out.println("O produto " + produto
                + " \nserá entregue no endereço " + enderecoEntrega
                + " \naté as 20h do dia " + LocalDate.now());
    }

}
