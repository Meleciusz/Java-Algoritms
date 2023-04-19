import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    //Write function, which will check the nearest way to fibonacci number
    //For example number 15 is closest to 13 fibonacci number and 20 is closest to 21 fibonacci number
    //If the number is from fibonacci sequence return 0
    //Input is table of ints for example {1, 2, 3}. Number we're interested in is sum of these ints in table
    private static int fibbo(int[] tab){

        int sum = 0;
        for(int x : tab)
        {
            sum+=x;
        }

        int limit = 10;
        int f1 = 0, f2 = 1, f3;
        for (int i = 2; i < limit; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;

            if(f3 == sum){
                return 0;
            }
            else if(f1<sum && sum<f3 && f3-sum<sum-f2)
            {
                return sum-f3;
            }
            else if(f1<sum && sum<f3 && f3-sum>sum-f2)
            {
                return f3-sum;
            }

        }

        return 0;
    }


    //Write function, which will define the most numbers of repeated letters in sentence
    //for example word "electronics" have 2xe's and 2xc's and will be higher than
    //word "current", that have only 2xr's
    private static String letters(String sentence){
        String[] words = sentence.split(" ");
        Vector<Integer> max = new Vector<Integer>();


        int sum=0;

        for(String x : words) {

            for(int i=0; i<x.length(); i++)
            {
                Character letter = x.charAt(i);
                for(int j=i+1; j<x.length(); j++) {
                    if(letter == x.charAt(j)) {
                        sum++;
                    }
                }

            }
            max.add(sum);
            sum = 0;
        }

        int index = Collections.max(max);
        String word = words[max.indexOf(index)];

        return word;
    }

    //Write function, which will return numbers of a's, which we can put into word
    //between letters we can put 2x a. For example bar -> aabaaraa.
    //Input bar should return 5.
    private static int AInput(String str) {
        int sum = 0;
        int howMuchAWas = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'a') { // Obecnie przetwarzany znak nie jest 'a'
                if (howMuchAWas == 0)
                    sum += 2; // Przed nim nie było 'a' (można dopisać przed nim +2 'a')
                else if (howMuchAWas == 1)
                    sum++; // Przed nim było jedno 'a' (można dopisać przed nim +1 'a')
                howMuchAWas = 0; // Zerujemy ilość 'a' wcześniej
                if (i == str.length() - 1)
                    sum += 2; // Jeśli jest on ostatnim znakiem (możemy dopisać za nim +2 'a')
            } else { // Obecnie przetwarzany znak jest 'a'
                if (howMuchAWas == 0) { // Jeśli nie było wcześniej żadnego 'a'
                    if (i != str.length() - 1 && str.charAt(i + 1) != 'a') {
                        howMuchAWas++;
                        sum++;
                    }
                    if (i == str.length() - 1) {
                        howMuchAWas++;
                        sum++;
                    }
                }
                howMuchAWas++;
            }
            if (howMuchAWas == 3)
                return -1;
        }
        return sum;
    }


    public static void main(String[] args) {

        String word_1 = "Let me do it really quick";
        String word_2 = "This is example of a problem";
        System.out.println(letters(word_1)); //should return word "really"
        System.out.println(letters(word_2)); //should return word "example"


        int[] tab1 = {27, 1, 1};    int[] tab2 = {30, 1, 1};
        System.out.println(fibbo(tab1));
        System.out.println(fibbo(tab2));

        System.out.println(AInput("bar"));  //should return 5
        System.out.println(AInput("enter")); //should return 12


        LinuxAccessAlgorithm LinuxAlgotithmObject = new LinuxAccessAlgorithm();
        LinuxAlgotithmObject.main();
        }



    }
