package classesDiagrama;

// Autoria: MÃ¡rcio Gomes Borges JÃºnior (201703685)

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

public class CriptografarSenha {
	
	private static byte[] gerarHash(String senha){
		  try {
		    MessageDigest md = MessageDigest.getInstance("SHA-256");
		    md.update(senha.getBytes());
		    return md.digest();
		  } catch (NoSuchAlgorithmException e) {
		    return null;
		  }
		}
	
	private static String stringHexa(byte[] bytes) {
		   StringBuilder s = new StringBuilder();
		   for (int i = 0; i < bytes.length; i++) {
		       int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
		       int parteBaixa = bytes[i] & 0xf;
		       if (parteAlta == 0) s.append('0');
		       s.append(Integer.toHexString(parteAlta | parteBaixa));
		   }
		   return s.toString();
		}
	
	public static String criptografar(String senha) {
		return stringHexa(gerarHash(senha));
	}
	
		public static void main(String[] args) {
		  
			Pessoa rafael = null;
			
			try {
				rafael = new PessoaFisica("Rafael Nunes", new Endereco("Rua"
<<<<<<< HEAD
						, "Rua 11", 123, "Centro", "Goiï¿½nia", "Goiï¿½s", "70100-100"), "123.456.789-10");
=======
						, "Rua 11", 123, "Centro", "Goiânia", "Goiás", "70100-100"), "123.456.789-10");
>>>>>>> b50680996f58592eee15154432b4804f4a40d9cb
				
				JOptionPane.showMessageDialog(null, rafael.toString());
			} catch (CpfCnpjInvalidoException | CepInvalidoException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage());	
			}
			
			Conta conta;
			
			try {
				conta = new Poupanca(rafael, "Hahfghdfgjndkkk");
				
				JOptionPane.showMessageDialog(null, conta.toString());
			} catch (SenhaInvalidaException | NullPointerException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
	}
}
