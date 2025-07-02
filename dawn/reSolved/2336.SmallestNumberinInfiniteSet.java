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
    int curr;
    PriorityQueue<Integer> pq;
    Set<Integer> set;

    public SmallestInfiniteSet() {
        curr = 1;
        pq = new PriorityQueue<>();
        set = new HashSet<>();
    }

    public int popSmallest() {
        if(!pq.isEmpty()){
            int small = pq.poll();
            set.remove(small);
            return small;
        }
        return curr++;
    }

    public void addBack(int num) {
        if(num<curr&&!set.contains(num)){
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
 * 이건 함수를 완성시키는 문제이다.
 *
 * popSmallest은 가장 작은수를 제거하라는 함수이다.
 * addBack은 그전에 pop한 수를 다시 추가하라는 함수이다.
 * pq에 숫자가 있으면 그걸 꺼내고, 없으면 curr이 가리키는 새로운 숫자를 반환하고 증가시키면 된다.
 * num < curr는 이미 사용된 숫자만 다시 넣을 수 있다.
 * 아직 1, 2, 3도 pop되지 않았다면 addBack(1)은 의미 없다.
 * !set.contains(num)는 같은 숫자가 여러 번 들어가지 않도록한다.
 */