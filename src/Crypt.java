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



        System.out.println("binary string:\n"+binString);

        String[] tee=binString.split(" "); //USE TEE AS NEW STRING ARRAY

        for(int r=0;r<tee.length;r++){ //make sure they are all the same length with padding leading zeros
            String temp="";
            if(tee[r].length()<2){
                temp=tee[r];
                tee[r]="0000000"+temp;
            } else if (tee[r].length()<3) {
                temp=tee[r];
                tee[r]="000000"+temp;
            } else if (tee[r].length()<4){
                temp=tee[r];
                tee[r]="00000"+temp;
            }else if (tee[r].length()<5){
                temp=tee[r];
                tee[r]="0000"+temp;
            }else if (tee[r].length()<6){
                temp=tee[r];
                tee[r]="000"+temp;
            }else if (tee[r].length()<7){
                temp=tee[r];
                tee[r]="00"+temp;
            }else if (tee[r].length()<8){
                temp=tee[r];
                tee[r]="0"+temp;
            }
        }

        binString="";
        for (String l:tee) {
            binString+=l;
        }

//        System.out.println("padded binstring:\n"+binString);

        preGen=binString;

        keyGen();

        var x=binString.toCharArray();

//        System.out.println("DEBUG BINSTRING "+binString);
        var y=key.toCharArray();
        var teststring="";
        System.out.println("\ntext encrypted:");
        for(int p=0;p<x.length;++p){ //XOR ENCRYPT WORKING LETS GOOOOOOOOO
            teststring+=(x[p]^y[p]);
        }
        System.out.print(teststring); //encrypted text

// FIXME: 12/11/2022
//        var testStr=teststring.split("(?<=\\G.{" + 8 + "})");//splits binary string into 8 blocks.
//        for (int u = 0; u < testStr.length; u++) {
//            System.out.print((char) Long.parseLong(testStr[u], 2));//for each item in the array it decodes it into chars
//        }
    }




    public void decrypt() {

        var qq = text.toCharArray(); //turns the inputted text to an array
        var y = key.toCharArray(); //turns the key into an array
        StringBuilder decryp = new StringBuilder();


/*
FIXME: 12/11/2022
        var binString="";
        var g=text.split("");
        for (int stringArray=0;stringArray<g.length;++stringArray) { //foreach string in the string array
            var dd=g[stringArray].toCharArray();
            for(int x=0;x<g[stringArray].length();++x){ //for each character in the string
                binString+=(Integer.toBinaryString(dd[x]));
                System.out.print(Integer.toBinaryString(dd[x]));
            }
//            System.out.print(" ");
            binString+=" ";
        }
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
        for (String l:tee) {
            binString+=l; //makes binstring have correct padding
        }
        var x=binString.toCharArray(); //turns to chararray
*/


        for (int p = 0; p < text.length(); ++p) {// assumes that inputted key and text is binary already
//            System.out.print(qq[p] ^ y[p]);
            decryp.append(qq[p] ^ y[p]); //text decrypt
        }
        var decrypS = decryp.toString();
        String[] finalarray = decrypS.split("(?<=\\G.{" + 8 + "})");
        System.out.println("text decrypted in char form:");



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
// FIXME: 12/11/2022
//        System.out.println("\nkey in readable form");
//        var testKey=key.split("(?<=\\G.{" + 8 + "})");//splits binary string into 8 blocks.
//        for (int u = 0; u < testKey.length; u++) {
//            System.out.print((char) Long.parseLong(testKey[u], 2));//for each item in the array it decodes it into chars
//        }
//        System.out.println();
    }
}
