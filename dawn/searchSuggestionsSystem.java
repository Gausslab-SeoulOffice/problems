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
 * 이 문제는 검색어 추천 시스템이라고 생각하면 된다.
 *
 * 추천상품이 최대 3개까지 나와야한다.
 * 그럼 일단 products를 정렬하는 과정이 필요하다.
 * 정렬을 한 후에는 앞에서부터 입력하는게 무엇인지에 따라 추천상품이 달라질것이기에 substring으로 단어들을 잘라준다.
 * 그 단어로 시작하는 product를 순서대로 matches라는 리스트에 넣어서 최대 3개까지 보이게 해서 result에 넣을 것이다.
 */