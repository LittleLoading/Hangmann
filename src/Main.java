import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


      /*  try {
            BufferedReader bw = new BufferedReader(
                    new FileReader("D:\\C1a Houra\\IT\\Rocnikovka\\words.txt"));
            String s;
            while ((s = bw.readLine()) != null){
                System.out.println(s);
            }
            bw.close();
        } catch (Exception e) {
            return;
        }

        File dictionary =
    }

       */

        File dictionary = new File("D:\\C1a Houra\\IT\\Rocnikovka\\USA-English.txt");
        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        while (textScanner.hasNextLine()){
            words.add(textScanner.nextLine());
        }

        String hiddenWords = words.get((int)(Math.random() * words.size()));
        char[] textArray = hiddenWords.toCharArray();

        char[] myAnswers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++){
            myAnswers[i] = '_';
        }
        boolean finished = false;
        int lives = 6;
        while (finished == false){
            System.out.println("******************");

            String letter = input.next();
            //checks for valid input
            while (letter.length() != 1|| Character.isDigit(letter.charAt(0))){
                System.out.println("Wrong Input, you can try again");
                letter = input.next();
            }

            //checks if letter is in the word
            boolean found = false;
            for (int i = 0; i <textArray.length; i++){
                if(letter.charAt(0) == textArray[i]){
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }
            if(!found){
                lives--;
                System.out.println("Wrong letter");
            }
            boolean done = true;
            for(int i = 0; i < myAnswers.length; i++){
                if(myAnswers[i] == '_'){
                    System.out.println("-");
                    done = false;
                }
                else{
                    System.out.println(" " + myAnswers[i]);
                }
            }
            System.out.println("\n" + "Lives left: " + lives);

            //check if the game ends
            if(done) {
                System.out.println("Congrats, You guessed the Word!");
                finished = true;
            }
            if(lives <=0){
                System.out.println("You are dead! Study more!");
            }
        }

    }
}