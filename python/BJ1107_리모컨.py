N=int(input())
M = int(input())
if M==0:
    print(min(len(str(N)),abs(N-100)))
else:
    channels = [0]*999999
        
    brokens = input().split(' ')
    for i in range(999999):
        meet=False
        for b in brokens:
            if b in str(i):
                meet=True
                break
        if not meet:
            channels[i]=1
    if N <=100:
        m=100-N
        for i in range(0,100):
            if channels[i]==1:
                m = min(m, len(str(i))+abs(N-i))
    else:
        m=N-100
        for i in range(100, 999999):
            if channels[i]==1:
                m = min(m, len(str(i))+abs(N-i))
    print(m)