/*Assignment 1 (Caesar Cipher Tester): Lilli Lewis
 9/7/23
 Sources: 
 * startup code from /home/jimenezp/csc207/assignments/encryption
 * copied the description, prompt, and error message from the assignment page
 * used hints from assignment page
 * looked up how to exit a program in Java and copied System.exit(0); from 
 *   https://blog.arrowhitech.com/java-stop-program-how-to-end-the-program-in-ja
 *   va/#:~:text=System.&text=Firstly%2C%20we%20can%20use%20the,program%20that%2
 *   0we%20are%20running.
 I confirm that the above list of sources is complete AND that I have 
 not talked to anyone else about the solution to this problem.*/


import ciphers.*; //import ciphers package
import java.util.Scanner; //import Scanner class

public class CaesarCipherTester {

    /*checkResponse(String response)
     *takes a String (response) and checks if the string is equal to
     *"encode" or "decode". if response equals neither encode nor decode, 
     *checkResponse returns false, if response equals either encode or decode,
     *checkResponse returns true*/
    public static boolean checkResponse(String response){
        if(!(response.equals("encode") || response.equals("decode"))){
            System.out.println("Valid options are \"encode\" or \"decode\" ");
            return false;
        }else{
            return true;
        }//else
    }//checkResponse

    public static void main(String[] args) {
        //print message to user about program purpose
        System.out.println("This program encrypts and decrypts messages using the Caesar Cipher.");
            
        //present options to user
        System.out.print("Would you like to encode or decode a message? ");
            
        //take input from user and store it as response
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        if(!(checkResponse(response))){
            System.exit(0);//took this line from link mentioned above
        }


        //decide which way to direct response, to encode or decode
        if(response.equals("encode")){
            //instructions to user
            System.out.print("Enter the string to encode: ");
            //take input from user and store it as messageEncode
            Scanner inEncode = new Scanner(System.in);
            String messageEncode = inEncode.nextLine();
            //store messageEncode in CaesarCipher 
            CaesarCipher cipherEncode = new CaesarCipher();
            cipherEncode.setString(messageEncode);
            //encode and print messageEncode  in a for loop
            for(int key = 0; key <26; key++){
                System.out.println(" n = " + key + ": " + cipherEncode.encode(key));
            }//for
        } else {
            //instructions to user
            System.out.print("Enter the string to decode: ");
            //take input from user and store it as messageDecode
            Scanner inDecode = new Scanner(System.in);
            String messageDecode = inDecode.nextLine();
            //put messageDecode into CaesarCipher 
            CaesarCipher cipherDecode = new CaesarCipher();
            cipherDecode.setString(messageDecode);
            //decode messageDecode
            for(int key = 0; key <26; key++){
                System.out.println(" n = " + key + ": " + cipherDecode.decode(key));
            }//for
        }//else
    }//main 
}//class
