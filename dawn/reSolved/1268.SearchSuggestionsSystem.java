/*
1268. Search Suggestions System

You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.


Example 1:
Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].

Example 2:
Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.
 */

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);

            List<String> matches = new ArrayList<>();

            for (String product : products) {
                if (product.startsWith(prefix)) {
                    matches.add(product);
                    if (matches.size() == 3) {
                        break;
                    }
                }
            }
            result.add(matches);
        }
        return result;
    }
}

/***
 * 이 문제는 검색한 단어를 찾는 문제이다.
 *
 * 일단 sort로 products를 정렬시킨다.
 * 그리고 검색한 단어를 중심으로 시작하는 단어들을 찾을것이다.
 * product를 startsWith을 사용해서 prefix로 시작하는 단어들을 찾아서 matches 리스트에 넣는다.
 * 최대 3개까지만 가능하기 때문에 matches.size()가 3이면 break를 한다.
 * 다 찾으면 result에 matches를 넣어준다.
 * 이후 result를 반환하면 된다.
 */