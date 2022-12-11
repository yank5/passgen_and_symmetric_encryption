import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Cool tools, enter 1 for password tester and 2 for text encryptor or 3 for text decryptor: ");
        short in1;
        while (true) {
            in1 = scan.nextShort();
            if(in1==1||in1==2||in1==3)
                break;
            else {
                System.out.println("please type 1 or 2 or 3");
                continue;
            }
        }
        scan.nextLine(); //clears the buffer or whatever, fixes my previous issue with all cases being activated
        switch (in1) { //switch for input of 1 or 2 or 3
            //I don't take credit for this lambda expressions, I still don't fully understand how they work
            //Intellij suggested to use this instead of regular case: switch syntax.
            //If intellij suggests it, then it probably does something useful.
            case 1 -> {
                PassTest test = new PassTest();
                test.passTest();
            }
            case 2 -> { //case 2 text encryptor
                System.out.print("Type in the text you would like to encrypt: ");
                String r = scan.nextLine();
                Crypt crypt = new Crypt(r);
                crypt.encrypt();
            }
            case 3 -> {//case 3 text decryptor
                System.out.print("Type in the text you would like to decrypt: ");
                String x = scan.nextLine();
                System.out.print("Paste the encryption key here: ");
                String y = scan.nextLine();
                Crypt crypt1 = new Crypt(x, y);
                crypt1.decrypt();
            }
            default -> {
                System.out.println(in1);
                System.err.println("something in switch broke");
            }
        }
    }
}