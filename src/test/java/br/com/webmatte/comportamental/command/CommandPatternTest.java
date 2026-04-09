package br.com.webmatte.comportamental.command;

import br.com.webmatte.comportamental.command.commands.SequenciarGene;
import br.com.webmatte.comportamental.command.control.SequenciadorDNA;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes do Padrão Command - Sequenciamento de DNA")
class CommandPatternTest {

    @Mock
    private SequenciadorDNA sequenciadorDNA;

    @Test
    @DisplayName("Deve executar comando de sequenciamento com sucesso")
    void deveExecutarComandoSequenciamentoComSucesso() throws InterruptedException {
        // Given
        String gene = "GENE_001";
        SequenciarGene comando = new SequenciarGene(sequenciadorDNA, gene);

        // When
        comando.executa();

        // Then
        verify(sequenciadorDNA, times(1)).sequenciarGene(gene);
    }

    @Test
    @DisplayName("Deve executar múltiplos comandos em sequência")
    void deveExecutarMultiplosComandosEmSequencia() throws InterruptedException {
        // Given
        String gene1 = "GENE_001";
        String gene2 = "GENE_002";
        String gene3 = "GENE_003";

        SequenciarGene comando1 = new SequenciarGene(sequenciadorDNA, gene1);
        SequenciarGene comando2 = new SequenciarGene(sequenciadorDNA, gene2);
        SequenciarGene comando3 = new SequenciarGene(sequenciadorDNA, gene3);

        // When
        comando1.executa();
        comando2.executa();
        comando3.executa();

        // Then
        verify(sequenciadorDNA, times(1)).sequenciarGene(gene1);
        verify(sequenciadorDNA, times(1)).sequenciarGene(gene2);
        verify(sequenciadorDNA, times(1)).sequenciarGene(gene3);
    }
}
