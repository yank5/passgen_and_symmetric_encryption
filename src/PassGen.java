import java.util.Scanner;

public class PassGen {
    PassGen() {
    }
    PassGen(int x) {
    }
    public String passGen() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What length should the password be? ");
        short passLen = scan.nextShort();
        String password = "";
        for (int i = 0; i < passLen; i++) {
            int rand = (int) ((Math.random() * 94) + 32);
            char ranChar = (char) rand;
            password += ranChar;
        }
        System.out.println("This is a good password. Not truly random so please restart the program when generating new password\n");
        return "password: " + password;
    }
}
