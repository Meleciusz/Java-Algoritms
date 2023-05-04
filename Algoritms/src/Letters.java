import java.util.*;
public class Letters {


    //Function, which should return String, that can't contain three equal consecutive letter
    //String must be alphabetically, for example : aaaabbbcccc -> aabaabccbcc
    public static String solution(int A, int B, int C) {
        StringBuilder answerBuilder = new StringBuilder();

        for (int i = 0; i < A; ++i) {
            answerBuilder.append('a');
        }
        for (int i = 0; i < B; ++i) {
            answerBuilder.append('b');
        }
        for (int i = 0; i < C; ++i) {
            answerBuilder.append('c');
        }

        String answer = answerBuilder.toString();

        if (answer.length() <= 3) {
            return answer;
        }

        System.out.println(answer);

        for (int i = 1; i < answer.length() - 1; ++i) {
            if (answer.charAt(i) == answer.charAt(i - 1) && answer.charAt(i) == answer.charAt(i + 1)) {
                int j = i + 1;
                while (true) {
                    if (j >= answer.length() || answer.charAt(i) != answer.charAt(j)) {
                        break;
                    }
                    ++j;
                }

                if (j >= answer.length()) {
                    int k = answer.length() - 1;
                    while (true) {
                        if (answer.charAt(k) != answer.charAt(i)) {
                            break;
                        }
                        k--;
                    }

                    char[] answerArray = answer.toCharArray();
                    char tmp = answerArray[k];
                    answerArray[k] = answerArray[i - 1];
                    answerArray[i - 1] = tmp;
                    answer = new String(answerArray);
                } else {
                    char[] answerArray = answer.toCharArray();
                    char tmp = answerArray[j];
                    answerArray[j] = answerArray[i + 1];
                    answerArray[i + 1] = tmp;
                    answer = new String(answerArray);
                }
            }
            System.out.println(answer);
        }

        System.out.println(answer);
        return answer;
    }

}
