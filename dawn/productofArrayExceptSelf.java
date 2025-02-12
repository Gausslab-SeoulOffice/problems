/*
 * 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = 1;
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = answer[i] * left;
            left = left * nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }

}

/***
 * 이건 문제 이해자체는 쉬웠다. 나를 제외하고 나머지들을 곱해서 출력하라는 것이었다.
 * 근데 문제가 되는건 O(n)이라는 것이다.
 * 원래 바로 생각나는건 O(n^2)인데.. 그래서 좀 복잡했다.
 *
 * 일단 값을 출력하기 위해서 int[] 한개를 선언해주었다. 그 이후에 곱셈을 해야하니까 그 안에 값들을 다 1로 초기화 해준다.
 * 그리고 이제 인덱스를 사용해서 곱셈을 하는건데, 여기서 잘 생각해야할게, 각각 한개씩 완성하고 넘어가는 느낌이 아니라 전체를 left, right로 나눠서 계속 업데이트하는 방법으로 갈것이다.
 * 일단 본인보다 왼쪽에 있는걸 각 자리에 곱해준다고 생각해야한다.
 * left를 일단 1로 초기화 시킨 후에 차근차근 해보겠다.
 * 일단 i가 0이라면 answer[0]에 왼쪽에는 아무것도 없다. 그냥 left 1값을 곱해준다. 그리고 left를 업데이트 시켜준다. 지금 있는 값이 다음 수의 왼쪽에 있는 값들의 곱 되기 때문에 left에 곱해주는것이다. 기존 left에 nums[0]을 곱해둔다.
 * i가 1이라면 answer[1]에 왼쪽에 곱해놓은 값인 left가 존재한다. answer[1]의 위치엔 left를 넣는것이다. 그리고 left를 다시 업데이트 해준다.
 * 이런식으로 하면 [1, 2, 3, 4]이렇게 들어온 값의 처음 for를 돌게 되면 answer는 본인 자리의 왼쪽에 있는 값들이 곱해진 배열이 나오게 된다 [1x1, 1x1, 1x2, 1x2x3] => [1, 1, 2, 6]  이런식으로 말이다.
 * right도 방식은 동일하다. 다만 거꾸로 해준다는 것이기 때문에 for문을 뒤에서부터 돌게 되면 완성이다.
 */