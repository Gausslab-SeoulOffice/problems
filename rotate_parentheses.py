def solution(s):
    def closed_parentheses(s):
        stack = []
        for c in s:
            if c in '{[(':
                stack.append(c)
            elif c in ')]}':
                if not stack:
                    return False

                # 괄호의 짝을 맞추고 pop하는 조건을 엄격하게 맞춰야 [)(]와 같은 경우까지 처리할 수 있음
                if c == ')' and stack[-1] == '(':
                    stack.pop()
                if c == ']' and stack[-1] == '[':
                    stack.pop()
                if c == '}' and stack[-1] == '{':
                    stack.pop()                    
        if stack:
            return False
        else:
            return True
	
    num_case = 0
    s = list(s)
    for i in range(len(s)-1):
        closed = closed_parentheses(s)
        if closed:
            num_case += 1	
        s.append(s.pop(0))
    return num_case
