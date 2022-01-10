#unsolved
class solution:
    def __init__(self):
        V = int(input())
        tree = {}
        for i in range(V):
            inputs=[int(x) for x in input().split(' ')]
            u = inputs[0]
            tree[u]=list()
            for i in range(1,len(inputs),2):
                if inputs[i]==-1:
                    break
                v = inputs[i]
                e = inputs[i+1]
                tree[u].append((v,e))
    visited = [1]

def visit()


