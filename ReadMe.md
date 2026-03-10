# GynLog — Sistema de Gestão de Frota

Projeto Integrador desenvolvido na **FATESG — Faculdade de Tecnologia e Gestão**, com participação de múltiplas disciplinas do curso. O sistema tem como objetivo o gerenciamento de uma frota de veículos, permitindo o cadastro, controle de movimentações financeiras e geração de relatórios operacionais.

---

## Sobre o Projeto

O GynLog realiza o registro de veículos mediante geração automática de identificadores únicos (IDs), armazenando atributos como placa, marca, modelo e ano de fabricação. Os dados são persistidos tanto em arquivo de texto quanto em planilha Excel, facilitando a consulta e o compartilhamento das informações.

Além do cadastro, a aplicação gera relatórios automatizados voltados à inteligência de negócios, contemplando indicadores de desempenho operacional e financeiro da frota.

---

## Arquitetura

O projeto foi reestruturado seguindo a **Arquitetura em Camadas (Layered Architecture)**, aplicando o princípio de Separação de Responsabilidades (SoC). O fluxo de uma operação segue sempre esta ordem:

```
View → Controller → Service → Repository → Arquivo TXT / Excel
```

| Camada | Responsabilidade |
|---|---|
| `controller/` | Porta de entrada — valida dados básicos e delega ao Service |
| `model/` | Entidades de dados (Veiculo, Movimento, TipoDespesa) |
| `repository/` | Persistência e leitura dos arquivos TXT e Excel |
| `service/` | Regras de negócio e lógica de relatórios |
| `util/` | Utilitários de infraestrutura (ThemeAdm) |
| `view/` | Telas da aplicação — apenas captura eventos e chama o Controller |

---

## Estrutura de Pastas

```
src/main/java/grupoaravia/gynlog/
├── GynLog.java                         ← ponto de entrada
├── controller/
│   ├── VeiculoController.java
│   ├── MovimentoController.java
│   ├── DespesaController.java
│   └── RelatorioController.java
├── model/
│   ├── Veiculo.java
│   ├── Movimento.java
│   └── TipoDespesa.java
├── repository/
│   ├── ArquivoTXT_Veiculo.java
│   ├── ArquivoTXT_Movimento.java
│   ├── ArquivoTXT_Despesa.java
│   ├── ArquivoExcel_Veiculo.java
│   ├── ArquivoExcel_Movimento.java
│   └── ArquivoExcel_Despesa.java
├── service/
│   ├── GerarRelatorios.java
│   ├── relatorioDespesaTotalFrota.java
│   ├── relatorioDespesasVeiculo.java
│   ├── relatorioGastoMensalCombustivelTotalFrota.java
│   ├── relatorioIPVATotalAnualFrota.java
│   ├── relatorioTotalMultasVeiculo.java
│   └── relatorioVeiculosInativos.java
├── util/
│   └── ThemeAdm.java
└── view/
    ├── TelaInicio.java
    ├── TelaRegistroVeiculo.java
    ├── TelaListaVeiculo.java
    ├── TelaPesquisaVeiculo.java
    ├── TelaRegistroPrejuizo.java
    ├── TelaSlash.java
    └── telaGerarRelatorios.java

data/
├── Veiculo.txt
├── Veiculo.xlsx
├── Movimento.txt
├── Movimento.xlsx
├── Despesas.txt
└── Despesas.xlsx
```

---

## Tecnologias Utilizadas

| Categoria | Tecnologia |
|---|---|
| Linguagem de programação | Java (JDK 17+) |
| Ambiente de desenvolvimento | NetBeans IDE |
| Gerenciador de dependências | Maven |
| Exportação de planilhas | Apache POI |
| Controle de versão | Git / GitHub |
| Comunicação e agilidade | Slack e reuniões de alinhamento |
| Gestão de cronograma | Gráfico de Gantt |

---

## Indicadores de Desempenho (KPIs)

O sistema produz relatórios automatizados com foco em Business Intelligence, abrangendo os seguintes indicadores:

- Despesas totais por veículo
- Despesa mensal total da frota
- Gasto mensal de combustível da frota
- Total de multas por veículo em um ano
- IPVA total anual da frota
- Listagem de veículos inativos

---

## Como Executar o Projeto

**Pré-requisitos:** JDK 17 ou superior e Maven instalados na máquina.

```bash
# 1. Clone o repositório
git clone https://github.com/Caio4breu/ProjetoIntegradorFATESG.git

# 2. Navegue até a pasta e compile o projeto
cd ProjetoIntegradorFATESG
mvn clean install

# 3. Execute a aplicação
mvn exec:java
```

> Os arquivos de dados (`Veiculo.txt`, `Movimento.txt`, `Despesas.txt`) devem estar presentes na pasta `data/` antes de executar a aplicação. Exemplos de dados estão incluídos no repositório.

---

## Documentação

A documentação completa do projeto — incluindo diagramas de processos, levantamento de requisitos e especificações técnicas — está disponível no diretório `/docs` deste repositório.

---

## Equipe

| Integrante |
|---|
| Alexander Almeida ([Alexsanei](https://github.com/Alexsanei)) |
| Caio Abreu ([Caio4breu](https://github.com/Caio4breu)) |
| Cassiano Abreu ([Nomscodes](https://github.com/Nomscodes)) |
| Gabriel Naoki ([GabrielNaokiUT](https://github.com/GabrielNaokiUT)) |
| Wyllian Mariano ([wyllianmn](https://github.com/wyllianmn)) |

---

## Instituição de Ensino

**FATESG — Faculdade de Tecnologia e Gestão**  
Projeto Integrador — Disciplinas integradas ao desenvolvimento do sistema.