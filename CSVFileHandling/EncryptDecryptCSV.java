import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String AES = "AES";
    private static final String SECRET_KEY = "1234567890123456"; 

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String encryptedFile = "employees_encrypted.csv";
        String decryptedFile = "employees_decrypted.csv";

        encryptCSV(inputFile, encryptedFile);
        decryptCSV(encryptedFile, decryptedFile);
    }

    public static void encryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line = br.readLine();
            bw.write(line + "\n"); 

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                columns[3] = encrypt(columns[3]); 
                columns[4] = encrypt(columns[4]); 

                bw.write(String.join(",", columns) + "\n");
            }
            System.out.println("CSV file encrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line = br.readLine();
            bw.write(line + "\n");

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                columns[3] = decrypt(columns[3]); 
                columns[4] = decrypt(columns[4]); 

                bw.write(String.join(",", columns) + "\n");
            }
            System.out.println("CSV file decrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(), AES));
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(), AES));
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }
}
