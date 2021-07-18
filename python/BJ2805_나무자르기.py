# unsolved, 시간초과
s = input().split(' ')
N, M = [int(i) for i in s]
trees = [int(i) for i in input().split(' ')]

for i in  range(0,32):
    b=2**i
    t = 0
    for tree in trees:
        t += tree-b if tree > b else 0
    
    if t < M:
        i-=1
        break
    if t==M:
        break
if t==M:
    print(b)
else:
    bins = [0]*(i+1)
    for j in range(i, -1, -1):
        bins[j] = 1
        b = 0
        for k in range(i+1):
            b += 2**k if bins[k]==1 else 0
        t = 0
        for tree in trees:
            t += tree-b if tree > b else 0
        if t < M:
            bins[j]=0
    result=0
    for b in range(i+1):
        result += 2**b if bins[b]==1 else 0
    print(result)