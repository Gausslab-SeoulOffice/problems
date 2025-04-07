/*
Balanced Brackets

https://www.hackerrank.com/challenges/one-week-preparation-kit-balanced-brackets/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-five
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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.add(ch);
            }else{
                if(stack.isEmpty()){
                    return "NO";
                }
                char top = stack.pop();
                if((ch==')' && top !='(') || (ch=='}' && top !='{') || (ch==']' && top !='[')){
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/***
 * 이 문제도 종종나오는 문제이다.
 * 괄호가 제대로 쌍이 맞춰졌는지 묻는 것이다.
 *
 * 일단 stack으로 쌓아갈거기 때문에 선언한다.
 * 그리고 한개씩 확인할건데, 여는 괄호이면 일단 추가하고, 닫는괄호이면 이제 확인해야한다.
 * 닫는괄호가 들어왔는데 이미 stack이 비어 있으면 뭔가 잘못된것이기에 no를 return한다.
 * 그게 아니면 이제 stack에 들어가 있는 것 중 제일 위에 있는걸 pop해서 확인하면 된다.
 * 무조건 여는 괄호가 있을거고, 이제 들어오는 s의 문자가 무엇인지에 따라서 다를것이다.
 * 같은 쌍이여야만 yes가 될 가능성이 있다.
 * for문을 다 돌리고 stack에 남은게 없으면 yes가 된다.
 */