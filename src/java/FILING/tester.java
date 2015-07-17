///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package FILING;
//
///**
// *
// * @author user
// */
//
// 
//import static FILING.decryptor.DES_ENCRYPTION_SCHEME;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.KeySpec;
// 
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESKeySpec;
// 
//public class tester
//{    
//private static final String UNICODE_FORMAT = "UTF8";
//    public static final String DES_ENCRYPTION_SCHEME = "DES";
//    public KeySpec myKeySpec;
//    public SecretKeyFactory mySecretKeyFactory;
//    private Cipher cipher=   Cipher.getInstance("DES/ECB/PKCS5Padding"); ;
//    byte[] keyAsBytes;
//    public String myEncryptionKey;
//    public String myEncryptionScheme;
//    SecretKey key;
//    public static void main(String[] argv) {
// 
//		try{
// 
//		    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
//		    SecretKey myDesKey = keygenerator.generateKey();
//        myEncryptionKey = "*&/>:@>?";
//        myEncryptionScheme = DES_ENCRYPTION_SCHEME;
//        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
//        myKeySpec = new DESKeySpec(keyAsBytes);
//        mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
//        cipher = Cipher.getInstance(myEncryptionScheme);
//        key = mySecretKeyFactory.generateSecret(myKeySpec);
//		    Cipher desCipher;
// 
//		    // Create the cipher 
//		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
// 
//		    // Initialize the cipher for encryption
//		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
// 
//		    //sensitive information
//		    byte[] text = "No body can see me".getBytes();
// 
//		    System.out.println("Text [Byte Format] : " + text);
//		    System.out.println("Text : " + new String(text));
// 
//		    // Encrypt the text
//		    byte[] textEncrypted = desCipher.doFinal(text);
// 
//		    System.out.println("Text Encryted : " + textEncrypted);
// 
//		    // Initialize the same cipher for decryption
//		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
// 
//		    // Decrypt the text
//		    byte[] textDecrypted = desCipher.doFinal(textEncrypted);
// 
//		    System.out.println("Text Decryted : " + new String(textDecrypted));
// 
//		}catch(NoSuchAlgorithmException e){
//			e.printStackTrace();
//		}catch(NoSuchPaddingException e){
//			e.printStackTrace();
//		}catch(InvalidKeyException e){
//			e.printStackTrace();
//		}catch(IllegalBlockSizeException e){
//			e.printStackTrace();
//		}catch(BadPaddingException e){
//			e.printStackTrace();
//		} 
// 
//	}
//}