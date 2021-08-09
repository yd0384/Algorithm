s = input().split(' ')
N, M = [int(i) for i in s]
trees = [int(i) for i in input().split(' ')]

min = 0
max = 1000000000
while min<=max:
    mid = (min+max)//2
    get = sum([tree-mid if tree > mid else 0 for tree in trees])
    if get >= M:
        min = mid+1
    else:
        max = mid-1
print(max)