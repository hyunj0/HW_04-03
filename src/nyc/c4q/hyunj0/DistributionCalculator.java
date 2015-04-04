package nyc.c4q.hyunj0;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

class Alphabet
{
    char letter;

    public char generateLetter(int asciiCode)
    {
        letter = (char) asciiCode;
        return letter;
    }

    public double letterCount(File textFile, char letter) throws FileNotFoundException
    {
        Scanner read = new Scanner(textFile);
        double eachLetter = 0;
        while(read.hasNextLine())
        {
            String line = read.nextLine().toLowerCase();
            for(int i = 0; i < line.length(); i++)
            {
                if(line.charAt(i) == letter)
                {
                    eachLetter += 1;
                }
            }
        }
        return eachLetter;
    }
}

public class DistributionCalculator
{

    public static void main(String[] args) throws FileNotFoundException
    {
        for(String letter : calculate(new File(
                "/Users/c4q-sarahkim/Desktop/accesscode/HW_04-03/src/nyc/c4q/hyunj0/alphabet.txt")))
        {
            System.out.println(letter);
        }
    }

    public static ArrayList<String> calculate(File textFile) throws FileNotFoundException
    {
        ArrayList<String> distributionOfCharacters = new ArrayList<String>();
        Scanner read = new Scanner(textFile);
        double allLetter = 0;
        for(int letter = 97; letter < 123; letter++)
        {
            while(read.hasNextLine())
            {
                String line = read.nextLine().toLowerCase();
                for(int i = 0; i < line.length(); i++)
                {
                    if((int) line.charAt(i) > 96 && (int) line.charAt(i) < 123)
                    {
                        allLetter += 1;
                    }
                }
            }
        }
        Alphabet alphabet = new Alphabet();
        DecimalFormat df = new DecimalFormat("#.##");
        for(int i = 97; i < 123; i++)
        {
            distributionOfCharacters.add(alphabet.generateLetter(i) + " = "
                + df.format((alphabet.letterCount(new File("/Users/c4q-sarahkim/Desktop/accesscode/HW_04-03/src/nyc/c4q/hyunj0/alphabet.txt"),
                    (char) i) / allLetter) * 100) + " %");
        }
        return distributionOfCharacters;
    }
}
