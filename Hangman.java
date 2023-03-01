import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel", 
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};


    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        int testVar = randomNumber();
      
        Scanner scan = new Scanner(System.in);

        String[] arr =  words[testVar].split("");
        String[] correctLetters = new String[arr.length];

        for(int i = 0; i < correctLetters.length; i++) {
            correctLetters[i] = "_";
        }

        

        String[] missedLetters = new String[6];

        for(int i = 0; i < missedLetters.length; i++) {
            missedLetters[i] = "_";
        }

        int counter = 0;
        int mistakesCounter = 0;

        puppetUpdating(mistakesCounter);
        
        System.out.print("Word: ");
                for(int i = 0; i < correctLetters.length; i++) {
                    System.out.print(correctLetters[i] + " ");
                }

        printMisses(missedLetters);

        while(counter < arr.length && mistakesCounter < 6 ) {
          
            String letterGuessed = scan.nextLine();
            int x = guess(arr,correctLetters,letterGuessed);
            if(x >= 0) {
                counter++;
                puppetUpdating(mistakesCounter);
                Updating(correctLetters, x, arr);

                printMisses(missedLetters);
                
            } else {
                missedLetters[mistakesCounter] = letterGuessed;
                mistakesCounter ++;
                puppetUpdating(mistakesCounter);

                System.out.print("Word: ");
                for(int i = 0; i < correctLetters.length; i++) {
                    System.out.print(correctLetters[i] + " ");
                }

                printMisses(missedLetters);
                
            }
        }
        
        if(counter == arr.length) {
            System.out.println("You win");
        } else if(counter != arr.length ) {
            System.out.println("You lost");
            System.out.println("The word was " + words[testVar]);
        } 
        scan.close();

    }

    public static int randomNumber() {
        double random = Math.random() * words.length;
        
        return (int)random;
    }

    public static int guess(String[] array, String[] correctLetters, String letterGuessed) {
        
        
        for(int i = 0; i < array.length; i ++) {
            if(array[i].equals(letterGuessed) && correctLetters[i].equals("_")) {
                return i;
            }

            
        }
        return -1;
    }
    
    public static void Updating(String[] correctLetters, int x, String[] arr) {
        correctLetters[x] = arr[x];
        System.out.print("Word: ");
        for(int i = 0; i < correctLetters.length; i++) {
            System.out.print(correctLetters[i] + " ");
        }
    }

    public static void puppetUpdating(int mistakesCounter) {
        System.out.println(gallows[mistakesCounter]);
    }

    public static void printMisses(String[] missedLetters) {
        System.out.print("Misses: ");
                for(int i = 0; i < missedLetters.length; i++) {
                    System.out.print( missedLetters[i] + " ");
                }
        System.out.println("\n");
    }

}





