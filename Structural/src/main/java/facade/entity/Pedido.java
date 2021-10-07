package facade.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Pedido {

    private String produto;
    private String cliente;
    private String enderecoEntrega;

    public Pedido(String produto, String cliente, String enderecoEntrega) {
        this.produto = produto;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

}
