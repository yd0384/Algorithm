#첫번째 -가 나오면 그 뒤를 다 -로 바꾸고 순서대로 계산할 수 있다.
import re
string = input()
ops = list()
nums=[int(x) for x in re.split('\+|\-',string)]
for c in string:
    if c=='+' or c=='-':
        ops.append(c)
minus=9999
for i in range(len(ops)):
    if ops[i]=='-':
        minus=i
        break
answer=0
for i in range(len(nums)):
    if i<=minus:
        answer+=nums[i]
    else:
        answer-=nums[i]
print(answer)