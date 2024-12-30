/*Assignment 1 (Caesar Cipher): Lilli Lewis
 9/7/23
 Sources: startup code from /home/jimenezp/csc207/assignments/encryption
 I confirm that the above list of sources is complete AND that I have 
 not talked to anyone else about the solution to this problem.*/

package ciphers;//keep this file in ciphers package
public class CaesarCipher {
    //fields
    private String message;

    
    //constructor
    public CaesarCipher(){
        message = "";
    }

    
    /*setString(String str)
     *takes: implied CaesarCipher and a String  
     *returns: void
     *sets str to the message field of the CaesarCipher */
    public void setString (String str){
        this.message = str;
    }

    
     /*getString()
     *takes: implied CaesarCipher
     *returns: String, the message field of CaesarCipher*/
    public String getString(){
        return this.message;
            }
  

    /*letterToCode(char c)
     *takes: a char c
     *returns: an int i, a number 0-25, a=0 z = 25, corresponding to c's value*/
    public int letterToCode(char c){
        int base = (int) 'a';
        int i = (int) c - base;
        return i;
    }


    /*codeToLetter(int i)
     *takes: int i
     *returns: a char c, a-z, depending on the value of i(0-25) a=0 z=25*/
    public char codeToLetter(int i){
        int base = (int) 'a';
        char c = (char) (i + base);
        return c;
      }


    /*mod(int i)
     *takes: int i
     *returns: int i, but modified to be between 0 and 25. if i is less than 0, 
        then it 'wraps' around and goes backward from 25-0 (just add 26 to i).
        if i is greater than 26, then it 'wraps' around to 0 again (just i%26)*/
    public int mod(int i){
        if(i < 0){
            i += 26;
        }else{
            if(i >= 26){
                i = (i % 26);
            }
        }
        return i;
    }

    
 
    /*encode()
     *takes: implied CaesarCipher, int key
     *returns: String, CaesarCipher message shifted forward by key*/
    public String encode(int key){ 
        String str = new String(this.getString());
        int str_len = str.length();
        char[] char_array = str.toCharArray();//turn cipher message to char array
        int[] int_array = new int[str_len];
        String encoded;
        for(int i = 0; i <str_len; i++){//loop through message
            int code = letterToCode(str.charAt(i));//turn char to int, store in code
            int_array[i] = mod(code + key);//add code to key, mod the value, and store at int_array[i]
            char_array[i] = codeToLetter(int_array[(i)]);//turns i to char and stores in char_array[i]
        }//inner for
        encoded = new String(char_array);//store char array into string
        return encoded;
    }//encode


    
    
    /*decode()
     *takes: implied CaesarCipher, int key
     *returns: String, CaesarCipher message shifted backward by key*/
    public String decode(int key){ 
        String str = new String(this.getString());
        int str_len = str.length();
        char[] char_array = str.toCharArray();
        int[] int_array = new int[str_len];
        String decoded;
        for(int i = 0; i <str_len; i++){//loop through message
            int code = letterToCode(str.charAt(i));//turn char to int, store in code
            int_array[i] = mod(code - key);//subtract key from code, mod the value, and store at int_array[i]
            char_array[i] = codeToLetter(int_array[(i)]);//turns i to char and stores in char_array[i]
        }//inner for
        decoded = new String(char_array);//store char array into string
        return decoded;
    }//decode
    
}//class
