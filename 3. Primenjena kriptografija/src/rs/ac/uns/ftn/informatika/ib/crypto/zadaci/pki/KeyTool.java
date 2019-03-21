package rs.ac.uns.ftn.informatika.ib.crypto.zadaci.pki;


import java.math.BigInteger;
import java.security.KeyPair;

import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Scanner;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;

import rs.ac.uns.ftn.informatika.ib.crypto.primeri.pki.CertificateExample;
import rs.ac.uns.ftn.informatika.ib.crypto.primeri.pki.certificates.CertificateGenerator;
import rs.ac.uns.ftn.informatika.ib.crypto.primeri.pki.data.IssuerData;
import rs.ac.uns.ftn.informatika.ib.crypto.primeri.pki.data.SubjectData;
import rs.ac.uns.ftn.informatika.ib.crypto.primeri.pki.keystores.KeyStoreReader;
import rs.ac.uns.ftn.informatika.ib.crypto.primeri.pki.keystores.KeyStoreWriter;


public class KeyTool {
	public KeyTool() {
		Security.addProvider(new BouncyCastleProvider());
	}
	
	public static void main(String[] args) {
		KeyTool kt = new KeyTool();
		System.out.println("===== Konzolna aplikacija za upravljanje sertifikatima i kljucevima =====");
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		do {
			kt.menu();
			choice = keyboard.nextInt();
			System.out.println("choice: " + choice);
			switch(choice) {
			case 1: {
				System.out.println("izabran kec");
				kt.createNewKeyStore();
				break;
			}
			case 2: {
				kt.showKeyStoreContent();
				break;
			}
			case 3: {
				kt.createNewSelfSignedCertificate();
				break;
			}
			case 4: {
				kt.createNewIssuedCertificate();
				break;
			}
			}
		} while(choice != 5);
		keyboard.close();
	}

	private void createNewKeyStore() {
		System.out.println("'Create new key store' selected");
		//TODO: Upotrebom klasa iz primeri/pki paketa, implementirati funkciju gde korisnik unosi ime keystore datoteke i ona se kreira

        KeyStoreWriter keyStoreWriter = new KeyStoreWriter();
        keyStoreWriter.loadKeyStore(null, "Budimko".toCharArray());
//        keyStoreWriter.write("Budimko", keyPairIssuer.getPrivate(), "lozinka".toCharArray(), cert);
        keyStoreWriter.saveKeyStore("MegaTravel.jks", "lozinka".toCharArray());
        
        System.out.println("kao odrađeno");
	}

	private void showKeyStoreContent() {
		//TODO: Upotrebom klasa iz primeri/pki paketa, prikazati sadrzaj keystore-a, gde korisnik unosi ime i lozinku
		//Dozvoljeno je menjati klase iz primeri/pki paketa
		
		System.out.println("'Show key store content' selected");
		
		
		
		
		KeyStoreReader ksr = new KeyStoreReader();
		System.out.println(ksr);

	}

	private void createNewSelfSignedCertificate() {
		//TODO: Upotrebom klasa iz primeri/pki paketa, prikazati sadrzaj keystore-a, gde korisnik unosi sve potrebne podatke
		//Radi ustede hardkodovati podatke vezane za subjekta sertifikata
		
		CertificateGenerator gen = new CertificateGenerator();
		SubjectData subjectData = CertificateExample.generateSubjectData();
		KeyPair keyPairSubject = CertificateExample.generateKeyPair();
		IssuerData issuerData = CertificateExample.generateIssuerData(keyPairSubject.getPrivate());
		X509Certificate cert = gen.generateCertificate(subjectData, issuerData);
		
		
		
		KeyStoreWriter keyStoreWriter = new KeyStoreWriter();
        keyStoreWriter.loadKeyStore(null, "Budimko".toCharArray());
        keyStoreWriter.write("Budimko", keyPairSubject.getPrivate(), "lozinka".toCharArray(), cert);
        keyStoreWriter.saveKeyStore("MegaTravel.jks", "lozinka".toCharArray());	
        System.out.println(keyStoreWriter);
        
		
		
	}

	private void createNewIssuedCertificate() {
		//TODO: Upotrebom klasa iz primeri/pki paketa, prikazati sadrzaj keystore-a, gde korisnik unosi sve potrebne podatke
		//Radi ustede vremena hardkodovati podatke vezane za subjekta sertifikata
		CertificateGenerator gen = new CertificateGenerator();

		SubjectData subjectData = CertificateExample.generateSubjectData();
			
		KeyPair keyPairIssuer = CertificateExample.generateKeyPair();
		IssuerData issuerData = CertificateExample.generateIssuerData(keyPairIssuer.getPrivate());
		X509Certificate cert = gen.generateCertificate(subjectData, issuerData);
	        
		KeyStoreWriter keyStoreWriter = new KeyStoreWriter();
        keyStoreWriter.loadKeyStore(null, "Budimko".toCharArray());
        keyStoreWriter.write("Budimko", keyPairIssuer.getPrivate(), "lozinka".toCharArray(), cert);
        keyStoreWriter.saveKeyStore("MegaTravel.jks", "lozinka".toCharArray());	
        System.out.println(keyStoreWriter);
	}

	private void menu() {
		System.out.println("==================================");
		System.out.println("1.	Create new key store");
		System.out.println("2.	Show key store content");
		System.out.println("3.	Create new self signed certificate");
		System.out.println("4.	Create new issued certificate");
		System.out.println("5.	Exit");
		System.out.print(">>>");
	}
	
}
