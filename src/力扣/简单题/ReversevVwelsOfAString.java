package 力扣.简单题;

import java.util.Arrays;
import java.util.HashSet;

public class ReversevVwelsOfAString {

    static final HashSet<Character> v = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    ));

    public static String reverse(String s) {

        if (s == null) {
            return null;
        }

        int i = 0;
        int j = s.length() - 1;
        char[] res = new char[s.length()];
        while (i <=  j) {

            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (!v.contains(s.charAt(i))) {
                res[i++] = ci;
            } else if (!v.contains(s.charAt(j))) {
                res[j--] = cj;
            } else {
                res[i++] = cj;
                res[j--] = ci;

            }
        }
        return new String(res);
    }


    public static void main(String[] args) {
        System.out.println(reverse("leetcode"));

    }
}
