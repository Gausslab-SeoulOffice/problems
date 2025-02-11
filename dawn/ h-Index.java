/*
 * 274. H-Index
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 *Example 1:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 *
 * Example 2:
 * Input: citations = [1,3,1]
 * Output: 1
 */

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h =0;
        for(int i = citations.length-1; i>= 0; i--){
            if(citations[i]>=h+1){
                h++;
            }else{
                break;
            }
        }
        return h;
    }
}

/***
 *이 문제 이해하는게 진짜 어려웠다. 그니까 논문을 인용한 횟수인데 학자가 i개의 논문을 h번 인용한 리스트인데, 연구자가 적어도 h번 이상 인용된 h개 이상의 논문을 출판한 h의 최대값을 나타내는 거다.
 * 예를 들어보자. [3, 0, 6, 1, 5]이렇게 있다는건, 학자가 5편의 논문을 낸거고 각각 인용한 횟수인 것이다.
 * 여기서 h=1이라면 1번 이상 인용한게 4개, 4 >= 1 가능 / h=2이라면 2번 이상 인용한게  3개, 3 >= 2 가능  / h=3이라면 3번 이상 인용한게 4개, 3>=3 가능 / h=4이라면 4번 이상 인용한게 2개, 2 >= 4 불가능 이기때문에 h중에 가장 큰건 3이 된다.
 *
 * 일단 int[] 배열을 Arrays.sort를 사용해서 정렬한다. 그럼 오름차순이 되기 때문에 for문을 반대로 돌려준다.
 * [3, 0, 6, 1, 5] -> [0, 1, 3, 5, 6]이렇게 나올거고, i는 4->0순서로 내려가게 된다. 그리고 h는 h+1을 해줘서 비교해주는거다. citations[4]는 6일거고, 6 >= 1이면 h++을 해주고 계속하게된다. 그렇게 되면 최대의 h를 찾을 수 있게 된다.
 */