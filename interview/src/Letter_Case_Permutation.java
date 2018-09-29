import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 Note:

 S will be a string with length at most 12.
 S will consist only of letters or digits.
 *
 */

public class Letter_Case_Permutation {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for(int i = 0; i < S.length(); i++) {
            if(Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        List<String> result = new LinkedList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
         }
         Collections.reverse(result);
         return result;
    }

    public static void main(String[] args) {
        Letter_Case_Permutation letter_case_permutation = new Letter_Case_Permutation();
        String example = "a1b2";
        List<String> stringList = letter_case_permutation.letterCasePermutation(example);
        List<String> expectedStringList = new ArrayList<String>();
        expectedStringList.add("a1b2");
        expectedStringList.add("a1B2");
        expectedStringList.add("A1b2");
        expectedStringList.add("A1B2");
        Assert.assertEquals(stringList.size(), expectedStringList.size());
    }
}
