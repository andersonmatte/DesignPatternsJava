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
public class AmostraBiologica implements Prototype<AmostraBiologica> {

    private String codigo;
    private String tipo;
    private LocalDate dataColeta;
    private Set<String> marcadoresGeneticos;
    private String condicaoArmazenamento;

    public AmostraBiologica(String codigo, String tipo, LocalDate dataColeta,
                            Set<String> marcadoresGeneticos, String condicaoArmazenamento) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.dataColeta = dataColeta;
        this.marcadoresGeneticos = marcadoresGeneticos;
        this.condicaoArmazenamento = condicaoArmazenamento;
    }

    public AmostraBiologica(AmostraBiologica other) {
        this.codigo = other.codigo + "_CLONE";
        this.tipo = other.tipo;
        this.dataColeta = other.dataColeta;
        this.marcadoresGeneticos = new HashSet<>(other.marcadoresGeneticos); // Deep copy
        this.condicaoArmazenamento = other.condicaoArmazenamento;
    }

    public static AmostraBiologica copyOf(AmostraBiologica other) {
        return new AmostraBiologica(other);
    }

    @Override
    public AmostraBiologica copy() {
        return new AmostraBiologica(this);
    }

    public String toString() {
        var buffer = new StringBuilder();
        buffer.append("-----------------------\n");
        buffer.append(" Código Amostra: ");
        buffer.append(this.codigo).append("\n");
        buffer.append(" Tipo: ").append(this.tipo).append("\n");
        buffer.append(" Data Coleta: ").append(this.dataColeta).append("\n");
        buffer.append(" Condição Armazenamento: ").append(this.condicaoArmazenamento).append("\n");
        buffer.append(" Marcadores Genéticos: \n");
        for (String marcador : this.marcadoresGeneticos) {
            buffer.append(" - ").append(marcador).append("\n");
        }
        buffer.append("-----------------------\n");
        return buffer.toString();
    }

}
