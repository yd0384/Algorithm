s=input().split(' ')
kn = [int(i) for i in s]
Ks = [int(input()) for _ in range(kn[0])]
K = kn[0]
N = kn[1]
l = 1
i=0
for i in range(31):
    makable=0
    l=2**i
    for k in Ks:
        makable += k//l
    if makable<N:
        l/=2
        i-=1        
        break
bins = [0]*(i+1)
for j in range(i,-1,-1):
    bins[j]=1
    l=0
    for b in range(i+1):
        if(bins[b]==1):
            l+=2**b
    makable=0
    for k in Ks:
        makable += k//l
    if makable<N:
        bins[j]=0
l=0
for b in range(i+1):
    if(bins[b]==1):
        l+=2**b
print(l)