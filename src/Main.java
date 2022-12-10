import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count=1;
        do{
            System.out.println("Password strength tester.\n");
            System.out.print("\nenter your password password: ");
            String passIn=scan.next();
            boolean leng=passIn.length()>=8;
            boolean uppers=passIn.matches(".*[QWERTYUIOPASDFGHJKLZXCVBNM]+.*");
            boolean nums=passIn.matches(".*[1234567890]+.*");
            boolean lowers=passIn.matches(".*[qwertyuiopasdfghjklzxcvbnm]+.*");
            boolean specials=passIn.matches(".*[!@#$%^&*?]+.*");

            if(count%5==0){
                System.out.println("Do you want me to make you a strong password? (Y/N)");
                passIn = scan.next();
                if(passIn.contains("Y")||passIn.contains("y")){
                    System.out.println(passGen());
                    break;
                }
                count++;
                continue;
            }
            if(!leng)
                System.out.println("Password must have 8 characters or more");
            if(!nums)
                System.out.println("You need numbers");
            if(!uppers)
                System.out.println("You need uppercase letters");
            if(!lowers)
                System.out.println("You need lowercase letters");
            if(!specials)
                System.out.println("You need to special characters (!@#$%^&*?)");
            if(leng&&uppers&&nums&&lowers&&specials) {
                System.out.println("Decent password!");
                break;
            }
            ++count;
            System.out.println("count "+count);

        }while(true);
        }
    public static String passGen(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What length should the password be? ");
        short passLen=scan.nextShort();
        String password="";
        for(int i=0;i<passLen;i++){
            int rand=(int)((Math.random()*94)+32);
            char ranChar= (char) rand;
            password+=ranChar;
        }
        System.out.println("This is a good password. Not truly random so please restart the program when generating new password\n");
        return "password: "+password;
    }
    }