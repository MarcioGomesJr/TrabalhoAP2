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
}
