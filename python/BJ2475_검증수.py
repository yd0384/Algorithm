nums = map(int, input().split(' '))
result = 0
for n in nums:
    result += n*n
print(result%10)