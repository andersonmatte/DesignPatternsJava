package facade;

import facade.control.Estoque;
import facade.control.Financeiro;
import facade.control.PedidoFacade;
import facade.control.PosVenda;
import facade.entity.Pedido;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class PedidoFacadeTest {

    @Test
    public void testaPedidoFacade() {
        Estoque estoque = new Estoque();
        Financeiro financeiro = new Financeiro();
        PosVenda posVenda = new PosVenda();
        PedidoFacade pedidoFacade = new PedidoFacade(estoque, financeiro, posVenda);
        Pedido pedido = new Pedido("Smartphone", "Anderson Matte", "Rua Vinte e cinco de Janeiro, 78");
        pedidoFacade.registraPedido(pedido);
    }

}
