/*
Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters.
If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

11
middle-Outz
2

okffng-Qwvb

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
-    -
O -> Q
u -> w
t -> v
z -> b
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        k = k%26;
        for(char c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                char newChar = (char)((c-'a'+k)%26 + 'a');
                sb.append(newChar);
            }else if(Character.isUpperCase(c)){
                char newChar = (char)((c-'A'+k)%26 + 'A');
                sb.append(newChar);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/***
 * 이 문제는 알파벳을 이동시켜서 새로운 문자열을 만들라는 문제이다.
 *
 * 일단 k는 26단위로 순환되야하기에 %26를 해준다.
 * 그리고 문자열을 확인하면서 소문자는 a를 기준으로 k개만큼 밀어주고, 대문자는 A를 기준으로 k개 만큼 밀어준다.
 * 그 후 stringBuilder에 추가해주면된다.
 */