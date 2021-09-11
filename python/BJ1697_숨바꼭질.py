N, K = [int(x) for x in input().split()]
if N>=K:
    print(N-K)
else:
    flag=True
    k=0
    visited = set([N])
    pre_visited=[N]
    while flag:
        tmp_visited=[]
        for x in pre_visited:
            if x-1>=0:
                if x-1 not in visited:
                    visited.add(x-1)
                    tmp_visited.append(x-1)
                    if x-1==K:
                        flag=False
                        break
            if x+1<=1000000:
                if x+1 not in visited:
                    visited.add(x+1)
                    tmp_visited.append(x+1)
                    if x+1==K:
                        flag=False
                        break
            if x*2<=1000000:
                if x*2 not in visited:
                    visited.add(x*2)
                    tmp_visited.append(x*2)
                    if x*2==K:
                        flag=False
                        break
        pre_visited=tmp_visited.copy()
        k+=1
    print(k)