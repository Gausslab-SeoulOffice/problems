/*
71. Simplify Path

You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:

A single period '.' represents the current directory.
A double period '..' represents the previous/parent directory.
Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
The simplified canonical path should follow these rules:

The path must start with a single slash '/'.
Directories within the path must be separated by exactly one slash '/'.
The path must not end with a slash '/', unless it is the root directory.
The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
Return the simplified canonical path.



Example 1:
Input: path = "/home/"
Output: "/home"
Explanation:
The trailing slash should be removed.

Example 2:
Input: path = "/home//foo/"
Output: "/home/foo"
Explanation:
Multiple consecutive slashes are replaced by a single one.

Example 3:
Input: path = "/home/user/Documents/../Pictures"
Output: "/home/user/Pictures"
Explanation:
A double period ".." refers to the directory up a level (the parent directory).

Example 4:
Input: path = "/../"
Output: "/"
Explanation:
Going one level up from the root directory is not possible.

Example 5:
Input: path = "/.../a/../b/c/../d/./"
Output: "/.../b/d"
Explanation:
"..." is a valid name for a directory in this problem.
 */

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pathWord = path.split("/");

        for (String word : pathWord) {
            if (word.equals("") || word.equals(".")) {
                continue;
            }

            if (word.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        if (sb.length() == 0) {
            return "/";
        } else {
            return sb.toString();
        }
    }
}

/***
 * 이 문제는 절대경로를 간단히 표시하라고 하는 것이다.
 *
 * 주의할 점은 "."은 현재 있는 경로를 의미하는것이고, ".."이건 부모경로를 의미하는 것이다.
 * 일단 경로를 확인하기 위해 stack을 선언해주고, "/"단위로 단어를 끊어준다.
 * 그리고 한 단어씩 확인하는건데 word가 ""이거나 "."이라면 현재를 의미하기 때문에 넘어간다.
 * ".."이라면 부모를 의미하게 되는데 그 전에 단어가 stack에 있다면 pop()으로 빼주고, 단어가 없으면 push로 넣어준다.
 * for를 돌게 된다면 모든게 다 돌았다는것이기에 string으로 합쳐주기위해 StringBuilder를 한개 선언한다.
 * StringBuilder에 "/+단어" 형태로 넣는다.
 * 만약에 stringBuilder가 비어 있다면 "/"를 반환하고, 비어있지 않다면 stringBuilder.toString()을 반환한다.
 */