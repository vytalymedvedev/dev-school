import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algorithm {
    public static String findMaxSubString(String str) {
        char[] symbols = str.toCharArray();
        int maxLengthSubStr = 0;
        int start = 0;
        boolean sequence = false;
        for(int i = 0, j = -1; i < symbols.length; i++, j++) {
            if(j==-1) continue;
            int tempJ = j;
            while (i < symbols.length && symbols[j] < symbols[i]) {
                sequence = true;
                i++;
                j++;
            }
            if(sequence && (i - tempJ) > maxLengthSubStr) {
                maxLengthSubStr = i - tempJ;
                start = tempJ;
            }
            sequence = false;
        }
        return String.copyValueOf(symbols, start, maxLengthSubStr);
    };

    public static void findWordsWithMaxNumberVowels(String str) {
        String[] words = str.split("\\s|\\.");
        Pattern pattern = Pattern.compile("[ауоыиэяюёеАУОЫИЭЯЮЁЕ]");
        int maxVowelNumber = 0;
        Set<Wrapper> uniqueWords = new TreeSet();

        for (String s : words) {
            Matcher matcher = pattern.matcher(s);
            int coincidences = 0;
            while (matcher.find()) {
                coincidences++;
            }
            if(coincidences >= maxVowelNumber) {
                maxVowelNumber = coincidences;
                uniqueWords.add(new Wrapper(s.toLowerCase(),coincidences));
            }
        }
        for (Wrapper w : uniqueWords) {
            if(w.getVowelsNumber() == maxVowelNumber) {
                System.out.println(w.value);
            }
        }
    }

    public static String findMaxPalindrome (String str) {
        if(str.length() < 2) return null;
        char[] symbols = str.toCharArray();
        Palindrome palindrome = new Palindrome();
        findPalindromeInArray(symbols, 0, symbols.length - 1, palindrome);
        return palindrome.getValue();
    }

    public static void findPalindromeInArray(char[] arr, int start, int end, Palindrome palindrome) {
        //check this part can be max palindrome or not
        if(palindrome.getValue().length() >= (end - start) + 1)
            return;
        boolean hasPalindrome = true;
        int i = start;
        int j = end;
        while(i < j) {
            if(arr[i] != arr[j]) {
                hasPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        if(hasPalindrome) {
            palindrome.setValue(String.copyValueOf(arr, start, (end - start) + 1 ));
        }
        else {
            findPalindromeInArray(arr, start + 1, end, palindrome);
            findPalindromeInArray(arr, start, end - 1, palindrome);
        }
    }
}
