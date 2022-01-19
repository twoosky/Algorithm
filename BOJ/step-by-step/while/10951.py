while 1:
    try:   # 실행할 코드
        A, B = map(int, input().split())
        print(A+B)
    except:
        break   # 오류 처리 코드