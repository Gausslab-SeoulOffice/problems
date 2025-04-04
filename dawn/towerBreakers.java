/*
Tower Breakers

STDIN   Function
-----   --------
2       t = 2
2 2     n = 2, m = 2
1 4     n = 1, m = 4

2
1
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
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        // Write your code here
        if(m==1){
            return 2;
        }
        if(n %2==0){
            return 2;
        }else{
            return 1;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

                bufferedWriter.write(String.valueOf(result));
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
 * 타워를 부시는데 맨 처음은 1번이 부신다.
 * 플레이어 1과 플레이어 2가 번갈아 가며 탑을 부수는 게임을 한다.
 * 승자는 마지막으로 움직인 사람이다.
 * 두 플레이어는 항상 최선의 전략으로 움직인다.
 *
 * n개의 탑이 있음
 * 각 탑의 초기 높이는 m
 * 플레이어는 각 턴에 하나의 탑을 선택해서 높이를 낮출 수 있음
 * 단, 새 높이 h'는:
 * 1 ≤ h' < 현재 높이
 * 현재 높이 % h' == 0 (즉, 나누어 떨어져야 함)
 * 움직일 수 있는 탑이 없다면 진다
 *
 * if (m == 1) return 2;      // 탑의 높이가 1이면 플레이어 1이 바로 진다
 * else if (n % 2 == 0) return 2; // 짝수 개의 탑이면 플레이어 2가 무조건 이긴다
 * else return 1;             // 나머지는 플레이어 1이 이긴다
 *
 * 탑이 1인 경우 (m == 1)
 * → 아무것도 할 수 없음 → 1번이 바로 짐 → 2번 승
 * 탑이 짝수 개일 경우 (n % 2 == 0)
 * → 2번 플레이어가 항상 1번의 움직임을 복사해서 대칭 전략 가능
 * → 끝까지 따라가면 2번이 마지막에 움직이게 됨
 * 그 외에는 1번이 유리
 * → 먼저 움직이고, 2번이 따라 해봤자 결국 1번이 마지막에 움직임
 */