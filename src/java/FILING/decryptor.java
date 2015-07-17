/**
 * Author - Kushal Paudyal
 * www.sanjaal.com/java
 * Last Modified On 06-19-2009
 */
package FILING;
 
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

 
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
public class decryptor {
 
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DES_ENCRYPTION_SCHEME = "DES";
    public KeySpec myKeySpec;
    SecretKeyFactory mySecretKeyFactory = SecretKeyFactory.getInstance("DES");
//    public SecretKeyFactory mySecretKeyFactory;
    private Cipher cipher ;
    byte[] keyAsBytes;
    public String myEncryptionKey;
    public String myEncryptionScheme;
    SecretKey key;

    public decryptor() throws Exception
    {
        myEncryptionKey = "*&/>:@>?";
        myEncryptionScheme = DES_ENCRYPTION_SCHEME;
        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        myKeySpec = new DESKeySpec(keyAsBytes);
        mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = mySecretKeyFactory.generateSecret(myKeySpec);
        
//          DESKeySpec dks = new DESKeySpec(key.getBytes());
//		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
//		SecretKey desKey = skf.generateSecret(dks);
    }
 
    /**
     * Method To <span class="IL_AD" id="IL_AD5">Encrypt</span> The String
     */
    public String encrypt(String unencryptedString) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException {
        String encryptedString = null;
       try{
         
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            BASE64Encoder base64encoder = new BASE64Encoder();
           //encryptedString = base64encoder.<span class="\IL_AD\" id="\IL_AD9\">encode</span>(encryptedText);
       encryptedString = base64encoder.encode(encryptedText);
       }
            catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }
    /**
     * Method To Decrypt An Ecrypted String
     */

    /**
     * Method To Decrypt An Ecrypted String
     * @param encryptedString
     */

    /**
     * Method To Decrypt An Ecrypted String
     * @param encryptedString
     * @return
     */
    public String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            BASE64Decoder base64decoder = new BASE64Decoder();
            byte[] encryptedText = base64decoder.decodeBuffer(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= bytes2String(plainText);
          
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return decryptedText;
    }
    /**
     * Returns String From An Array Of Bytes
     */
    private static String bytes2String(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append((char) bytes[i]);
        }
        return stringBuffer.toString();
    }

    /**
     * Testing the DES Encryption And Decryption Technique
     */
    public static void main(String args []) throws Exception
    {
        decryptor myEncryptor= new decryptor();
  
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
 
    }   
 
}