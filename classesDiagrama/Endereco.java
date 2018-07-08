package classesDiagrama;

// Autoria: MÃ¡rcio Gomes Borges JÃºnior (201703685)

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
		
		public Endereco(String tipe, String tipoDeLogradouro, String logradouro, int numero,
				String bairro, String cidade, String estado, String cep) throws CepInvalidoException {
			this.tipe = tipe;
			this.tipoDeLogradouro = tipoDeLogradouro;
			this.logradouro = logradouro;
			this.numero = numero;
			this.bairro = bairro;
			this.cidade = cidade;
			this.estado = estado;
			geraid++;
			id = String.valueOf(geraid);
			setCep(cep);
		}

		public Endereco(String tipoDeLogradouro, String logradouro, int numero, String bairro, String cidade, String estado,
				String cep) throws CepInvalidoException {
			super();
			this.tipoDeLogradouro = tipoDeLogradouro;
			this.logradouro = logradouro;
			this.numero = numero;
			this.bairro = bairro;
			this.cidade = cidade;
			this.estado = estado;
			geraid++;
			id = String.valueOf(geraid);
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

		protected void setTipe(String tipe) {
			this.tipe = tipe;
		}

		protected void setTipoDeLogradouro(String tipoDeLogradouro) {
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

		protected void setCep(String cep) throws CepInvalidoException {
				if (verificaCEP(cep)) {
					this.cep = cep;
				}
				
				else {
					throw new CepInvalidoException();
				}
		}

		@Override
		public String toString() {
			return gerarID() + "\nTipe: " + tipe + "\nTipoDeLogradouro: " + tipoDeLogradouro
					+ "\nLogradouro: " + logradouro + "\nNúmero: " + numero + "\nBairro: " + bairro + "\nCidade: " + cidade
					+ "\nEstado: " + estado + "\nCEP: " + cep;
		}
		
		protected boolean verificaCEP(String cep) {
			return cep.matches("\\d{5}-\\d{3}");
		}
}

