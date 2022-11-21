import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("\n");
            System.out.print("enter a strong password: ");
            String passIn = scan.next();
            if(passIn.length()>=8&&passIn.matches([!@#$%^&*])){
                System.out.println("Good password");
                break;
            } else{
//                int rand=(int)(Math.random()*2147483647)^(int)(Math.random()*2147483647);
//
//                int len=(int)(Math.log10(rand)+1);
//
//                int idx=(int)(Math.random()*len+1);

//                    int len=(int)(Math.log10(rand)+1);
//
//                    int idx=(int)(Math.random()*(len+1));
//
                System.out.print("Bad password, I'll make one for you. How long do you want it to be? ");
                short passLen=scan.nextShort();

                String password="";
                for(int i=0;i<passLen;i++){
                    int rand=(int)(Math.random()*4546)^(int)(Math.random()*4546)^(int)(Math.random()*4546)^(int)(Math.random()*4546);

                    char ranChar= (char) rand;



                    password+=ranChar;

                    System.out.println("Num: "+rand);
                }
                System.out.println("password: "+password);
            }
        }while(true);
    }
}