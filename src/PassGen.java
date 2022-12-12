public class PassGen {
    private int passLen;
    private String password;
    PassGen() {
        password="";
        passLen=0;
    }
    public String passGen(int x) {
        passLen=x;
        helper();
        System.out.println("This is a good password. Not truly random so please restart the program when generating new password\n");
        return "password: " + password;
    }
    private void helper(){
        for (int i=0;i<passLen;++i) {
            int rand = (int) Math.round(((Math.random() * 94) + 32));
            char ranChar = (char) rand;
            password += ranChar;
        }
    }
}
