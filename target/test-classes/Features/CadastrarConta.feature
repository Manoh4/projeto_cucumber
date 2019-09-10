#language: pt
Funcionalidade: Cadastro de contas

Como um usuário 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#@Ignore
Cenário: Deve inserir uma conta com sucesso
Dado que estou acessando a aplicação
Quando informo o usuário "emanuel.estevao2.479@gmail.com"
E a senha "Sorria123"
E seleciono entrar
Então visualizo a página inicial
Quando seleciono Contas
E seleciono Adicionar
E informo a conta "Conta de Teste"
E seleciono Salvar
Então a conta é inserida com sucesso

#@Ignore
Cenário: Não deve inserir uma conta sem nome
Dado que estou acessando a aplicação
Quando informo o usuário "emanuel.estevao2.479@gmail.com"
E a senha "Sorria123"
E seleciono entrar
Então visualizo a página inicial
Quando seleciono Contas
E seleciono Adicionar
E seleciono Salvar
Então sou notificado que o nome da conta é obrigatório

#@Ignore
Cenário: Não deve inserir uma conta com nome já existente
Dado que estou acessando a aplicação
Quando informo o usuário "emanuel.estevao2.479@gmail.com"
E a senha "Sorria123"
E seleciono entrar
Então visualizo a página inicial
Quando seleciono Contas
E seleciono Adicionar
E informo a conta "Conta de Teste"
E seleciono Salvar
Então sou notificado que já existe uma conta com esse nome
	