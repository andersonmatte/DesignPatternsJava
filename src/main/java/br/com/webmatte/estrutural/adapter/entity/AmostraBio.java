package br.com.webmatte.estrutural.adapter.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class AmostraBio {

    private String codigo;
    private String sequenciaDNA;

    public AmostraBio(String codigo, String sequenciaDNA) {
        this.codigo = codigo;
        this.sequenciaDNA = sequenciaDNA;
    }

}
