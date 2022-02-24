# <내 풀이>
import sys

def solution(members):
    sorted(members)
    for age in range(1, 201):
        for member in members:
            if member[0] == age:
                print(member[0], member[1])

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    members = []
    for _ in range(N):
        age, name = sys.stdin.readline().rstrip().split()
        members.append([int(age), name])
    solution(members)

# <sorted() 함수 key 속성 사용한 풀이> *BEST*
import sys

def solution(members):
    sort_members = sorted(members, key = lambda member: member[0])
    for member in sort_members:
        print(member[0], member[1])
    

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    members = []
    for _ in range(N):
        age, name = sys.stdin.readline().rstrip().split()
        members.append([int(age), name])
    solution(members)