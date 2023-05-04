import java.util.*;

public class FindSimilarStrings {
    private int maxSimilarity = 0;
    //Find similar words. Similarity is, when words is constructed with same letters. For example aaaaab is similar with bababa, but not with bbc
    int maxSimilarWords(List<String> words){


        Vector<String> results = new Vector<String>();
        StringBuilder result = new StringBuilder(); //mutable String class
        Set<Character> uniqueWords = new HashSet<>(); //unique parameters container
        int i=0;

        for(String howManyWords : words){
            for (char letters : words.get(i).toCharArray()) {
                if (!uniqueWords.contains(letters)) {
                    result.append(letters);
                    uniqueWords.add(letters);
                }
            }
            ++i;
            uniqueWords.clear();
            results.add(result.toString());
            result.setLength(0);
        }


        Map<String, Integer> unique = new HashMap<>();
        for(int j=0; j<results.size(); ++j)
        {
            char[] charArray = results.get(j).toCharArray();
            Arrays.sort(charArray);
            results.set(j, new String(charArray));

            if(!unique.containsKey(results.get(j)))
            {
                maxSimilarity++;
                unique.put(results.get(j), 1);
            }

        }

        System.out.println(unique);


        return maxSimilarity;
    }
}
