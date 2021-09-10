#시간초과 연산자많아지면 너무오래걸림 어떻게걸러낼지 생각
import re
def calc(nums, ops):
    if len(nums)==1:
        return nums[0]
    answers=list()
    for i in range(len(nums)-1):
        tnums=nums.copy()
        tops=ops.copy()
        a=int(tnums.pop(i))
        b=int(tnums.pop(i))
        op=tops.pop(i)
        if op=='+':
            tnums.insert(i,a+b)
        else:
            tnums.insert(i,a-b)
        answers.append(calc(tnums,tops))
    return min(answers)
string = input()
ops = list()
nums=re.split('\+|\-',string)
for c in string:
    if c=='+' or c=='-':
        ops.append(c)
print(calc(nums,ops))