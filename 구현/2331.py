# <내 풀이>
import sys


def main():
    A, P = map(int, sys.stdin.readline().rstrip().split())
    
    answer = [A]
    while True:
        ans = 0
        while A != 0:
            # tmp = 1
            a = A%10
            A = A//10
            # <파이썬 거듭제곱> 
            # : a**b (a의 b승)
            ans += a**P
            # 몰라서 for문 돌려 거듭제곱 해버리기 ..
            '''
            for _ in range(P):
                tmp = tmp*a
            ans += tmp
            '''
        A = ans
        if A not in answer:
            answer.append(ans)
        else:
            print(answer.index(A))
            break


if __name__ == '__main__':
    main()

# <다른 사람 풀이>
# : 문자열 사용
import sys

def main():
    A, P = map(int, sys.stdin.readline().rstrip().split())

    nums = [A]
    while True:
        tmp = 0
        for s in str(nums[-1]):
            tmp += int(s)**P
        
        if tmp in nums:
            print(nums.index(tmp))
            break
        
        nums.append(tmp)

if __name__ == '__main__':
    main()

# <알게된 점>
# - 파이썬 거듭제곱
# : a**b (a의 b승)
