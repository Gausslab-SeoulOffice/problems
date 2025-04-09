/*
No Prefix Set

https://www.hackerrank.com/challenges/one-week-preparation-kit-no-prefix-set/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-seven
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

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Result {

    public static void noPrefix(List<String> words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            if (!insert(word, root)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }

        System.out.println("GOOD SET");
    }

    private static boolean insert(String word, TrieNode root) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.isEndOfWord) {
                return false;
            }
            current = current.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        if (current.isEndOfWord || !current.children.isEmpty()) {
            return false;
        }

        current.isEndOfWord = true;
        return true;
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}


/***
 * 이 문제는 핵심은 한 단어가 다른 단어의 접두사가 되면 안 되고, 그 반대도 마찬가지라는 것이다.
 * set으로 풀어보려했는데 time limit도 뜨고, case마다 통과 되기도 안되기도 하길래 방법을 trie로 변경했다.
 *
 * trie의 구조는 다음과 같다.
 * children: 현재 노드에서 이어질 수 있는 문자 → 자식 노드로 연결
 * 예: a → p → p → l → e
 * isEndOfWord: 이 노드가 어떤 단어의 끝인지 여부
 * ​
 * 단어들을 하나씩 insert로 넣는다.
 * insert 중에 접두사 위반이 생기면 → 바로 BAD SET 출력하고 끝이다.
 *
 * 트라이의 루트 노드부터 탐색을 시작한다.
 * current는 지금 우리가 위치한 트라이 노드를 가리킨다.
 * 지금 노드가 기존에 어떤 단어의 끝이었다면,
 * 즉, 기존 단어가 "app"이고 내가 "apple"을 넣고 있다면,
 * "app"의 마지막 노드에 isEndOfWord == true가 되어 있을 것
 * → 이 말은:⚠️ 지금 넣고 있는 단어가 기존 단어를 포함하는 단어다!
 * 즉, 내가 기존 단어의 접두사 확장이야 → ❌ BAD SET
 *
 * 지금 문자(ch)에 해당하는 다음 노드가 없으면 새로 만들고, 있으면 그냥 따라간다.
 * 즉, 트라이를 확장해가며 탐색하는것이다.
 *
 * current.isEndOfWord:
 * 지금 내가 넣으려는 단어가 이미 트라이에 있는 단어와 똑같다면
 * → ❌ BAD SET
 * !current.children.isEmpty():
 * 지금 내가 넣은 단어는 끝났는데, 이 노드 아래에 자식 노드가 있음
 * 즉, 내가 기존 단어의 접두사라는 의미!
 * (예: 기존에 "apple"이 있고, 지금 "app"을 넣으려 하면 "app" 노드 아래에 더 있음)
 * → 이 둘 중 하나라도 걸리면 → ❌ BAD SET
 */