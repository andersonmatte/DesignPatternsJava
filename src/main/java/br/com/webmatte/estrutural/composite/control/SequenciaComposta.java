package br.com.webmatte.estrutural.composite.control;

import br.com.webmatte.estrutural.composite.interfaces.ComponenteSequencia;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
@Slf4j
public class SequenciaComposta implements ComponenteSequencia {

    private final List<ComponenteSequencia> componentes;

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
        log.info("Exibindo sequência composta:");
        for (ComponenteSequencia componente : this.componentes) {
            componente.exibirSequencia();
        }
        log.info("Tamanho total da sequência: " + getTamanho());
    }

    @Override
    public int getTamanho() {
        return this.componentes.stream()
                .mapToInt(ComponenteSequencia::getTamanho)
                .sum();
    }

}
