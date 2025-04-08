/*
Jesse and Cookies

https://www.hackerrank.com/challenges/one-week-preparation-kit-jesse-and-cookies/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six
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
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int count =0;

        while(minHeap.size()>=2 && minHeap.peek() <k){
            List<Integer> list = new ArrayList<>();
            list.add(minHeap.poll());
            list.add(minHeap.poll());

            int newAnswer = compute(list);
            minHeap.offer(newAnswer);
            count++;
        }
        return minHeap.peek() >= k ? count : -1;
    }

    private static int compute(List<Integer> list){
        return list.get(0) + 2 * list.get(1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/***
 * 이 문제는 최소의 쿠키 두개를 계산해서 모든 쿠키가 최소 달기의 조건을 모두 넘기도록 할때 계산한 횟수를 구하는 문제이다.
 * 분명 비슷한걸 했는데, priorityQueue가 생각이 안나서 list로 sort하다가 time limit가 떠서.. 오래걸렸다.
 *
 * 일단 PriorityQueue라는 아주 좋은 아이가 있다. 오름차순으로 알아서 정렬해서 queue처럼 사용할 수 있다.
 * while문 작성을 잘해야한다. minHeap안에 원소가 2개 이상 들어가 있고, 제일 작은 값을 의미하는 minHeap.peek()값이 k보다 작을 경우엔 계속한다.
 * 그 안에서 poll()을 이용해서 제일 작은 값을 빼고, 한 번 더 사용해서 그 다음 작은 값도 뺀다.
 * 그 값을 list에 넣어서 compute라는 함수로 넘겨주었다.
 * 사실 함수로 안빼도 되지만 난 빼는 게 좋다.
 * 그리고 그 계산한 값을 다시 minHeap에 offer로 넣어주고, 계산 한 번 했으니까 count++를 해준다.
 * 이 반복문을 다 돌고 나서 빠져나오면 일단 확인을 해야한다.
 * 조건엔 안걸렸지만 절대 불가능한 것도 있기때문에, peek()으로 확인해서 제일 작은게 k와 같거나 큰지 확인하고, 맞으면 count를 반환, 틀리면 -1를 반환하면 된다.
 */