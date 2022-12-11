public class Crypt {
    private String text;
    private long key=-1;
    Crypt(String x){
        text=x;
    }
    Crypt(String x, long y){
        text=x;
        key=y;
    }

    public void encrypt(){
        System.out.println("encrypt");
    }
    public void decrypt(){
        System.out.println("decrypt");
    }
}
