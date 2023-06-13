import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String text = "Homework";
        char symbol = 'o';
        int occurrence = findSymbolOccurance(text, symbol);
        System.out.println("Symbol occurrence: " + occurrence);

        String source = "Apollo";
        String target = "pollo";
        int position = findWordPosition(source, target);
        System.out.println("Word position: " + position);

        String reversedText = stringReverse("Hello");
        System.out.println("Reversed text: " + reversedText);

        String palindromeText = "ERE";
        boolean isPalindrome = isPalindrome(palindromeText);
        System.out.println("Is palindrome: " + isPalindrome);

        playWordGame();
    }

    public static int findSymbolOccurance(String str, char n){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == n) {
                count++;
            }
        }
        return count;
    }

    public static int  findWordPosition(String source, String target){
        int position = source.indexOf(target);
        return position != -1 ? position : -1;
    }

    public static String stringReverse(String str){
        int i = 0;
        String result = "";
        while (i < str.length()){
            result = str.charAt(i) + result;
            i = i + 1;
        }
        return result;
    }

    public static boolean isPalindrome(String str){
        /* int i = 0;
        String result = "";
        while (i < str.length()){
            result = str.charAt(i) + result;
            i = i + 1;
        }
        return str.equalsIgnoreCase(result);*/

        String reversedStr = stringReverse(str);
        return str.equalsIgnoreCase(reversedStr);
    }

    public static void playWordGame() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Scanner scanner = new Scanner(System.in);
        String hiddenWord = words[(int) (Math.random() * words.length)];
        int wordLength = hiddenWord.length();
        String maskedWord = "#".repeat(wordLength);
        boolean guessed = false;

        System.out.println("Let's play a word guessing game!");
        System.out.println("I have selected a word. Try to guess it.");


        while (!guessed) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() != wordLength) {
                System.out.println("Invalid guess. Please enter a word with length " + wordLength + ".");
                continue;
            }

            if (guess.equals(hiddenWord)) {
                guessed = true;
                System.out.println("Congratulations! You guessed the word correctly.");
            } else {
                StringBuilder maskedWordBuilder = new StringBuilder(maskedWord);

                for (int i = 0; i < wordLength; i++) {
                    if (maskedWord.charAt(i) == '#' && hiddenWord.charAt(i) == guess.charAt(i)) {
                        maskedWordBuilder.setCharAt(i, guess.charAt(i));
                    }
                }

                maskedWord = maskedWordBuilder.toString();
                System.out.println(maskedWord);

                if (maskedWord.equals(hiddenWord)) {
                    guessed = true;
                    System.out.println("Congratulations! You guessed the word correctly.");
                }
            }
        }

        scanner.close();

    }
}