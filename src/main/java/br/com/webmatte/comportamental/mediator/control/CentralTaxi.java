package br.com.webmatte.comportamental.mediator.control;

import br.com.webmatte.comportamental.mediator.entity.Passageiro;
import br.com.webmatte.comportamental.mediator.entity.Taxi;
import br.com.webmatte.comportamental.mediator.exception.TaxiInterruptedException;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
@Slf4j
public class CentralTaxi {

    private List<Taxi> taxisLivres = new ArrayList<>();
    private List<Passageiro> passageirosEspera = new ArrayList<>();

    @Synchronized
    public void adicionaTaxiDisponivel(Taxi taxi) {
        log.info("Taxi {} voltou para a fila.", taxi.getId());
        this.taxisLivres.add(taxi);
        synchronized (this) {
            this.notifyAll();
        }
    }

    public void chamaTaxi(Passageiro passageiro) {
        Taxi taxi = this.esperaTaxi(passageiro);
        log.info("Taxi {} levando o passageiro {}", taxi.getId(), passageiro.getNome());
        synchronized (this) {
            this.taxisLivres.add(taxi);
            this.notifyAll();
        }
    }

    private Taxi esperaTaxi(Passageiro passageiro) {
        this.passageirosEspera.add(passageiro);
        synchronized (this) {
            while (this.taxisLivres.isEmpty() || !this.passageirosEspera.get(0).equals(passageiro)) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new TaxiInterruptedException("Thread interrupted while waiting for taxi", e);
                }
            }
            this.passageirosEspera.remove(0);
            return this.taxisLivres.remove(0);
        }
    }

}
