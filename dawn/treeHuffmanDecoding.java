/*
Tree: Huffman Decoding

https://www.hackerrank.com/challenges/one-week-preparation-kit-tree-huffman-decoding/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-seven
 */

import java.util.*;

abstract class Node implements Comparable<Node> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right;
    public Node(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Node {


    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends Node {

    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;

*/

    void decode(String s, Node root) {
        Node current = root;
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<s.length(); i++){
            char ch =s.charAt(i);
            if(ch == '0'){
                current = current.left;
            }else{
                current = current.right;
            }

            if(current.left == null && current.right == null){
                sb.append(current.data);
                current = root;
            }
        }
        System.out.println(sb.toString());
    }



}


public class Solution {

    // input is an array of frequencies, indexed by character code
    public static Node buildTree(int[] charFreqs) {

        PriorityQueue<Node> trees = new PriorityQueue<Node>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));

        assert trees.size() > 0;

        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Node a = trees.poll();
            Node b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }

        return trees.poll();
    }

    public static Map<Character,String> mapA=new HashMap<Character ,String>();

    public static void printCodes(Node tree, StringBuffer prefix) {

        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data,prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String test= input.next();

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        Node tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for(int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }

        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);

    }
}

/***
 * 이 문제는 트리 문제인데, s는 0과 1로 이루어져 있고, 1이 나오면 오른쪽, 0이 나오면 왼쪽으로 이동해서, 알파벳을 찾고 다음 알파벳을 찾고 그걸 반환하는 문제이다.
 *
 * 일단 내가 탐색하는 위치를 정하기 위해 current라는 아이를 선언하고, 처음에 root를 넣어준다.
 * 그리고 문자열을 반환해야하기때문에 stringbuilder선언한다.
 * 그리고 s만큼 확인 하면 된다.
 * charAt으로 한개씩 확인하는데 0이면 왼쪽노드를 확인해하아니 current를 current.left로 업데이트 한다.
 * 그게 아니면1일테니 current를 current.right로 업데이트한다.
 * 이게 다 가서 발견한 노드가 리프노드, 즉, 알파벳이 나온다면 sb에 추가한다.
 * 그리고 current를 다시 root로 업데이트 해서 찾아야한다.
 * 이렇게 s의 크기만큼 다 돌리면 sb에 쌓이기 때문에 이를 반환하면 된다.
 */