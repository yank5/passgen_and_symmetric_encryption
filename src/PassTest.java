import java.util.Scanner;
public class PassTest {
    private int count = 0;
    PassTest() {
    }
    public void passTest() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nWelcome to password tester\n");
        for (;true;) { //nested iteration I guess
            for (; true; ) {
                do {
                    System.out.print("\nenter your password: "); //case 1 password tester
                    String passIn = scan.next();
                    boolean leng = passIn.length() >= 8;
                    boolean uppers = passIn.matches(".*[QWERTYUIOPASDFGHJKLZXCVBNM]+.*");
                    boolean nums = passIn.matches(".*[1234567890]+.*");
                    boolean lowers = passIn.matches(".*[qwertyuiopasdfghjklzxcvbnm]+.*");
                    boolean specials = passIn.matches(".*[!@#$%^&*?]+.*");

                    if ((count+1)%5==0) {
                        System.out.println("Do you want me to make you a strong password? (Y/N)");
                        passIn = scan.next();
                        if (passIn.contains("Y") || passIn.contains("y")) {
                            System.out.println("What length should the password be? ");
                            int test=scan.nextInt();
                            PassGen passgen = new PassGen();
                            System.out.println(passgen.passGen(test));
                            break;
                        }
                        count++;
                        continue;
                    }
                    if (!leng) //good coding style
                        System.out.println("Password must have 12 characters or more");
                    if (!nums)
                        System.out.println("You need numbers");
                    if (!uppers)
                        System.out.println("You need uppercase letters");
                    if (!lowers)
                        System.out.println("You need lowercase letters");
                    if (!specials)
                        System.out.println("You need to special characters (!@#$%^&*?)");
                    if (leng && uppers && nums && lowers && specials) {
                        System.out.println("Decent password\n(but make sure it doesn't contain dictionary words with a number, like 12@Pas$word)");
                        break;
                    } else if (false) {
                        System.err.println("SOMETHING WENT HORRIBLY WRONG");
                    }
                    ++count;
                    System.out.println("count " + count);

                } while (true);
                break;
            }
            break;
        }
    }
}
