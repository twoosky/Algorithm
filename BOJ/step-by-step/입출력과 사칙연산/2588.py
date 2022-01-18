A = int(input())
B = int(input())

sum = 0
for i in range(3):
    a = A*(B%10) 
    B = int(B/10)
    print(a)
    sum += (a*(10**i))

print(sum)

# <다른 사람 풀이>
# - B는 문자열로 받아 인덱싱으로 쪼개 곱함
# - 마지막 결과는 단순히 A*int(B)로 구함

'''
A = int(input())
B = input()   

print(A * int(B[2]))
print(A * int(B[1]))
print(A * int(B[0]))
print(A * int(B))
'''
