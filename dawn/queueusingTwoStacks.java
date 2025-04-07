/*
Queue using Two Stacks

https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-five
 */

import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int size = scanner.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<size;i++){
            int num = scanner.nextInt();
            if(num ==1){
                int element = scanner.nextInt();
                deque.offer(element);
            }else if(num ==2){
                deque.removeFirst();
            }else{
                System.out.println(deque.getFirst());
            }
        }
    }
}


/***
 * 이 문제도 비슷한 문제로 풀어본적 있다.
 * deque를 사용해서 offer, remove, return을 하라는 문제이다.
 *
 * 일단 입력부터 받아야하기때문에 scanner를 선언해준다.
 * 그리고 처음 받은 값이 deque를 이용해서 몇번 할건지 알려주는것이다.
 * deque도 선언하고 size만큼 이제 확인하면 된다.
 * 1은 추가하는 것이기에 1이 들어오면 숫자가 한 개 더 들어온다.
 * 그 숫자를 deque에 offer하면 된다.
 * 2는 삭제하는 것이기에 맨 앞에 있는걸 삭제하려면 removeFirst()를 하면 된다.
 * 3은 출력하는 것이기에 맨 앞에 있는걸 가져와서 print하면 된다.
 */