# Design Patterns em Java - Sistema de Bioinformática

![alt text](https://github.com/andersonmatte/DesingPatternsJava/blob/main/javabio.png)

Este projeto demonstra a implementação de padrões de projeto (Design Patterns) em Java, aplicados a um sistema de
bioinformática para análise genômica e proteômica.

## Contexto do Sistema

O sistema simula um laboratório de bioinformática que realiza:

- **Sequenciamento de DNA/RNA** - Análise de material genético
- **Alinhamento de sequências** - Comparação com bases de dados de referência
- **Análise proteômica** - Estudo de proteínas e suas funções
- **Geração de relatórios** - Documentação dos resultados analíticos
- **Gerenciamento de equipamentos** - Controle de recursos laboratoriais

---

## Padrões de Criação

### Factory Method

**Propósito:** Definir interface para criar objeto, mas deixar subclasses decidirem qual classe instanciar.

**Implementação:** Criação de analisadores especializados baseados no tipo de dado:

- **Analisador FASTA:** Especializado em formato FASTA
- **Analisador GenBank:** Especializado em formato GenBank
- **Factory Method:** Delegação para subclasses específicas

```java
// Exemplo: Criação baseada no tipo de formato
AnalisadorSequencias factory = new AnalisadorFactory();
Analisador analisador = factory.criarAnalisador("FASTA");
analisador.

analisarSequencia("ATCGATCG");
```

### Abstract Factory

**Propósito:** Criar famílias de objetos relacionados sem especificar suas classes concretas.

**Implementação:** Sistema cria diferentes tipos de equipamentos laboratoriais (centrífugas, microscópios,
espectrofotômetros) especializados por tipo de laboratório:

- **Genética:** Equipamentos para análise de DNA/RNA
- **Bioquímica:** Equipamentos para análise química
- **Molecular:** Equipamentos para análise molecular

```java
// Exemplo: Factory cria equipamentos especializados
EquipamentoLaboratorialFactory factory = EquipamentoLaboratorialFactory.getFactory("genetica");
Centrifuga centrifugaGenetica = factory.criarCentrifuga();
```

### Builder

**Propósito:** Separar a construção de objetos complexos de sua representação.

**Implementação:** Construção de protocolos experimentais com múltiplos parâmetros:

- Nome do pesquisador
- Volume da amostra
- Tipo de análise
- Metodologia utilizada

```java
// Exemplo: Construção incremental de protocolo
ProtocoloExperimental protocolo = new GeradorDeProtocolo()
                .comNomePesquisador("Dr. Ana Silva")
                .comVolumeAmostra(15.5)
                .comTipoAnalise("Sequenciamento")
                .gerar();
```

### Prototype

**Propósito:** Criar novos objetos clonando objetos existentes.

**Implementação:** Clonagem de amostras biológicas para experimentos replicáveis:

- Preservação de dados genéticos
- Manutenção de marcadores
- Replicação de condições experimentais

```java
// Exemplo: Clonagem de amostra para múltiplos testes
AmostraBiologica amostraOriginal = new AmostraBiologica("AMOSTRA_001");
AmostraBiologica amostraClonada = amostraOriginal.clonar();
```

### Singleton

**Propósito:** Garantir que uma classe tenha apenas uma instância e fornecer ponto global de acesso.

**Implementação:** Gerenciador único de recursos laboratoriais:

- **Instância Única:** Apenas um gerenciador para todo o sistema
- **Acesso Global:** Ponto centralizado para obter recursos
- **Thread Safety:** Sincronização para ambientes concorrentes

```java
// Exemplo: Acesso único ao gerenciador de recursos
GerenciadorRecursos gerenciador = GerenciadorRecursos.getInstancia();
RecursoLaboratorial recurso = gerenciador.obterRecurso("Microscopio");
```

### Multiton

**Propósito:** Permitir múltiplas instâncias nomeadas com controle sobre sua criação.

**Implementação:** Pool de instâncias específicas de analisadores:

- **Instâncias Nomeadas:** Diferentes configurções por nome
- **Cache Controlado:** Gerenciamento do ciclo de vida
- **Reutilização:** Compartilhamento controlado de objetos

```java
// Exemplo: Instâncias nomeadas de analisadores
AnalisadorSequencias analisador1 = MultitonFactory.getInstancia("RAPIDO");
AnalisadorSequencias analisador2 = MultitonFactory.getInstancia("PRECISO");
```

### Object Pool

**Propósito:** Reutilizar objetos caros de criação, otimizando performance.

**Implementação:** Pool de equipamentos laboratoriais compartilhados:

- Centrífugas de alta velocidade
- Microscópios eletrônicos
- Sistema de alocação/liberação

```java
// Exemplo: Reutilização de equipamentos escassos
EquipamentoLaboratorial equipamento = pool.adquirirEquipamento();
// ... uso do equipamento ...
pool.

liberarEquipamento(equipamento);
```

---

## Padrões Estruturais

### Adapter

**Propósito:** Permitir que interfaces incompatíveis trabalhem juntas.

**Implementação:** Adaptador unifica diferentes formatos de análise:

- **FASTA:** Formato padrão de sequências
- **GenBank:** Formato com metadados estruturados
- **Analisador Unificado:** Interface comum para todos os formatos

```java
// Exemplo: Adaptação de formatos diferentes
AnalisadorAdapter adapter = new AnalisadorAdapter(analisadorUnificado);
adapter.

analisar(amostraBio, "FASTA");
```

### Bridge

**Propósito:** Desacoplar abstração da implementação, permitindo variação independente.

**Implementação:** Separação entre tipo de análise e algoritmo de processamento:

- **Análises Genômicas:** Sequenciamento, alinhamento, expressão
- **Algoritmos:** Needleman-Wunsch, BLAST, Smith-Waterman

```java
// Exemplo: Combinação flexível de análises e algoritmos
AnaliseGenomica analise = new AnaliseGenomica("Expressão", "RNA-Seq", algoritmoAlinhamento);
analise.

executarAnalise(dadosSequencia);
```

### Composite

**Propósito:** Compor objetos em estruturas de árvore, tratando individuais e composições uniformemente.

**Implementação:** Estrutura hierárquica de sequências genéticas:

- **Genes:** Componentes complexos com múltiplos nucleotídeos
- **Nucleotídeos:** Componentes básicos individuais
- **Proteínas:** Componentes compostos

```java
// Exemplo: Estrutura recursiva de componentes genéticos
ComponenteGenetico gene = new Gene("GENE_HBB");
gene.

adicionar(new Nucleotideo('A'));
        gene.

adicionar(new Nucleotideo('T'));
```

### Decorator

**Propósito:** Adicionar responsabilidades dinamicamente a objetos.

**Implementação:** Enriquecimento funcional de análises genômicas:

- **Análise Base:** Funcionalidade fundamental de análise
- **Com Validação:** Adição de verificação de dados
- **Com Relatório:** Adição de geração de relatórios
- **Composição:** Múltiplas camadas de funcionalidade

```java
// Exemplo: Enriquecimento dinâmico de análise
AnaliseBio analiseBase = new AnaliseBasica();
AnaliseBio analiseValidada = new AnaliseComValidacao(analiseBase);
AnaliseBio analiseComRelatorio = new AnaliseComRelatorio(analiseValidada);
analiseComRelatorio.

executar(dados);
```

### Facade

**Propósito:** Fornecer interface simplificada para subsistemas complexos.

**Implementação:** Fachada unificada para análise genômica completa:

- **Sequenciamento:** Extração e preparação de amostras
- **Alinhamento:** Comparação com referências
- **Análise:** Processamento e interpretação
- **Relatório:** Geração de resultados

```java
// Exemplo: Interface simplificada para análise completa
SistemaBioinformaticaFacade facade = new SistemaBioinformaticaFacade();
facade.

executarAnaliseCompleta(analiseGenomica);
```

### Flyweight

**Propósito:** Compartilhar estado intrínseco para otimizar uso de memória.

**Implementação:** Compartilhamento de dados genéticos entre múltiplas análises:

- **Dados Proteicos:** Sequências de aminoácidos compartilhadas
- **Estado Extrínseco:** Contexto específico de cada análise
- **Cache:** Reutilização eficiente de estruturas

```java
// Exemplo: Compartilhamento de dados entre análises
DadoGeneticoFlyweight proteina = DadoGeneticoFlyweightFactory.getDado(DadoProteina.class);
proteina.

exibirDado("GENE_001","Contexto específico");
```

### Front Controller

**Propósito:** Centralizar requisições e fornecer tratamento unificado.

**Implementação:** Controlador frontal para sistema de bioinformática:

- **Roteamento:** Direcionamento para módulos específicos
- **Validação:** Verificação de parâmetros e permissões
- **Tratamento:** Gerenciamento de erros e exceções

```java
// Exemplo: Centralização de requisições do sistema
frontController.processarRequisicao("sequenciamento/executar","AMOSTRA_001");
frontController.

processarRequisicao("alinhamento/executar","REFERENCIA_001");
```

### Proxy

**Propósito:** Controlar acesso a objetos, fornecendo interface intermediária.

**Implementação:** Proxy de segurança para banco de dados genéticos:

- **Controle de Acesso:** Validação de permissões de usuários
- **Cache:** Otimização de consultas frequentes
- **Logging:** Registro de operações de acesso

```java
// Exemplo: Controle de acesso seguro ao banco de dados
BancoDadosGeneticos proxy = new BancoDadosGeneticosProxy(bancoDadosReais);
proxy.

buscarSequencia("ATCGATCG","pesquisador");
```

---

## Padrões Comportamentais

### Command

**Propósito:** Encapsular requisições como objetos, permitindo parametrização, fila e operações.

**Implementação:** Sistema de comandos para operações laboratoriais:

- **Sequenciar:** Execução de sequenciamento de amostras
- **Alinhar:** Realização de alinhamentos genéticos
- **Analisar:** Processamento de dados proteômicos
- **Desfazer:** Reversão de operações executadas
- **Invocador:** Gerenciador de fila de comandos

```java
// Exemplo: Sistema de comandos para operações laboratoriais
InvocadorComandos invocador = new InvocadorComandos();
invocador.

executarComando(new SequenciarCommand(amostra));
        invocador.

executarComando(new AlinharCommand(sequencia));
        invocador.

desfazerUltimoComando();
```

### Iterator

**Propósito:** Acessar elementos de coleções sem expor estrutura interna.

**Implementação:** Iteração sobre resultados de análises genéticas:

- **Sequências:** Navegação por dados sequenciados
- **Proteínas:** Iteração sobre estruturas proteicas
- **Resultados:** Percorrer análises processadas
- **Abstração:** Interface unificada para diferentes coleções

```java
// Exemplo: Iteração sobre diferentes tipos de resultados
Iterator<ResultadoAnalise> sequencias = resultadosSequenciamento.getIterator();
Iterator<ResultadoAnalise> proteinas = resultadosProteomicos.getIterator();

while(sequencias.

hasNext()){
ResultadoAnalise resultado = sequencias.next();
// processar resultado...
}
```

### Mediator

**Propósito:** Definir objeto que centraliza comunicação entre outros objetos.

**Implementação:** Coordenador de análises genômicas:

- **Sincronização:** Coordenação entre diferentes etapas
- **Comunicação:** Troca de dados entre módulos
- **Orquestração:** Gerenciamento do fluxo de trabalho
- **Desacoplamento:** Redução de dependências diretas

```java
// Exemplo: Coordenador centralizando comunicação
CoordenadorAnalise coordenador = new CoordenadorAnalise();
Sequenciador sequenciador = new Sequenciador(coordenador);
Alinhador alinhador = new Alinhador(coordenador);

// Mudança em um componente notifica outros via coordenador
sequenciador.

finalizarAnalise(); // Notifica alinhador automaticamente
```

### Observer

**Propósito:** Definir dependência um-para-muitos, notificando mudanças automaticamente.

**Implementação:** Sistema de notificação de resultados experimentais:

- **Pesquisadores:** Observadores interessados em resultados
- **Análises:** Sujeitos que notificam conclusão
- **Eventos:** Mudanças de estado e conclusões
- **Notificação:** Atualização automática de múltiplos observadores

```java
// Exemplo: Sistema de notificação de resultados
Pesquisador pesquisador = new Pesquisador("Dr. Silva");
AnaliseGenomica analise = new AnaliseGenomica();
analise.

adicionarObservador(pesquisador);

// Quando análise concluída, todos os observadores são notificados
analise.

concluir(); // Dispara notificações automáticas
```

### State

**Propósito:** Permitir que objeto mude comportamento quando estado interno muda.

**Implementação:** Estados de equipamentos laboratoriais:

- **Disponível:** Pronto para uso, operações básicas
- **Em Uso:** Ocupado em análise, operações limitadas
- **Manutenção:** Indisponível temporariamente, operações de manutenção
- **Comportamento:** Varia conforme estado atual

```java
// Exemplo: Comportamento variando conforme estado
EquipamentoLaboratorial equipamento = new Microscopio();
equipamento.

setEstado(new EstadoDisponivel());
        equipamento.

ligar(); // Funciona normalmente

equipamento.

setEstado(new EstadoEmUso());
        equipamento.

ligar(); // Retorna mensagem: "Equipamento em uso"

equipamento.

setEstado(new EstadoManutencao());
        equipamento.

ligar(); // Retorna mensagem: "Equipamento em manutenção"
```

### Template Method

**Propósito:** Definir esqueleto de algoritmo, delegando passos específicos para subclasses.

**Implementação:** Pipeline de análise biológica com estrutura fixa:

- **Estrutura Comum:** Preparação → Extração → Processamento → Finalização
- **Variações:** Passos específicos por tipo de análise
- **Extensibilidade:** Novos tipos de análise sem modificar estrutura
- **Controle:** Ordem fixa de execução garantida

```java
// Exemplo: Pipeline com estrutura fixa e variação nos detalhes
PipelineAnaliseBiologica analiseProteomica = new AnaliseProteomica();
analiseProteomica.

executarAnaliseCompleta();
// Resultado: Preparar → Extrair → Analisar Específico → Finalizar

PipelineAnaliseBiologica analiseGenomica = new AnaliseGenomica();
analiseGenomica.

executarAnaliseCompleta();
// Resultado: Preparar → Extrair → Analisar Específico → Finalizar
```

### Strategy

**Propósito:** Definir família de algoritmos, encapsular cada um e torná-los intercambiáveis.

**Implementação:** Algoritmos de alinhamento de sequências genéticas:

- **Alinhamento Global:** Needleman-Wunsch para sequências completas
- **Alinhamento Local:** Smith-Waterman para melhores subsequências
- **Contexto:** Análise bioinformática com algoritmo selecionável
- **Intercambiabilidade:** Troca dinâmica de estratégias

```java
// Exemplo: Seleção dinâmica de algoritmo de alinhamento
AnaliseBioinformatica analise = new AnaliseBioinformatica();
analise.setAlgoritmo(new AlgoritmoAlinhamentoGlobal());
analise.executarAlinhamento("ATCG", "ATGG"); // Usa alinhamento global

analise.setAlgoritmo(new AlgoritmoAlinhamentoLocal());
analise.executarAlinhamento("ATCG", "ATGG"); // Usa alinhamento local
```

### Visitor

**Propósito:** Adicionar novas operações a estrutura de objetos sem modificá-los.

**Implementação:** Operações de análise sobre estruturas genéticas:

- **Genes de Proteína:** Análise de expressão gênica
- **Genes Reguladores:** Análise de função regulatória
- **Visitantes:** Novas análises sem alterar classes existentes
- **Double Dispatch:** Operação baseada em tipo de visitante e elemento

```java
// Exemplo: Adição de novas análises sem modificar estruturas
AnaliseMolecular visitor = new AnalisadorMolecular();
geneProteina.

aceitar(visitor);
geneRegulador.

aceitar(visitor);

// O mesmo visitante pode analisar diferentes tipos de genes
String resultadoProteina = visitor.getResultado(); // Contém análise de expressão
String resultadoRegulador = visitor.getResultado(); // Contém análise de função
```

---

## Benefícios dos Padrões no Contexto Bioinformático

1. **Flexibilidade:** Troca de algoritmos de alinhamento sem modificar análises
2. **Reusabilidade:** Equipamentos compartilhados entre experimentos
3. **Manutenibilidade:** Separação clara entre tipos de dados e processamento
4. **Escalabilidade:** Pools de objetos para lidar com grande volume de dados
5. **Segurança:** Proxy controlando acesso a dados sensíveis
6. **Performance:** Flyweight otimizando memória em análises em massa

## Como Executar

```bash
# Compilar o projeto
mvn compile

# Executar todos os testes
mvn test

# Executar teste específico
mvn test -Dtest="NomeDoPadraoTest"
```

## Fonte de Estudos

Baseado em [Refactoring.Guru](https://refactoring.guru/pt-br/design-patterns/java) com adaptações para o contexto de
bioinformática.
