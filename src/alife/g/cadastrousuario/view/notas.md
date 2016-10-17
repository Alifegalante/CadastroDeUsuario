Aula de Segunda
	
	Alteração no projeto para criptografar a senha
	
		Adicionar um botão "inserir/alterar" senha
			mover o código da validação de senha e confirmação para o action performed do botão
			caso seja válidado ainda no botão gerar hash MD5 e armazenar em uma variavel privada que deve ser adicionada no formulario
	
				MessageDigest md = MessageDigest.getInstance("MD5");
				BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
				String.format("%32x";, hash); 
				
			limpar campos de senha
			emitir mensagem e informar que deve salvar para a alteração validar
	
		alterar o receber form, tirando os codigos que setam os campos de senha e setando a senha na variável do form
			
		na validação verificar se o campo senha do form é não é nulo, se for nulo não deixar salvar o usuário
		
	no habilitar e no desabilitar campos alterar o status do botão	
