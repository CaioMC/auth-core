# Objetivo do Projeto
Criar um sistema microservice, contendo tecnologias e patterns que esteja atualizado com o mercado. O projeto "Titan System" tem como objetivo solucionar a dificuldade e lentidão nos processoss de autenticacao, prontuário, agendamento e estoque de 
forma incialmente genérica dentro da área da saúde.

# Escopo - Autenticação
1. Cadastro de Usuários:
   * Autenticação dos usuários (profissionais da saúde) no sistema.
   * Cadastro de usuários a partir de um usuário com acesso.
   * Papeis dentro do sistema (ADMINISTRADOR, PROFISSIONAL_SAUDE e AUXILIAR).
2. Cadastro de Clínicas:
   * Dentro do processo da 1ª autenticação é criado automaticamente a clinica para o usuário.
   * Cadastro de clínicas associadas ao mesmo contexto.
3. Cadastro de Telefone para Clínicas:
   * Cadastrar 1 ou mais números de telefone.
     
# Escopo - Prontuário  
1. Cadastro de Pacientes:
   * Cadastro de pacientes no contexto da clínica.
2. Cadastro dos Familiares do Paciente:
   * Cadastro de familiares do paciente.
3. Cadastro do Atendimento:
   * Cadastro do atendimento corrente associado ao paciente.
4. Cadastro de Exames ou Procedimentos:
   * Cadastro do exame ou procedimento corrente associado ao paciente.
5. Cadastro de Diagnostico:
   * Associar o diagnostico ao atendimento do paciente.
6. Cadastro de Prescrição:
   * Cadastro de medicamentos associado a prescrição.
   * Cadastro de Exames associado a prescrição.
   * Cadastro de Vacinas associado a prescrição.
# Escopo - Agendamento
1. Cadastro de Agendamento:
   * Cadastrar informações necessárias para agendamento.
   * Associação do paciente

[Diagrama de Class - Autenticação.](https://drive.google.com/file/d/1b2ZfbuJPC8Hl_Ax63KNcNOmy5iB6_-FP/view?usp=sharing)
</br>
[Diagrama de Class - Prontuário.](https://drive.google.com/file/d/1ya_HN1U8zHoBY0eif-SlZtzZEfR68gDM/view?usp=sharing)
</br>
[Diagrama de Class - Agendamento.](https://drive.google.com/file/d/1jgE11twu_746vlSKV8eWSSAQoO17TnhP/view?usp=sharing)
</br>
     
# Stack e Arquitetura do Projeto
## Backend
  * Java 17
  * Spring boot
  * Flyway
  * Maven 3.6.3
  * Postgresql
  * JUnit
  * Swagger
  * Spring Security
  * JWT
  * CQRS
  * DDD
### Como vai funcionar:
  1. [Documentação sobre o funcionamento do projeto com CQRS.](https://fog-germanium-bf4.notion.site/CQRS-Command-Query-Responsibility-Segregation-1dbdb39ff4c747fcb2e88c9b47d285b5)

## Frontend
  * Angular 13
  * Node

# Requisitos do Projeto
**Requisitos Funcionais:**

**1. Cadastro de Usuários**:
   * **Descrição**: O sistema deve realizar a autenticação do usuário com sucesso associando seus papeis (ADMINISTRADOR, PROFISSIONAL_SAUDE e AUXILIAR)
   * **Funcionalidades**:
     * Autenticaçã com JWT.
     * Atribuição de funções.
       
**2. Cadastro de Clínicas**:
   * **Descrição**: O sistema de possibilitar cadastrar a clínica diante do contexto.
   * **Funcionalidades**:
     * Primerio acesso ADM, primiera clínica.
     * Cadastro de clínicas diante do mesmo contexto.
       
**3. Cadastro de Pacientes**:
   * **Descrição**: O sistema de possibilitar cadastrar os pacientes corretamente, bem como suas demais informacoes.
   * **Funcionalidades**:
     * Cadastrar informações do paciente.
     * Cadastrar vínculos familiares.
       
**4. Cadastro de Atendimento**:
   * **Descrição**: O sistema de possibilitar cadastrar o atendimento associado ao paciente.
   * **Funcionalidades**:
     * Cadastrar informações do atendimento
     * Cadastrar exames
     * Cadastrar diagnostico
     * Cadastrar exames e procedimentos
     * Cadastrar Prescrição - exames, medicamentos e vacinas
   
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
  7. Cadastrar/editar/excluir telefone clinica
  8. Cadastrar/editar/excluir profissional

### Pacote 2: Prontuário
  1. Cadastrar/editar/excluir paciente
  2. Cadastrar/editar/excluir atendimento
  3. Cadastrar/editar/excluir exames e procedimentos
  5. Cadastrar/editar/excluir diagnostico
  6. Cadastrar/editar/excluir Prescrição - exames, medicamentos e vacinas
      
### Pacote 3: Agendamento
  1. Cadastrar/editar/excluir agendamento

Para mais informações das tarefas e [Board.](https://trello.com/b/A4cHrFPL/downstream-titan-system)
