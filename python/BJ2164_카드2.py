from collections import deque
n = int(input())
queue = deque([i+1 for i in range(n)])
while True:
    if len(queue)==1:
        print(queue.popleft())
        break
    queue.popleft()
    queue.rotate(-1)