/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FILING;

/**
 *
 * @author user
 */
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class test {
    
    
     public test() throws Exception
    {
  
  
    }
 public String encrypt(String unencryptedString) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        String algorithm = "DES";
     SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);

    byte[] encBytes = "12345678".getBytes("UTF8");
    byte[] decBytes = "56781234".getBytes("UTF8");

    DESKeySpec keySpecEncrypt = new DESKeySpec(encBytes);
    SecretKey keyEncrypt = keyFactory.generateSecret(keySpecEncrypt);
      DESKeySpec keySpecDecrypt = new DESKeySpec(decBytes);
      
    SecretKey keyDecrypt = keyFactory.generateSecret(keySpecDecrypt);

    Cipher cipherEncrypt = Cipher.getInstance(algorithm);
    Cipher cipherDecrypt = Cipher.getInstance(algorithm);

    String input = "john doe";

    cipherEncrypt.init(Cipher.ENCRYPT_MODE, keyEncrypt);
    byte[] inputBytes = cipherEncrypt.doFinal(input.getBytes());
    System.out.println("inputBytes: " + new String(inputBytes));

    cipherDecrypt.init(Cipher.DECRYPT_MODE, keyDecrypt);
    byte[] outputBytes = cipherDecrypt.doFinal(inputBytes);
     System.out.println("outputBytes: " + new String(outputBytes));   
    return new String(outputBytes);
   
 }



  public static void main(String args []) throws Exception
    {
        test myEncryptor= new test();
  
        String stringToEncrypt="P@ssword!";
//        
//        ADMIN123 mmm qsYVyDFK624cSomY9Ob9lw==  6zJKAsTkhblclOV53VjIGQ==
//ajam mmm +A9htvIYf80=
//caritas mmm H/gjiu5MG6U=
//evashelmith mmm l3gL9w7F2+o=
        String encrypted=myEncryptor.encrypt(stringToEncrypt);
//        byte[] text = "qsYVyDFK624cSmY9Ob9lw==".getBytes();
//        String enctptor=bytes2String(text);
//        String decrypted=myEncryptor.decrypt(enctptor);
//       
// XvKL3+Z6TjQ=f
        System.out.println("String To Encrypt: "+stringToEncrypt);
        System.out.println("Encrypted Value :" + encrypted);
//        System.out.println("Decrypted Value :"+decrypted);
 
    }    }