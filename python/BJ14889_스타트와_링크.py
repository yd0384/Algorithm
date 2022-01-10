import itertools
n = int(input())
s = []

for i in range(n):
    s.append([int(x) for x in input().split(' ')])
arr = dict()

for i in range(n):
    arr[i]=list()
    for j in range(i):
        arr[i].append(s[i][j]+s[j][i])
numstr = ''
for i in range(n):
    numstr+=str(i)
possible = dict()
for i, e in enumerate(itertools.permutations(numstr)):
    left=''
    right=''
    for j, f in enumerate(e):
        if(j<n/2):
            left+=f
        else:
            right+=f
    if ''.join(sorted(left, reverse=True)) not in possible and int(sorted(left, reverse=True)[1])<n/2 and ''.join(sorted(right, reverse=True)) not in possible:
        possible[''.join(sorted(left, reverse=True))]=''.join(sorted(right, reverse=True))
minimum = -1
for key, value in possible.items():
    leftSum=0
    rightSum=0    
    if minimum == -1:
        for e in itertools.combinations(key,2):
            leftSum += arr[int(e[0])][int(e[1])]
        for e in itertools.combinations(value,2):
            rightSum += arr[int(e[0])][int(e[1])]
        minus = max(leftSum, rightSum) - min(leftSum, rightSum)
        minimum=minus
    else:
        for e in itertools.combinations(key,2):
            leftSum += arr[int(e[0])][int(e[1])]
        for e in itertools.combinations(value,2):
            rightSum += arr[int(e[0])][int(e[1])]
        minus = abs(leftSum - rightSum)
        if minus < minimum:
            minimum=minus 
print(minimum)