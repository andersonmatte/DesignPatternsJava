package facade.control;

import facade.entity.Pedido;

/**
 * @author Anderson Matte
 */
public class PedidoFacade {

    private Estoque estoque;
    private Financeiro financeiro;
    private PosVenda posVenda;

    public PedidoFacade(Estoque estoque, Financeiro financeiro, PosVenda posVenda) {
        this.estoque = estoque;
        this.financeiro = financeiro;
        this.posVenda = posVenda;
    }

    public void registraPedido(Pedido pedido) {
        this.estoque.enviaProduto(pedido.getProduto(), pedido.getEnderecoEntrega());
        this.financeiro.fatura(pedido.getCliente(), pedido.getProduto());
        this.posVenda.agendaContatoComCliente(pedido.getCliente(), pedido.getProduto());
    }

}
