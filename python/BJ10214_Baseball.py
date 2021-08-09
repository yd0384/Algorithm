T=int(input())
for t in range(T):
    Y=0
    K=0
    for i in range(9):
        s=input().split()
        y=int(s[0])
        k=int(s[1])
        Y+=y
        K+=k
    if Y>K:
        print("Yonsei")
    elif Y==K:
        print("Draw")
    else:
        print("Korea")