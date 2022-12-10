import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Cool tools, enter 1 for password tester and 2 for text encryptor.\n");
        short in1 = scan.nextShort();

        switch(in1){ //switch for input of 1 or 2
            case 1:
                PassTest test=new PassTest();
                test.passTest();
                System.out.println("\nWant to use the text encryptor now?");
                String ask1 = scan.nextLine();

            case 2: //case 2 text encryptor
                System.out.print("Type in the text you would like to encrypt: ");
                Encryptor encryptor=new Encryptor(scan.nextLine());
        }










    }
}