# Objetivo do Projeto
Criar um sistema microservice, contendo tecnologias e patterns que esteja atualizado com o mercado. O projeto "Titan System" tem como objetivo solucionar a dificuldade e lentidão nos processoss de autenticacao e prontuário de 
forma incialmente genérica dentro da área da saúde.

# Escopo - Autenticação
1. Cadastro de Usuários:
   * Autenticação dos usuários (profissionais da saúde) no sistema.
   * Login de usuário
   * Cadastro de usuário
   * Refresh Token
2. Cadastro de Clínicas:
   * Dentro do processo da 1ª autenticação é criado automaticamente a clinica para o usuário.
   * Cadastro de clínicas associadas ao mesmo contexto.
3. Refresh Token
   * Ao passaar um token GERADO PELO SISEMA, caso este não estaja valido, ele retornar outro atualizado
     
# Escopo - Prontuário  
1. Cadastro de Pacientes:
   * Cadastro de pacientes no contexto da clínica.
3. Cadastro do Atendimento:
   * Cadastro do atendimento corrente associado ao paciente.
4. Cadastro de Exames ou Procedimentos:
   * Cadastro do exame ou procedimento corrente associado ao paciente.
5. Cadastro de Diagnostico:
   * Associar o diagnostico ao atendimento do paciente.

[Diagrama de Class - Autenticação.](https://drive.google.com/file/d/1b2ZfbuJPC8Hl_Ax63KNcNOmy5iB6_-FP/view?usp=sharing)
</br>
[Diagrama de Class - Prontuário.](https://drive.google.com/file/d/1ya_HN1U8zHoBY0eif-SlZtzZEfR68gDM/view?usp=sharing)

# Requisitos do Projeto
**Requisitos Funcionais:**

**1. Cadastro de Usuários**:
   * **Descrição**: O sistema deve realizar a autenticação do usuário com sucesso
   * **Funcionalidades**:
     * Autenticaçã com JWT.
     * Atribuição de funções.
     * Refresh Token
       
**2. Cadastro de Clínicas**:
   * **Descrição**: O sistema de possibilitar cadastrar a clínica diante do contexto.
   * **Funcionalidades**:
     * Primerio acesso, primiera clínica.
     * Cadastro de clínicas diante do mesmo contexto.
       
**3. Cadastro de Pacientes**:
   * **Descrição**: O sistema de possibilitar cadastrar os pacientes corretamente, bem como suas demais informacoes.
   * **Funcionalidades**:
     * Cadastrar informações do paciente.
       
**4. Cadastro de Atendimento**:
   * **Descrição**: O sistema de possibilitar cadastrar o atendimento associado ao paciente.
   * **Funcionalidades**:
     * Cadastrar informações do atendimento
     * Cadastrar exames fisico
     * Cadastrar diagnostico
     * Cadastrar exames e procedimentos
   
**Requisitos Não Funcionais:**
     
**1. Testes e Unitários:**
   * **Descrição:** O sistema deve conter todos cobrir todos os casos de uso do sistema.

## Pacotes de Entrega
### Pacote 1: Autenticação por JWT
  1. Configuração de dependências
  2. Configuração multi tenant
  3. Sign-in
  4. Sign-up
  5. Autenticar com JWT
  6. Criar nova clínica
  7. Cadastrar/editar/excluir profissional

### Pacote 2: Prontuário
  1. Cadastrar/editar/excluir paciente
  2. Cadastrar/editar/excluir atendimento
  3. Cadastrar/editar/excluir exames e procedimentos
  5. Cadastrar/editar/excluir diagnostico
      
Para mais informações das tarefas e [Board.](https://trello.com/b/A4cHrFPL/downstream-titan-system)
---
A documentação completa no "Sistema Titan" esta no Notion para melhorar orientar sobre a utilização, tecnologias e arquitetura do serviço. Link do notion público: https://fog-germanium-bf4.notion.site/10383144da5f44a994f968761faf5da1?v=b4f90c419f314b63abba148b04893a4b
