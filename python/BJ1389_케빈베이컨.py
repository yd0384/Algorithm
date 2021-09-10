inf=101
N, M = [int(x) for x in input().split(' ')]
friends = {}
for i in range(1,N+1):
    friends[i]=list()
for i in range(M):
    tA, tB= [int(x) for x in input().split(' ')]
    A, B = min(tA, tB), max(tA, tB)
    friends[A].append(B)
path = list()
for i in range(N+1):
    path.append(list())
    if i>0:
        for j in range(N+1):
            if i==j:
                path[i].append(0)
            else:
                path[i].append(inf)
for i in range(1,N):
    for j in range(i+1,N+1):
        if j in friends[i]:
            path[i][j]=1
            path[j][i]=1
for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(i,N+1):
            if i==j:
                path[i][j]=0
            else:
                path[i][j]=min(path[i][j], path[i][k]+path[k][j])
                path[j][i]=path[i][j]
answer=1
vacon=inf
for i in range(1,N+1):
    num=0
    for j in range(1,N+1):
        num+=path[i][j]
    if num<vacon:
        vacon=num
        answer=i
print(answer)