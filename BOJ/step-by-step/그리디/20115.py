import sys

def main():
    N = int(sys.stdin.readline().rstrip())
    arr = list(map(int, sys.stdin.readline().rstrip().split()))
    
    m = arr.index(max(arr))
    for i in range(N):
        if i != m:
            arr[m] += (arr[i]/2)
    print(arr[m])

if __name__ == '__main__':
    main()