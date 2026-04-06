package br.com.webmatte.criacao.objectpool.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class EquipamentoLaboratorial {

    private String nome;
    private boolean emUso;

    public EquipamentoLaboratorial(String nome) {
        this.nome = nome;
        this.emUso = false;
    }

}
