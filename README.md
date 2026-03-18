# 🗳️ Urna Eletrônica - Estudo de POO

Este projeto é um simulador de Urna Eletrônica desenvolvido como parte dos estudos da disciplina de **Programação II** no curso de Sistemas de Informação do **ICEA/UFOP**. O objetivo principal é consolidar conceitos fundamentais de **Programação Orientada a Objetos (POO)** utilizando Java.

## 🚀 Tecnologias e Conceitos
* **Linguagem:** Java.
* **Encapsulamento:** Uso de atributos privados e métodos getters/setters para proteção de dados.
* **Tratamento de Exceções:** Implementação de blocos `try-catch` para validar entradas do usuário e garantir a estabilidade do sistema.
* **Coleções:** Uso de `ArrayList` para gerenciamento dinâmico de candidatos e cargos.

## 🧠 Estrutura do Projeto
O sistema foi modelado para refletir entidades do mundo real:

* **`Candidato`**: Armazena nome, número (validado para 3 dígitos) e a contagem individual de votos.
* **`Cargo`**: Gerencia a lista de candidatos específicos para aquela função, além dos votos brancos e nulos.
* **`Urna`**: Classe principal da interface (CLI) que controla o fluxo de cadastro, votação e apuração.

## 📋 Funcionalidades
1. **Cadastro Flexível:** Permite cadastrar múltiplos cargos e vincular candidatos a eles.
2. **Validação de Títulos:** Restrições para números de candidatos (ex: impede o uso de 000, 111 ou 999 como números válidos).
3. **Fluxo de Votação Realista:**
   * Voto nominal por número.
   * Voto em Branco (000).
   * Voto Nulo (números não cadastrados).
   * Confirmação ou correção de voto.
4. **Apuração Final:** Relatório detalhado de votos por candidato e cargo após o encerramento (código 999).

## 🛠️ Como Executar
1. Clone o repositório:
   ```bash
   git clone [https://github.com/gabrielpawlo/NOME_DO_REPOSITORIO.git](https://github.com/gabrielpawlo/NOME_DO_REPOSITORIO.git)
