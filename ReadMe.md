# Sistema de Locação de Veículos

Projeto Integrador desenvolvido na **FATESG — Faculdade de Tecnologia e Gestão**, com participação de múltiplas disciplinas do curso. O sistema tem como objetivo o gerenciamento de uma frota de veículos para fins de locação, permitindo o cadastro, controle e exportação de informações operacionais.

---

## Sobre o Projeto

O sistema realiza o registro de veículos mediante geração automática de identificadores únicos (IDs), armazenando atributos como placa, marca, modelo e ano de fabricação. Os dados são persistidos tanto em arquivo de texto quanto em planilha Excel, facilitando a consulta e o compartilhamento das informações.

Além do cadastro, a aplicação é capaz de gerar relatórios automatizados voltados à inteligência de negócios, contemplando indicadores de desempenho operacional e financeiro da frota.

---

## Tecnologias Utilizadas

| Categoria | Tecnologia |
|---|---|
| Linguagem de programação | Java (JDK 17+) |
| Ambiente de desenvolvimento | NetBeans IDE |
| Controle de versão | Git / GitHub |
| Comunicação e agilidade | Slack e reuniões de alinhamento |
| Gestão de cronograma | Gráfico de Gantt |

---

## Indicadores de Desempenho (KPIs)

O sistema produz relatórios automatizados com foco em Business Intelligence, abrangendo os seguintes indicadores:

- Consumo de combustível e custos operacionais por veículo
- Projeção de impostos (IPVA) e demais taxas aplicáveis
- Taxa de disponibilidade e utilização da frota

---

## Estrutura da Documentação

A documentação completa do projeto — incluindo diagramas de processos, levantamento de requisitos e especificações técnicas — está disponível no diretório `/docs` deste repositório.

---

## Como Executar o Projeto

**Pré-requisitos:** JDK 17 ou superior e Maven instalados na máquina.

```bash
# 1. Clone o repositório
git clone https://github.com/Caio4breu/ProjetoIntegradorFATESG.git

# 3. Navegue até a pasta compile o projeto
mvn clean install

# 4. Execute a aplicação
mvn exec:java
```

---

## Equipe

| Integrante |
|---|
| Alexander ([Alexsanei](https://github.com/Alexsanei)) |
| Caio Abreu ([Caio4breu](https://github.com/Caio4breu)) |
| Cassiano Abreu ([Nomscodes](https://github.com/Nomscodes)) |
| Gabriel Naoki ([GabrielNaokiUT](https://github.com/GabrielNaokiUT)) |
| Wyllian Mariano ([wyllianmn](https://github.com/wyllianmn)) |

---
  
## Instituição de Ensino

**FATESG — Faculdade de Tecnologia e Gestão**
Projeto Integrador — Disciplinas integradas ao desenvolvimento do sistema.
