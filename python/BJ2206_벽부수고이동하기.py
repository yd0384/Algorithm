from collections import deque

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
MAX_VALUE = 987654321
N, M = [int(x) for x in input().split(" ")]
Map = []
for i in range(N):
    Map.append(input())
dequeue = deque()
visited = list()
dequeue.append((0, 0, 1, 1, visited))
answer = MAX_VALUE

while len(dequeue) != 0:
    current = dequeue.popleft()
    y = current[0]
    x = current[1]
    chance = current[2]
    before = current[3]
    visited = current[4]
    visited.append((y, x))
    if y == N-1 and x == M-1:
        answer = min([answer, before])
    for d in range(4):
        my = y + dy[d]
        mx = x + dx[d]
        if my >= 0 and my < N and mx >= 0 and mx < M:
            if (my, mx) not in visited:
                if Map[my][mx] == '0':
                    dequeue.append((my, mx, chance, before + 1, visited))
                elif chance == 1:
                    dequeue.append((my, mx, chance-1, before + 1, visited))
if answer == MAX_VALUE:
    print(-1)
else:
    print(answer)