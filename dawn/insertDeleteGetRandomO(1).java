/*
 * 380. Insert Delete GetRandom O(1)
 *
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 * Example 1:
 *
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 */

class RandomizedSet {
    ArrayList<Integer> answerList;
    HashMap<Integer, Integer> map;
    Random random;


    public RandomizedSet() {
        answerList = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        answerList.add(val);
        map.put(val, answerList.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int lastElement = answerList.get(answerList.size()-1);
        answerList.set(index, lastElement);
        map.put(lastElement, index);

        answerList.remove(answerList.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        if(answerList.isEmpty()){
            return -1;
        }
        int randomIndex = random.nextInt(answerList.size());
        return answerList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/***
 *이건 문제 자체를 이해 못해서 해설의 도움을 좀 받았다.
 * 그냥 함수를 완성시키라는 것이다. insert는 val이 없으면 삽입 시키고 true, 있으면 false를 말하는 것이고,
 * remove는 val이 있으면 삭제시키고 true, 없으면 false이다.
 * getRandom은 그냥 있는 수에서 아무거나 나오면 되는것이다.
 *
 * 여기서 일단 숫자를 등록하고 삭제하고 꺼내는 ArrayList한개가 필요하고, 그걸 왔다갔다하는 값들을 저장하는 map, 그리고 random한 수를 뽑아야해서 Random 한개를 선언한다.
 * RandomizedSetd은 초기화 시키는 역할을 한다.
 * insert는 val이라는 값이 있으면 false를 리턴하고, 없으면, 일단 ArrayList에 저장한다. 그리고 map에 넣는데, (val, arrayList크기 -1)을 저장한다.
 * remove는 val이라는 값이 없으면 false를 리턴하고, 있으면 일단 map에서 val를 이용해 value를 가지고 온다.
 * //remove는 다음에 이어서 이해해보겠다.
 * getRandom은 arrayList에 값이 한개도 없으면 -1을 리턴하고, 있으면 갯수를 중에 random을 불러 그 수를 인덱스로 사용해서 arrayList에서 get해온다.
 * 이건 내일 다시 한 번 풀어봐야할거 같다.
 */