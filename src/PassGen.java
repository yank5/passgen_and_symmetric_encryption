import java.util.Scanner;
public class PassGen {
    private short passLen;
    private String password;
    PassGen() {
    }
    public String passGen(short x) {
        Scanner scan = new Scanner(System.in);
        passLen=x;
        helper();
        System.out.println("This is a good password. Not truly random so please restart the program when generating new password\n");
        return "password: " + password;
    }
    private void helper(){
        for (int i=0;i<passLen;++i) {
            int rand = (int) ((Math.random() * 94) + 32);
            char ranChar = (char) rand;
            password += ranChar;
        }
    }
}
