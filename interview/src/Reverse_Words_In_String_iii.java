import org.junit.Assert;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */


public class Reverse_Words_In_String_iii {

    public String reverseWords(String s) {
        char[] characters = s.toCharArray();
        int start = 0;
        for(int charIndex = 0; charIndex < characters.length; charIndex++) {
            if (characters[charIndex] == ' ') {
                reverseString(characters, start, charIndex - 1);
                start = charIndex + 1;
            }
        }
        reverseString(characters, start, characters.length - 1);
        return new String(characters);
    }

    private void reverseString(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        Reverse_Words_In_String_iii reverse_words_in_string_iii = new Reverse_Words_In_String_iii();
        String example = "Let's take LeetCode contest";
        String expectedresult = "s'teL ekat edoCteeL tsetnoc";
        String actualresult = reverse_words_in_string_iii.reverseWords(example);
        Assert.assertEquals(expectedresult, actualresult);

    }
}
