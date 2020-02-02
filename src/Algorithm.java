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
        char[] symbols = str.toCharArray();
        Set<String> uniques = new HashSet<>();
        if(symbols.length < 3) return null;
        for( int i = 1; i < symbols.length; i++) {
            int start = 0;
            int end;
            int tempStart = i;
            int tempEnd = i;
            tempEnd++;
            tempStart--;
            boolean palindrome = false;
            int palindromeLength = 0;
            while(tempStart >= 0 && tempEnd < symbols.length) {
                if(symbols[tempStart] == symbols[tempEnd]) {
                    palindrome = true;
                    palindromeLength++;
                    start = tempStart;
                    end = tempEnd;
                    tempStart--;
                    tempEnd++;
                }
                else break;
            }
            if(palindrome) {
                uniques.add(String.copyValueOf(symbols, start, palindromeLength * 2 + 1));
            }
        }
        for (String s : uniques) {
            System.out.println(s);
        }
        return "";
    }
}
