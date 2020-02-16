public class Main {

    public static void main(String[] args) {
        String first = "abcdefg";
        String second = "gfedcba";
        String third = "zxyabcdefg";
        String fourth = "";
        String fifth = "abcdefgabcdefgklmno";
        System.out.println(Algorithm.findMaxSubString(first));
        System.out.println(Algorithm.findMaxSubString(second));
        System.out.println(Algorithm.findMaxSubString(third));
        System.out.println(Algorithm.findMaxSubString(fourth));
        System.out.println(Algorithm.findMaxSubString(fifth));
        String example1 = "Предложение для теста. Ещё ауоыи одно предложение";
        String example2 = "";
        Algorithm.findWordsWithMaxNumberVowels(example1);
        Algorithm.findWordsWithMaxNumberVowels(example2);

        String palindrome1 = " madam";
        String palindrome2 = "cbmurderredrumabc";

        System.out.println(Algorithm.findMaxPalindrome(palindrome1));
        System.out.println(Algorithm.findMaxPalindrome(palindrome2));
    }
}
