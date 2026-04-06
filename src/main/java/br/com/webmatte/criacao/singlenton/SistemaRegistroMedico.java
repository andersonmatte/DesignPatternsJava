package br.com.webmatte.criacao.singlenton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
public class SistemaRegistroMedico {

    private static SistemaRegistroMedico instance;
    private Map<String, String> configuracoes;
    private boolean sistemaAtivo;

    private SistemaRegistroMedico() {
        this.configuracoes = new HashMap<>();
        this.configuracoes.put("hospital", "Hospital Central");
        this.configuracoes.put("departamento", "Genética Molecular");
        this.configuracoes.put("versao-sistema", "2.1.0");
        this.configuracoes.put("banco-dados", "PostgreSQL-BioMed");
        this.sistemaAtivo = true;
    }

    public static SistemaRegistroMedico getInstance() {
        if (SistemaRegistroMedico.instance == null) {
            SistemaRegistroMedico.instance = new SistemaRegistroMedico();
        }
        return SistemaRegistroMedico.instance;
    }

    public String getConfiguracao(String nomeConfiguracao) {
        return this.configuracoes.get(nomeConfiguracao);
    }

    public void registrarPaciente(String codigoPaciente, String diagnostico) {
        System.out.println("Registrando paciente " + codigoPaciente + " com diagnóstico: " + diagnostico);
        System.out.println("Hospital: " + getConfiguracao("hospital"));
        System.out.println("Departamento: " + getConfiguracao("departamento"));
    }

    public boolean isSistemaAtivo() {
        return sistemaAtivo;
    }

    public void desativarSistema() {
        this.sistemaAtivo = false;
        System.out.println("Sistema de Registro Médico desativado");
    }

}
