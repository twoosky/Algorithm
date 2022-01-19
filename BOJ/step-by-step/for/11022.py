T = int(input())

for i in range(T):
    A, B = map(int, input().split())
    #print(f"Case #{i+1}: {A} + {B} = {A+B}")
    print("Case #%d: %d + %d = %d" %(i+1, A, B, A+B))