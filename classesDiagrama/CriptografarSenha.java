package classesDiagrama;

// Autoria: Márcio Gomes Borges Júnior (201703685)

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

//Classe que gera a criptografia da senha

public class CriptografarSenha {
	
	private static byte[] gerarHash(String senha){//Retorna a "assinatura" da senha
		  try {
		    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    //criamos um objeto MessgeDigest que implementa um algoritmo de hash, o qual especificamos no parâmetro do método getInstance
		    md.update(senha.getBytes());//Chamada do metodo uptade. Recebe como parametro um array de bytes.Convertido atraves do metodo getBytes
		    return md.digest();//chamamos o método digest que irá realizar o calculo do hash e retornar um array de bytes com o valor do hash.
		  } catch (NoSuchAlgorithmException e) {
		    return null;
		  }
		}
	
	private static String stringHexa(byte[] bytes) {//Metodo para imprimir o retorno do hash como um array de bytes 
		   StringBuilder s = new StringBuilder();
		   for (int i = 0; i < bytes.length; i++) {
		       int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;//deslocamos para a direita, desprezamos o que não seja a quadra menos significativa (& 0xf) e deslocamos de volta para a esquerd
		       int parteBaixa = bytes[i] & 0xf;// só desprezar o que não for a quadra menos significativa.
		       if (parteAlta == 0) s.append('0');
		       s.append(Integer.toHexString(parteAlta | parteBaixa));
		   }
		   return s.toString();
		}
	
	public static String criptografar(String senha) {
		return stringHexa(gerarHash(senha));
	}
	
}
