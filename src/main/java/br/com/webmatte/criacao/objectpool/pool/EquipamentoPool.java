package br.com.webmatte.criacao.objectpool.pool;

import br.com.webmatte.criacao.objectpool.entity.EquipamentoLaboratorial;
import br.com.webmatte.criacao.objectpool.interfaces.Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class EquipamentoPool implements Pool<EquipamentoLaboratorial> {

    private final Object lock = new Object();
    private final List<EquipamentoLaboratorial> equipamentosDisponiveis;

    public EquipamentoPool() {
        this.equipamentosDisponiveis = new ArrayList<>();
        this.equipamentosDisponiveis.add(new EquipamentoLaboratorial("Microscópio Eletrônico"));
        this.equipamentosDisponiveis.add(new EquipamentoLaboratorial("Centrífuga"));
        this.equipamentosDisponiveis.add(new EquipamentoLaboratorial("Espectrômetro de Massa"));
        this.equipamentosDisponiveis.add(new EquipamentoLaboratorial("Termociclador"));
        this.equipamentosDisponiveis.add(new EquipamentoLaboratorial("Incubadora CO₂"));
    }

    @Override
    public EquipamentoLaboratorial acquire() {
        synchronized (lock) {
            if (!this.equipamentosDisponiveis.isEmpty()) {
                EquipamentoLaboratorial equipamento = this.equipamentosDisponiveis.remove(0);
                equipamento.setEmUso(true);
                return equipamento;
            } else {
                return null;
            }
        }
    }

    public EquipamentoLaboratorial adquirirEquipamento() throws InterruptedException {
        EquipamentoLaboratorial equipamento = acquire();
        while (equipamento == null) {
            Thread.sleep(50); // Wait and retry
            equipamento = acquire();
        }
        return equipamento;
    }

    @Override
    public void release(EquipamentoLaboratorial equipamento) {
        synchronized (lock) {
            if (equipamento != null) {
                equipamento.setEmUso(false);
                this.equipamentosDisponiveis.add(equipamento);
            }
        }
    }

    public void liberarEquipamento(EquipamentoLaboratorial equipamento) {
        release(equipamento);
    }

    public int getEquipamentosDisponiveis() {
        synchronized (lock) {
            return this.equipamentosDisponiveis.size();
        }
    }
}
