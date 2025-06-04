/*
2336. Smallest Number in Infinite Set

You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.


Example 1:
Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]

Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
 */

class SmallestInfiniteSet {
    private int curr;
    private PriorityQueue<Integer> pq;
    private Set<Integer> set;

    public SmallestInfiniteSet() {
        curr = 1;
        pq = new PriorityQueue<>();
        set = new HashSet<>();
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int small = pq.poll();
            set.remove(small);
            return small;
        }
        return curr++;
    }

    public void addBack(int num) {
        if (num < curr && !set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

/***
 * 이 문제는 set에 들어가 있는 정수가 있을때, addBck, popSmallest 함수를 정의하라는 문제이다.
 *
 * 일단 아직 pop되지 않은 가장 작은 자연수를 추적하는 수를 curr로 설정한다.
 * 그리고 작은 수부터 나올 수 있도록 addBack으로 다시 넣은 수들을 저장해 PriorityQueue를 선언한다.
 * popSmallest를 호출하면 가장작은 수부터 나올 수 있도록 한다.
 * addBack을 할때 이미 set에 있는 수인지 확인을 한 후에 넣는다.
 */