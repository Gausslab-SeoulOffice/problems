/*
이 문제를 새치기 문제이다.
한 사람은 2번이 최대로 갈 수 있는것이고 그걸 넘어서면 Too chaotic을 출력하게 된다,
그게 안넘어갔다면 이제 움직인 횟수를 출력해야한다.
https://www.hackerrank.com/challenges/one-week-preparation-kit-new-year-chaos/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four
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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int moveSum =0;
        for(int i =0; i< q.size(); i++){
            if(q.get(i) - (i+1)>2){
                System.out.println("Too chaotic");
                return;
            }
            for(int j = Math.max(0, q.get(i)-2); j< i; j++){
                if(q.get(j)> q.get(i)){
                    moveSum++;
                }
            }
        }
        System.out.println(moveSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}


/***
 * 일단 q.get(i)- (i-1)을 하게 되면 움직인 횟수가 나오게 되는데 이게 2보다 크면 Too chaotic을 출력하고 끝난다.
 * 그게 아니면 이제 for으로 다시 확인하면 된다.
 * 현재 사람 앞에 있는 사람 중,
 * 자신보다 번호가 큰 사람들 = 자신이 제쳐진 횟수 (즉, 받은 뇌물 수)
 * 이걸 모두 더하면 전체 뇌물 횟수가 나온다.
 */