import java.util.Scanner;
public class PassTest {
    private int count = 0;
    PassTest() {
    }
    public void passTest() {
        Scanner scan = new Scanner(System.in);
        PassGen passgen=new PassGen();
        do {
            System.out.print("\nenter your password: "); //case 1 password tester
            String passIn = scan.next();
            boolean leng = passIn.length() >= 8;
            boolean uppers = passIn.matches(".*[QWERTYUIOPASDFGHJKLZXCVBNM]+.*");
            boolean nums = passIn.matches(".*[1234567890]+.*");
            boolean lowers = passIn.matches(".*[qwertyuiopasdfghjklzxcvbnm]+.*");
            boolean specials = passIn.matches(".*[!@#$%^&*?]+.*");

            if (count % 5 == 0) {
                System.out.println("Do you want me to make you a strong password? (Y/N)");
                passIn = scan.next();
                if (passIn.contains("Y") || passIn.contains("y")) {
                    System.out.println(passgen.passGen());
                    break;
                }
                count++;
                continue;
            }
            if (!leng)
                System.out.println("Password must have 8 characters or more");
            if (!nums)
                System.out.println("You need numbers");
            if (!uppers)
                System.out.println("You need uppercase letters");
            if (!lowers)
                System.out.println("You need lowercase letters");
            if (!specials)
                System.out.println("You need to special characters (!@#$%^&*?)");
            if (leng && uppers && nums && lowers && specials) {
                System.out.println("Decent password!");
                break;
            }
            ++count;
            System.out.println("count " + count);

        } while (true);
    }
}
