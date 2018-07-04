// Autoria: Márcio Gomes Borges Júnior (201703685)

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografarSenha {
	
	static Conta senha;
	
	public static byte[] gerarHash(){
		  try {
		    MessageDigest md = MessageDigest.getInstance("SHA-256");
		    md.update(senha.getSenha().getBytes());
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
	
		public static void main(String[] args) {
		  System.out.println(stringHexa(gerarHash()));
		}
}
