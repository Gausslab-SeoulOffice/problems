/*
Simple Text Editor

https://www.hackerrank.com/challenges/one-week-preparation-kit-simple-text-editor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six
 */

import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int num = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        Stack<String> history = new Stack<>();

        for(int i =0; i<num; i++){
            int actionNum = scanner.nextInt();
            if(actionNum ==1){
                history.push(sb.toString());
                String s = scanner.next();
                sb.append(s);
            }else if(actionNum ==2){
                history.push(sb.toString());
                int deleteIndex = scanner.nextInt();
                sb.delete(sb.toString().length()-deleteIndex,sb.toString().length());
            }else if(actionNum ==3){
                int outIndex = scanner.nextInt();
                System.out.println(sb.toString().charAt(outIndex-1));
            }else{
                if (!history.isEmpty()) {
                    sb = new StringBuilder(history.pop());
                }
            }
        }
    }
}

/***
 * 이 문제는 저번 deque와 비슷하다.
 * 숫자와 문제를 입력받아서 에디터를 만드는 느낌이다.
 *
 * 일단 몇 번 입력받을지에 관한 숫자부터 scanner로 입력받는다.
 * 그리고 그만큼 실행할건데, 문자열 에디터이기때문에 stringBuilder를 선언하고, 그 전 상태가 있어야 undo를 할 수 있기 때문에 그 전 상태 저장하는 stack을 선언한다.
 * 1번의 경우 추가하는 것이기에 일단 stack에 추가해주고, sb에 추가한다.
 * 2번의 경우는 삭제하는 것이기에  일단 stack에 추가해주고 ,sb에서 제거한다.
 * 근데 제거할때 뒤에서부터 제거하기때문에 sb.delete로 길이를 준다.
 * 3번의 경우는 print하는 것이기에 print한다.
 * 4번의 경우는 undo하는것이기에 stack에 있는걸 pop해서 sb에 업데이트 시키면 된다.
 */