package mediator.control;

import mediator.entity.Passageiro;
import mediator.entity.Taxi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class CentralTaxi {

    private List<Taxi> taxisLivres = new ArrayList<Taxi>();
    private List<Passageiro> passageirosEspera = new ArrayList<Passageiro>();

    public synchronized void adicionaTaxiDisponivel(Taxi taxi) {
        System.out.println("Taxi " + taxi.getId() + " voltou para a fila.");
        this.taxisLivres.add(taxi);
        this.notifyAll();
    }

    public void chamaTaxi(Passageiro passageiro) {
        Taxi taxi = this.esperaTaxi(passageiro);
        System.out.println("Taxi " + taxi.getId() + " levando o passageiro " + passageiro.getNome());
        this.taxisLivres.add(taxi);
        this.notifyAll();
    }

    private Taxi esperaTaxi(Passageiro passageiro) {
        this.passageirosEspera.add(passageiro);
        synchronized (this) {
            while (this.taxisLivres.isEmpty() || !this.passageirosEspera.get(0).equals(passageiro)) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.passageirosEspera.remove(0);
            return this.taxisLivres.remove(0);
        }
    }

}
