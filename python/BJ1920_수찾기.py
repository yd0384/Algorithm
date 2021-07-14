#map 대신 list comprehesion을 쓰는 것이 더 pythonic하다고 한다.
#map은 object를 return하기 때문에 python3에서는 잘 안쓴다고 한다.
#set, dictionary는 hash를 사용해서 in 연산자 속도가 O(1)에 가깝다고 한다.
import sys
N = int(input())
A = [int(x) for x in sys.stdin.readline().split(' ')]
M = int(input())
B = [int(x) for x in sys.stdin.readline().split(' ')]
Aset=set(A)
for b in B:
    if b in Aset:
        print(1)
    else:
        print(0)