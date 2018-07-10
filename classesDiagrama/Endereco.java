package classesDiagrama;

// Autoria: Márcio Gomes Borges Jú(201703685)
//Classe que gera endereço dos cadastros

public class Endereco {
		
		protected static int geraid = 0;
		protected String id;
		private String tipe = "Residencial";
		private String tipoDeLogradouro;
		private String logradouro;
		private int numero;
		private String bairro;
		private String cidade;
		private String estado;
		private String cep;
		
                //Trecho de código que chama o método Endereço construtor q deve capturar a exceção CepInvalido que ele lança
		public Endereco(String tipe, String tipoDeLogradouro, String logradouro, int numero,
				String bairro, String cidade, String estado, String cep) throws CepInvalidoException {
			this.tipe = tipe;
			this.tipoDeLogradouro = tipoDeLogradouro;
			this.logradouro = logradouro;
			this.numero = numero;
			this.bairro = bairro;
			this.cidade = cidade;
			this.estado = estado;
			geraid++;//Incrementação do valor geraid a cada endereço criado
			id = String.valueOf(geraid);//Checagem de parametro, se é nulo ou nao
			setCep(cep);
		}

		public Endereco(String tipoDeLogradouro, String logradouro, int numero, String bairro, String cidade, String estado,
				String cep) throws CepInvalidoException {
			super();//acessando construtor da superclasse
			this.tipoDeLogradouro = tipoDeLogradouro;
			this.logradouro = logradouro;
			this.numero = numero;
			this.bairro = bairro;
			this.cidade = cidade;
			this.estado = estado;
			geraid++;
			id = String.valueOf(geraid);//Checagem de parametro, se é nulo ou nao
			setCep(cep);
		}
		
                
		private String gerarID() {
			return "Endereço - " + geraid;
		}


		public String getId() {
			return id;
		}

		public String getTipe() {
			return tipe;
		}

		public String getTipoDeLogradouro() {
			return tipoDeLogradouro;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public int getNumero() {
			return numero;
		}

		public String getBairro() {
			return bairro;
		}

		public String getCidade() {
			return cidade;
		}

		public String getEstado() {
			return estado;
		}

		public String getCep() {
			return cep;
		}

		protected void setTipe(String tipe) {//Metodo que permite o acesso à variavel tendo o total controle sobre ela
			this.tipe = tipe;
		}

		protected void setTipoDeLogradouro(String tipoDeLogradouro) {//Todos os valores ficarão armazenados na variavel
			this.tipoDeLogradouro = tipoDeLogradouro;
		}

		protected void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		protected void setNumero(int numero) {
			this.numero = numero;
		}

		protected void setBairro(String bairro) {
			this.bairro = bairro;
		}

		protected void setCidade(String cidade) {
			this.cidade = cidade;
		}

		protected void setEstado(String estado) {
			this.estado = estado;
		}
                //Trecho de código que chama o método setCep construtor q deve capturar a exceção CepInvalido que ele lança
		protected void setCep(String cep) throws CepInvalidoException {
                    //Toda vez q acessar o metodo
				if (verificaCEP(cep)) {//Verificação CEP
					this.cep = cep;
				}
				
				else {//Lança a exceção se cep for invalid
					throw new CepInvalidoException();
				}
		}

		@Override//Mensagem mostrando dados do endereço preenchidos com as entradas fornecidas
		public String toString() {
			return gerarID() + "\nTipe: " + tipe + "\nTipoDeLogradouro: " + tipoDeLogradouro
					+ "\nLogradouro: " + logradouro + "\nNúmero: " + numero + "\nBairro: " + bairro + "\nCidade: " + cidade
					+ "\nEstado: " + estado + "\nCEP: " + cep;
		}
		
		protected boolean verificaCEP(String cep) {
			return cep.matches("\\d{5}-\\d{3}");
		}
}

