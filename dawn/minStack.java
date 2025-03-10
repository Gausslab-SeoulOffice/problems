/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

 */

class MinStack {
    private List<int[]> st;

    public MinStack() {
        st = new ArrayList<>();
    }

    public void push(int val) {
        int[] top = st.isEmpty() ? new int[] { val, val } : st.get(st.size() - 1);
        int min = top[1];
        if (val < min) {
            min = val;
        }
        st.add(new int[] { val, min });
    }

    public void pop() {
        st.remove(st.size() - 1);
    }

    public int top() {
        return st.isEmpty() ? -1 : st.get(st.size() - 1)[0];
    }

    public int getMin() {
        return st.isEmpty() ? -1 : st.get(st.size() - 1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/***
 * 이 문제는 stack을 만들어보라는 문제이다.
 *
 * 기본적으로 MinStack()은 스택을 선언한다고 생각하면 된다.
 * push는 값을 넣는거 pop()은 맨 위에 있는걸 없애는거, top()은 제일 위에 있는걸 return하는거, getMin()은 제일 작은 값을 return하는 것이다.
 * 제일 작은것과 들어간 순서를 확인해야하기 때문에 List<int[]>를 선언한다.
 * minStack은 new Array<>();를 만들면 된다.
 * push할때 제일 작은 값이 무엇인지 같이 넣어주는것이다.
 * stack에 값이 없으면 새로운 값으로 {val, val}로 넣어주고, 값이 있다면 제일 위에 있는 값을 불러온다.
 * 그리고 제일 작은 수와 방금 수를 비교해서 방금수가 더 작으면 min을 업데이트 하고, stack에 넣는다.
 * pop()은 제일 위에 있는거 삭제하면 되기때문에 remove를 사용하고 크기-1이 제일 위에 있는 인덱스 값이기에 그걸 빼준다. getMin()은 제일 작은 값을 가지고 오면 되기때문에 가장 최근에 들어간 수에서 찾으면 된다.
 */