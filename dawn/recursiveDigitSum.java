/*
이 문제는 각 자리수를 더해서 한자리수까지 나오게 하는것이다.
근데 특이한게 있다면 k라는게 주어지는데 숫자를 그만큼 덧붙여서 만든다는 것이다.
근데 생각해보면 그냥 숫자가 추가되는 것이기때문에 한번 더한 숫자에 k를 곱해주면 된다.
그 이후에 한자리수를 만들도록 하면 되는것이다.
https://www.hackerrank.com/challenges/one-week-preparation-kit-recursive-digit-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four
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
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        // Write your code here
        if (n.length() == 1 && k == 1) {
            return Integer.parseInt(n);
        }
        long sum =0;
        for(int i =0; i<n.length(); i++){
            Character ch = n.charAt(i);
            int num = Integer.parseInt(ch.toString());
            sum+= num;
        }
        sum *= k;
        return superDigit(String.valueOf(sum), 1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/***
 * 일단 n이 한자리 수이고, k도 1이면 그냥 그 숫자를 리턴하면 된다.
 * 그리고 이제 여러자리 수이면 확인하면 된다.
 * 일단 숫자가 문자열로 들어오니까 이걸 char로 변환시켜서 각 자리 수를 sum에 더해주면 된다.
 * 그리고 sum에 k를 곱하고, 이제 재귀로 부르면 된다.
 * 단 k를 1로 바꿔서 곱해지는게 없도록 한다.
 */