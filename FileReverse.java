//------------------------------------------------------------------------------------------------------------------------------
// FileReverse.java
// This is an excercise in fileio and tokenization.
// It will also use recursion.
//
// Tristan Clark
//------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

class FileReverse{

    public static String stringReverse(String s, int n) {
        if(s.length() == 1) return s;
        return stringReverse(s.substring(1,n),n-1) + s.charAt(0);
    }

    public static void main(String args[])  throws IOException{
        Scanner in = null;
        PrintWriter out = null;
        String line = null;
        String[] token = null;
        int i, n;

        // check number of command line arguments is at least 2
        if(args.length < 2){
        System.out.println("Usage: FileTokens <input file> <output file>");
        System.exit(1);
        }

        // open files
        in = new Scanner(new File(args[0]));
        out = new PrintWriter(new FileWriter(args[1]));
        // read lines from in, extract and print tokens from each line
        while( in.hasNextLine() ){

        // trim leading and trailing spaces, then add one trailing space so
        // split works on blank lines
        line = in.nextLine().trim() + " ";

        // split line around white space
        token = line.split("\\s+");

        // print out tokens
        n = token.length;
        for(i=0; i<n; i++){
            out.println(stringReverse(token[i],token[i].length()));
    }
 }
 // close files
 in.close();
 out.close();

    }
}