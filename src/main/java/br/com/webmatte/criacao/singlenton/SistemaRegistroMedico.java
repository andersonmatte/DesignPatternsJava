package br.com.webmatte.criacao.singlenton;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
@Slf4j
public class SistemaRegistroMedico {

    private static SistemaRegistroMedico instance;
    private final Map<String, String> configuracoes;
    private final Map<String, String> pacientes;
    @Getter
    private boolean sistemaAtivo;

    private SistemaRegistroMedico() {
        this.configuracoes = new HashMap<>();
        this.configuracoes.put("hospital", "Hospital Central");
        this.configuracoes.put("departamento", "Genética Molecular");
        this.configuracoes.put("versao-sistema", "2.1.0");
        this.configuracoes.put("banco-dados", "PostgreSQL-BioMed");
        this.sistemaAtivo = true;
        this.pacientes = new HashMap<>();
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
        log.info("Registrando paciente {} com diagnóstico: {}", codigoPaciente, diagnostico);
        log.info("Hospital: " + getConfiguracao("hospital"));
        log.info("Departamento: " + getConfiguracao("departamento"));
    }

    public void desativarSistema() {
        this.sistemaAtivo = false;
        log.info("Sistema de Registro Médico desativado");
    }

    public void adicionarPaciente(String nomePaciente) {
        this.pacientes.put(nomePaciente, "Paciente registrado");
    }

    public int getTotalPacientes() {
        return this.pacientes.size();
    }

    public boolean buscarPaciente(String nomePaciente) {
        return this.pacientes.containsKey(nomePaciente);
    }

}
