package main.java.Algorithm;

import main.java.Palindrome.Palindrome;
import main.java.Wrapper.Wrapper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algorithm {
    // Данный алгоритм содержит цикл, вложенный в другой,
    // но т.к. индексы (i,j) не сбрасываются после выхода из внутреннего цикла,
    // то сложность алгоритма линейная O(n)
    public static String findMaxSubString(String str) {
        char[] symbols = str.toCharArray();
        int maxLengthSubStr = 0;
        int start = 0;
        boolean sequence = false;
        for(int i = 1, j = 0; i < symbols.length; i++, j++) {
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

    // Данный алгоритм содержит цикл, вложенный в другой.
    // Время работы данного алгоритма напрямую зависит от длины строки
    // и количества слов в ней. Сложность алгоритма O(n^2)
    public static List<String> findWordsWithMaxNumberVowels(String str) {
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
        List<String> listWithVowels = new LinkedList<>();
        for (Wrapper w : uniqueWords) {
            if(w.getVowelsNumber() == maxVowelNumber) {
                listWithVowels.add(w.getValue());
            }
        }

        return listWithVowels;
    }

    // Данный алгоритм содержит рекурсию.
    // Время работы данного алгоритма напрямую зависит от длины строки
    // и максимального размера палиндрома в ней (если вообще есть).
    // В худшем случае, когда дана большая строка, но палиндрома в ней нет,
    // алгоритм будет проходить строку от начала до конца,
    // затем снова, но сместившись на 1 индекс вправо,
    // затем всё тоже самое в обратном направлении - с конца в начало и смещаясь влево.
    // Сложность данного алгоритма O(n!)
    public static String findMaxPalindrome (String str) {
        if(str.length() < 2) return null;
        char[] symbols = str.toCharArray();
        Palindrome palindrome = new Palindrome();
        findPalindromeInArray(symbols, 0, symbols.length - 1, palindrome);
        return palindrome.getValue();
    }

    public static void findPalindromeInArray(char[] arr, int start, int end, Palindrome palindrome) {
        //check this part can be max palindrome or not
        if(palindrome.getValue().length() >= (end - start) + 1 || (end - start) == 0)
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
