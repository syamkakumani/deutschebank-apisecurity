package com.nobleprod.sec;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoController {
	
public static Map<String, Object> map = new HashMap<>();
	
	@GetMapping("/createKeys")
	void createPubPriKeys(){
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(4096);

			KeyPair keyPair = keyPairGenerator.generateKeyPair();

			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();

			map.put("publicKey", publicKey);
			System.out.println("public- "+publicKey);
			
			map.put("privateKey", privateKey);
			System.out.println("private- "+privateKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		System.out.println("Keys creation successful !!");
	}

	@PostMapping("/encrypt")
	String encMessage(@RequestBody String input) {

		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
			PublicKey publicKey = (PublicKey) map.get("publicKey");

			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] encrypt = cipher.doFinal(input.getBytes());

			return new String(Base64.getEncoder().encodeToString(encrypt));

		} catch (Exception e) {
		}

		return "";
	}

	@PostMapping("/decrypt")
	String dcMessage(@RequestBody String encString) {
		
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
			PrivateKey privateKey = (PrivateKey) map.get("privateKey");
			
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(encString));
			
			return new String(decrypt);
		}
		catch(Exception e) {}

		return "";
	}

}
