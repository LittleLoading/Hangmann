import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class is for database of the words, and how it will work.
 */
public class Database {

    /**
     * Arraylist with Hard/Medium/Easy Words inside
     */
    private ArrayList<String> hardWords;
    private ArrayList<String>mediumWords;
    private ArrayList<String >easyWords;
    private String difficulty;

    public Database()throws Exception {
        try {
            /**
             * Adds words from the files
             */
        File dictionary0 = new File("\"D:\\\\C1a Houra\\\\IT\\\\Rocnikovka\\\\words-easy.txt\"");
        File dictionary1 = new File("\"D:\\\\C1a Houra\\\\IT\\\\Rocnikovka\\\\words-medium.txt\"");
        File dictionary2 = new File("\"D:\\\\C1a Houra\\\\IT\\\\Rocnikovka\\\\words-hard.txt\"");

            Scanner textScanner0 = new Scanner(dictionary0);
            Scanner textScanner1 = new Scanner(dictionary1);
            Scanner textScanner2 = new Scanner(dictionary2);

            /**
             * Putting files and the words inside into arraylist sorted by difficultyx
             */

            while (textScanner0.hasNextLine()){
                easyWords.add(textScanner0.nextLine());
            }
            while (textScanner1.hasNextLine()){
                mediumWords.add(textScanner1.nextLine());
            }
            while (textScanner2.hasNextLine()){
                hardWords.add(textScanner2.nextLine());
            }

            textScanner0.close();
            textScanner1.close();
            textScanner2.close();
/**
 * prinstack trace is for diagnosing an exception, it tells you what and where was the erorr
 */
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }
    /**
     * It will pick random word from the lists and separate it into single letters
     */
    public void loadChallenge() {
        ArrayList<String> words = null;
        boolean access = true;
        while (access){
            try {
                if (difficulty.equalsIgnoreCase("Easy")) {
                    words = easyWords;
                    access= false;
                }
                else if(difficulty.equalsIgnoreCase("Medium")){
                    words = mediumWords;
                    access = false;
                }
                else if(difficulty.equalsIgnoreCase("Hard")){
                    words = hardWords;
                    access = false;
                }
                access = false;
            }catch (InputMismatchException e) {
                System.out.println("Wrong difficulty input, choose again.");
                access = true;
            }
        }


        try {
            String hidenWord = words.get((int)(Math.random() * words.size()));
            char[] textArray = hidenWord.toCharArray();
            char[] myAnswers = new char[textArray.length];
            for (int i = 0; i < textArray.length;i++){
                myAnswers[i] = '_';
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

