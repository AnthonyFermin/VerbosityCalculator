package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Calculate the verbosity of a text
 */
public class VerbosityCalculator {
    public static void main(String[] args){

        int wordCount = 0;
        int sentenceCount = 0;

        // An abstract representation of a File
        File mobyDick = new File("/Users/c4q-anthonyf/Desktop/accesscode/VerbosityCalculator/resources/MobyDick.txt");
        File aTaleOftwoCities = new File("/Users/c4q-anthonyf/Desktop/accesscode/VerbosityCalculator/resources/ATaleOfTwoCities.txt");

        // Gets word count
        try{
            Scanner sc = new Scanner(mobyDick);
            while(sc.hasNext()) {
                sc.next();
                wordCount++;
            }

            Scanner sc2 = new Scanner(mobyDick);
            System.out.println(sc2.next());
            sc2.useDelimiter("p{?!.*}+");
            System.out.println(sc);
            System.out.println(sc2);
            while(sc.hasNext()){
                sc.next();
                sentenceCount++;
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(wordCount);
        System.out.println(sentenceCount);




    }
}
