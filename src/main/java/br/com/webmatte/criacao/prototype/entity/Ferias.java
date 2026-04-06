package br.com.webmatte.criacao.prototype.entity;

import br.com.webmatte.criacao.prototype.interfaces.Prototype;
import lombok.Getter;
import lombok.Setter;

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

    public Ferias(Ferias other) {
        this.nome = other.nome;
        this.vencimento = other.vencimento;
        this.chaves = new HashSet<>(other.chaves); // Deep copy of the Set
    }

    public static Ferias copyOf(Ferias other) {
        return new Ferias(other);
    }

    @Override
    public Ferias copy() {
        return new Ferias(this);
    }

    public String toString() {
        var buffer = new StringBuilder();
        buffer.append("-----------------------\n");
        buffer.append(" Tipo de Férias: ");
        buffer.append(this.nome).append("\n");
        buffer.append(" Vencimento: ").append(this.vencimento);
        buffer.append(" Chaves: \n");
        for (String keys : this.chaves) {
            buffer.append(" - ").append(keys).append("\n");
        }
        buffer.append("-----------------------\n");
        return buffer.toString();
    }

}
