package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/** Anthony Fermin
 *  Calculate the verbosity of two texts and states which author is more verbose
 */
public class VerbosityCalculator {

    public static void main(String[] args){

        //declare and initializing variables
        double mobyDickWordCount = 0;
        double mobyDickSentenceCount = 0;
        double twoCitiesWordCount = 0;
        double twoCitiesSentenceCount = 0;
        double mobyDickVerbosity;
        double twoCitiesVerbosity;
        DecimalFormat decimal = new DecimalFormat("#.##"); //set a new DecimalFormat instance to display a maximum of two decimal places

        // An abstract representation of a File
        File mobyDick = new File("/Users/c4q-anthonyf/Desktop/accesscode/VerbosityCalculator/resources/MobyDick.txt");
        File aTaleOfTwoCities = new File("/Users/c4q-anthonyf/Desktop/accesscode/VerbosityCalculator/resources/ATaleOfTwoCities.txt");


        try{
            // creating new Scanner instance for mobyDick file
            Scanner scMobyDick = new Scanner(mobyDick);

            // while loop continues while there is another word to search in the file
            while(scMobyDick.hasNext()) {

                String currentWord = scMobyDick.next();// temporarily storing the current word into currentWord
                mobyDickWordCount++; // increments word counter

                char lastChar = currentWord.charAt(currentWord.length()-1); // saving last char in the current word to a variable

                // nested if statements only counts a sentence if the word ends with a . ? or ! and
                // the word is not Mr. Mrs. or Ms.
                if(lastChar == '.' || lastChar == '?' || lastChar == '!'){

                    if( !(currentWord.equals("Mr.") || currentWord.equals("Mrs.") || currentWord.equals("Ms.") ) ){
                        mobyDickSentenceCount++;
                    }
                }
            }

            // creating new Scanner instance for aTaleOfTwoCities file
            Scanner scTwoCities = new Scanner(aTaleOfTwoCities);

            // while loop continues while there is another word to search in the file
            while(scTwoCities.hasNext()) {

                String currentWord = scTwoCities.next(); //temporarily storing the current word into currentWord
                twoCitiesWordCount++; //increments word counter

                char lastChar = currentWord.charAt(currentWord.length()-1); //saving last char in the current word to a variable

                // nested if statements only counts a sentence if the word ends with a . ? or ! and
                // the word is not Mr. Mrs. or Ms.
                if(lastChar == '.' || lastChar == '?' || lastChar == '!'){

                    if( !(currentWord.equals("Mr.") || currentWord.equals("Mrs.") || currentWord.equals("Ms.") ) ){
                        twoCitiesSentenceCount++;
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // Storing Verbosity for each file. Verbosity = (Total number of words)/(Total number of sentences)
        // I used Decimal Format to only show up to two decimal places
        mobyDickVerbosity = Double.valueOf(decimal.format( mobyDickWordCount / mobyDickSentenceCount ));
        twoCitiesVerbosity = Double.valueOf(decimal.format( twoCitiesWordCount / twoCitiesSentenceCount ));

        //lists wordCount, sentenceCount and verbosity for each text
        System.out.println("Moby Dick word count: " + mobyDickWordCount);
        System.out.println("Moby Dick sentence count: " + mobyDickSentenceCount);
        System.out.println("Hermal Melville's Moby Dick verbosity: " + mobyDickVerbosity + "\n");

        System.out.println("A Tale of Two Cities word count: " + twoCitiesWordCount);
        System.out.println("A Tale of Two Cities sentence count: " + twoCitiesSentenceCount);
        System.out.println("Charles Dickens' A Tale of Two Cities verbosity: " + twoCitiesVerbosity + "\n");

        // prints out which author is more verbose
        if(mobyDickVerbosity > twoCitiesVerbosity){

            System.out.println("Hermal Melville is more verbose than Charles Dickens.");

        }else if(twoCitiesVerbosity > mobyDickVerbosity){

            System.out.println("Charles Dickens is more verbose than Hermal Melville.");

        }else{

            System.out.println("They are equally verbose.");
        }




    }
}
