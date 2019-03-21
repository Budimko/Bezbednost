package rs.ac.uns.ftn.informatika.ib.crypto.zadaci.communication;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import rs.ac.uns.ftn.informatika.ib.crypto.primeri.pki.keystores.KeyStoreReader;


/**
 * Generise i proverava digitalni potpis 
 * 
 */
public class SecureCommunication {
	
	public void testIt() {
		String message = "Ovo su podaci koje Alisa treba da posalje Bobu";

		//TODO: Implementirati pozivanje operacija tako da se simulira sifrovanje i digitalno potpisivanje poruke od strane Alise i desifrovanje i provera digitalnog potpisa od strane Boba
		//Dozvoljeno je kreiranje nove klase za DTO (data transfer object) ukoliko ima potrebe
	}
	
	private SecretKey generateSecretKey() throws Exception  {
		//TODO: Generisati i vratiti AES kljuc duzine koju diktira najbolja praksa
		 	
		 KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	     keyGenerator.init(256);

		 SecretKey secretKey = keyGenerator.generateKey();
         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
         SecretKeySpec keySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
       //Initialize Cipher for ENCRYPT_MODE
         cipher.init(Cipher.ENCRYPT_MODE, keySpec);
         System.out.println("bilo sta");
      
        
		
        return null;
	}
	
	private KeyPair generateKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
		//TODO: Generisati i vratiti RSA kljuceve duzine koju diktira najbolja praksa
		
		    KeyPairGenerator kpg;
	        kpg = KeyPairGenerator.getInstance("EC","SunEC");
	        ECGenParameterSpec ecsp;
	        ecsp = new ECGenParameterSpec("secp192r1");
	        try {
				kpg.initialize(ecsp);
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	        KeyPair kp = kpg.genKeyPair();
	        PrivateKey privKey = kp.getPrivate();
	        PublicKey pubKey = kp.getPublic();
	 
	        System.out.println(privKey.toString());
	        System.out.println(pubKey.toString());
		
		
        return null;
	}
	
	private byte[] encrypt(String plainText, PublicKey publicKey) {
		//TODO: Sifrovati otvoren tekst uz pomoc kombinacije simetricne i asimetricne sifre koju diktira najbolja praksa
		return null;
	}
	
	private byte[] decrypt(byte[] cipherText, SecretKey key) {
		//TODO: Desifrovati sifrat uz pomoc kombinacije simetricne i asimetricne sifre koju diktira najbolja praksa
		return null;
	}
	
	private byte[] sign(byte[] data, PrivateKey privateKey) {
		//TODO: Izvrsiti digitalno potpisivanje prateci najbolje prakse
		return null;
	}
	
	private boolean verify(byte[] data, byte[] signature, PublicKey publicKey) {
		//TODO: Izvrsiti proveru digitalnog potpisa
		return false;
	}

	public static void main(String[] args) {
		SecureCommunication sec = new SecureCommunication();
		sec.testIt();
	}
}
