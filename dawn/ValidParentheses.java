class Solution {
    public boolean isValid(String s) {
        Stack<Character> newStack = new Stack<>();
        Boolean answer = new Boolean(false);
        newStack.push(s.charAt(0));
        for(int i = 1; i<s.length();i++){
            if(newStack.size() == 0){
                newStack.push(s.charAt(i));
            }else{
                if(newStack.peek()=='('){
                    if(s.charAt(i)==')'){
                        newStack.pop();
                    }else{
                        newStack.push(s.charAt(i));
                    }
                }else if(newStack.peek() == '['){
                    if(s.charAt(i)==']'){
                        newStack.pop();
                    }else{
                        newStack.push(s.charAt(i));
                    }
                }else if (newStack.peek() == '{'){
                    if(s.charAt(i)=='}'){
                        newStack.pop();
                    }else{
                        newStack.push(s.charAt(i));
                    }
                }
            }
        }
        if(newStack.size()==0){
            answer = true;
        }
        return answer;
    }
}