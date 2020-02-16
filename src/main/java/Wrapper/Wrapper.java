package main.java.Wrapper;

import java.util.Objects;

public class Wrapper implements Comparable<Wrapper>{
    private String value;
    private int vowelsNumber;

    public Wrapper(String value, int vowelsNumber) {
        this.value = value;
        this.vowelsNumber = vowelsNumber;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getVowelsNumber() {
        return vowelsNumber;
    }

    public void setVowelsNumber(int vowelsNumber) {
        this.vowelsNumber = vowelsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrapper wrapper = (Wrapper) o;
        return vowelsNumber == wrapper.vowelsNumber &&
                Objects.equals(value, wrapper.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Wrapper o) {
        String str1 = this.getValue();
        String str2 = o.getValue();
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        return 0;
    }
}
