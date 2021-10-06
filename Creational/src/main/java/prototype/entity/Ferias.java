package prototype.entity;

import lombok.Getter;
import lombok.Setter;
import prototype.interfaces.Prototype;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Ferias implements Prototype<Ferias> {

    private String nome;
    private LocalDate vencimento;
    private Set<String> chaves;

    public Ferias(String nome, LocalDate vencimento, Set<String> chaves) {
        this.nome = nome;
        this.vencimento = vencimento;
        this.chaves = chaves;
    }

    @Override
    public Ferias clone() {
        String nome = "Cópia das férias:" + this.nome;
        LocalDate vencimento = (LocalDate) this.vencimento;
        Set<String> chaves = new HashSet<>(this.chaves);
        Ferias ferias = new Ferias(nome, vencimento, chaves);
        return ferias;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("-----------------------\n");
        buffer.append(" Tipo de Férias: ");
        buffer.append(this.nome + "\n");
        buffer.append(" Vencimento: " + this.vencimento);
        buffer.append(" Chaves: \n");
        for (String chaves : this.chaves) {
            buffer.append(" - " + chaves + "\n");
        }
        buffer.append("-----------------------\n");
        return buffer.toString();
    }

}
