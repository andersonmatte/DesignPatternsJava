package br.com.webmatte.estrutural.composite.control;

import br.com.webmatte.estrutural.composite.interfaces.ComponenteSequencia;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class SequenciaComposta implements ComponenteSequencia {

    private List<ComponenteSequencia> componentes;

    public SequenciaComposta() {
        this.componentes = new ArrayList<>();
    }

    public void adicionar(ComponenteSequencia componente) {
        this.componentes.add(componente);
    }

    public void remover(ComponenteSequencia componente) {
        this.componentes.remove(componente);
    }

    @Override
    public void exibirSequencia() {
        System.out.println("Exibindo sequência composta:");
        for (ComponenteSequencia componente : this.componentes) {
            componente.exibirSequencia();
        }
        System.out.println("Tamanho total da sequência: " + getTamanho());
    }

    @Override
    public int getTamanho() {
        return this.componentes.stream()
                .mapToInt(ComponenteSequencia::getTamanho)
                .sum();
    }

}
