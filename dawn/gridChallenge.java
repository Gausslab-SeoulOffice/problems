/*
이 문제는 일단 열을 정렬하고 그 다음 행이 정렬이 되어 있는지 묻는 문제이다.
https://www.hackerrank.com/challenges/one-week-preparation-kit-grid-challenge/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four
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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for(int i =0; i< grid.size(); i++){
            char[] chars = grid.get(i).toCharArray();
            Arrays.sort(chars);
            grid.set(i, new String(chars));
        }
        for(int i =1; i< grid.size(); i++){
            for(int j =0; j<grid.get(0).length(); j++){
                if(grid.get(i).charAt(j) >= grid.get(i-1).charAt(j)){
                    continue;
                }else{
                    return "NO";
                }
            }
        }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

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
 * 일단 열을 정렬해야한다.
 * 입력으로 들어오는 값은 List<String> grid이기 때문에 string을 정렬해야한다.
 * 일단 grid.get(i)로 string 한개를 가지고 와서 toCharArray()로 char배열로 바꿔준다.
 * 그리고 Arrays.sort를 사용해서 정렬시킨다.
 * 이후 다시 grid.get(i)에 넣어야하기 때문에 grid.set(i, new String(chars))로 설정해준다.
 * 그리고 배열을 가지고 이제 열을 확인해야한다.
 * grid.get(i).charAt(j)를 가지고 아래 행의 값이 그 위의 행의 값보다 크거나 같으면 된다.
 * 맞으면 계속 진행하고, 틀리면 NO, 끝까지 다 했는데 다 맞으면 YES를 반환한다.
 */