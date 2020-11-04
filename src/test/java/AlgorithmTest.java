package test.java;


import main.java.Algorithm.Algorithm;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlgorithmTest {

    @Test
    public void findMaxSubStringTest() throws Exception {
        String subString1 = "abcdefg";
        String subString2 = "gfedcba";
        String subString3 = "zxyabcdefg";
        String subString4 = "";
        String subString5 = " xxx abcdefgabcdefgklmno ";

        assertEquals(7, Algorithm.findMaxSubString(subString1));
        assertEquals(0, Algorithm.findMaxSubString(subString2));
        assertEquals(7, Algorithm.findMaxSubString(subString3));
        assertEquals(0, Algorithm.findMaxSubString(subString4));
        assertEquals(12, Algorithm.findMaxSubString(subString5));
    }

    @Test
    public void findWordsWithMaxNumberVowelsTest() throws Exception {
        String vowels = "яма обрыв рык оно пёс боров";
        List<String> vowelsList = new LinkedList<>();
        vowelsList.add("боров");
        vowelsList.add("обрыв");
        vowelsList.add("оно");
        vowelsList.add("яма");

        List<String> algorithmList = Algorithm.findWordsWithMaxNumberVowels(vowels);
        assertTrue(algorithmList.containsAll(vowelsList));
        assertTrue(vowelsList.containsAll(algorithmList));
        for(int i = 0; i < vowelsList.size(); i++){
            assertEquals(vowelsList.get(i), algorithmList.get(i));
        }
    }

    @Test
    public void findMaxPalindromeTest() throws Exception {

        String palindrome1 = " madam";
        String palindrome2 = "murderredrum_zxcvabc";
        String palindrome3 = "no palindrome";
        String palindrome4 = "aa cbc madam murderredrum cba";
        String palindrome5 = "zxcvbnmlkjhgdsaa";

        assertEquals("madam", Algorithm.findMaxPalindrome(palindrome1));
        assertEquals("murderredrum", Algorithm.findMaxPalindrome(palindrome2));
        assertEquals("", Algorithm.findMaxPalindrome(palindrome3));
        assertEquals(" murderredrum ", Algorithm.findMaxPalindrome(palindrome4));
        assertEquals("aa", Algorithm.findMaxPalindrome(palindrome5));
    }
}
