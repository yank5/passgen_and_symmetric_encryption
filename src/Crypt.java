import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Crypt {
    private String text="";
    private String preGen="";
    private String key="";
    Crypt(String x){
        text=x;
    }
    Crypt(String x, String y){
        text=x;
        key=y;
    }


    public void encrypt(){
        System.out.println("encrypt");

        String orig=text; //original message
        var g=orig.split("");
        char[] origArray=orig.toCharArray(); //array message
        System.out.println("orig message:\n"+orig);

        String binString="";

        for (int stringArray=0;stringArray<g.length;++stringArray) { //foreach string in the string array
            var dd=g[stringArray].toCharArray();
            for(int x=0;x<g[stringArray].length();++x){ //for each character in the string
                binString+=(Integer.toBinaryString(dd[x]));
//                System.out.print(Integer.toBinaryString(dd[x]));
            }
//            System.out.print(" ");
            binString+=" ";
        }

//        System.out.println("binstring:\n"+binString);

        String[] tee=binString.split(" "); //USE TEE AS NEW STRING ARRAY

        for(int r=0;r<tee.length;r++){ //make sure they are all the same length with padding leading zeros
            String temp="";
            if(tee[r].length()<6){
                temp=tee[r];
                tee[r]="000"+temp;
            } else if (tee[r].length()<7) {
                temp=tee[r];
                tee[r]="00"+temp;
            } else if (tee[r].length()<8){
                temp=tee[r];
                tee[r]="0"+temp;
            }
        }

        binString="";
        for (String l:tee) {
            binString+=l;
        }

        System.out.println("padded binstring:\n"+binString);

        preGen=binString;

        keyGen();

        var x=binString.toCharArray();

//        System.out.println("DEBUG BINSTRING "+binString);
        var y=key.toCharArray();
        var teststring="";
        System.out.println("text encrypted:");
        for(int p=0;p<x.length;++p){ //XOR ENCRYPT WORKING LETS GOOOOOOOOO
            teststring+=(x[p]^y[p]);
        }
        System.out.print(teststring+"\nencrypted text readable form:\n"); //encrypted text

        var testStr=teststring.split("(?<=\\G.{" + 8 + "})");//splits binary string into 8 blocks.
        for (int u = 0; u < testStr.length; u++) {
            System.out.print((char) Long.parseLong(testStr[u], 2));//for each item in the array it decodes it into chars
        }
    }




    public void decrypt() {
        var qq = text.toCharArray();
        var y = key.toCharArray();
        StringBuilder decryp = new StringBuilder();
        for (int p = 0; p < text.length(); ++p) {// TEXT DECRYPT
//            System.out.print(qq[p] ^ y[p]);
            decryp.append(qq[p] ^ y[p]);
        }
        var decrypS = decryp.toString();
        String[] finalarray = decrypS.split("(?<=\\G.{" + 8 + "})");
        System.out.println("\ntext decrypted in char form");
        for (int u = 0; u < finalarray.length; u++) {
            System.out.print((char) Long.parseLong(finalarray[u], 2));
        }
    }
    private void keyGen(){//only call this method for encryption or else it will overwrite inputted key for decryption.
        System.out.println("KEY: ");
        for(long x=0L;x<preGen.length();x++){
            int g=(int) Math.round(Math.random());
            System.out.print(g);
            key+=g;
        }


        System.out.println("\nkey in readable form");
        var testKey=key.split("(?<=\\G.{" + 8 + "})");//splits binary string into 8 blocks.
        for (int u = 0; u < testKey.length; u++) {
            System.out.print((char) Long.parseLong(testKey[u], 2));//for each item in the array it decodes it into chars
        }
        System.out.println();
    }
}
