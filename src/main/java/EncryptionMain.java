import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncryptionMain {
        public static void main(String[] args) throws IOException {
            Encryption encrypt = new Encryption();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            System.out.println("To exit, enter \"exit\".");
            System.out.print("Enter a string or character:");
            while (!(line = reader.readLine()).equals("exit")){
                String en = encrypt.encryption(line);
                System.out.println(en);
                System.out.print("Enter a string or character:");
            }
        }
    }

