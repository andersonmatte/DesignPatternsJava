package br.com.webmatte.estrutural.proxy.control;

import br.com.webmatte.estrutural.proxy.interfaces.BancoDadosGeneticos;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
@Slf4j
public class BancoDadosGeneticosReal implements BancoDadosGeneticos {

    private final Map<String, String> sequencias = new HashMap<>();
    private final Map<String, String> usuariosAutorizados = new HashMap<>();

    public BancoDadosGeneticosReal() {
        // Dados de exemplo
        sequencias.put("AMOSTRA_001", "ATCGATCGATCGATCG");
        sequencias.put("AMOSTRA_002", "GCTAGCTAGCTAGCTA");
        sequencias.put("AMOSTRA_003", "TTAGGCTTAGGCTTAG");

        usuariosAutorizados.put("pesquisador", "bio123");
        usuariosAutorizados.put("analista", "gen456");
    }

    @Override
    public String buscarSequencia(String codigoAmostra) {
        log.info("Acessando banco de dados reais...");
        String sequencia = sequencias.get(codigoAmostra);
        log.info("Sequência encontrada: {}", sequencia);
        return sequencia;
    }

    @Override
    public void salvarResultado(String codigoAmostra, String resultado) {
        log.info("Salvando resultado no banco de dados reais...");
        log.info("Amostra: {} - Resultado: {}", codigoAmostra, resultado);
        // Simulação de salvamento
        sequencias.put("RESULTADO_" + codigoAmostra, resultado);
    }

    @Override
    public boolean verificarAcesso(String usuario) {
        log.info("Verificando acesso no banco de dados reais...");
        boolean autorizado = usuariosAutorizados.containsKey(usuario);
        log.info("Usuário {} autorizado: {}", usuario, autorizado);
        return autorizado;
    }

}
