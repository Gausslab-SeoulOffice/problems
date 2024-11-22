import math

case_number = 1
while True:
    inputs = input().strip()
    if inputs == "0":
        break
    r, w, l = map(int, inputs.split())
    
    table_diameter = 2 * r
    pizza_diagonal = math.sqrt(w**2 + l**2)
    
    # 피자가 식탁 위에 놓일 수 있는지 확인
    if pizza_diagonal <= table_diameter:
        print(f"Pizza {case_number} fits on the table.")
    else:
        print(f"Pizza {case_number} does not fit on the table.")
    
    case_number += 1
