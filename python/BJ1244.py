# -*- coding: utf-8 -*-
"""
Created on Thu Feb  6 17:06:49 2020

@author: Young Deok
"""
N=int(input())
state=input().split(' ')
for i in range(len(state)):
    state[i]=int(state[i])
stdn=int(input())
for i in range(stdn):
    inp=input().split(' ')
    sex=int(inp[0])
    switch=int(inp[1])
    if sex==1:
        x=switch-1
        while x<len(state):
            state[x]^=1
            x+=switch
    else:
        x=switch-1
        state[x]^=1
        low=x-1
        high=x+1
        decal=True
        while decal:
            if low <0 or high >=len(state):
                decal=False
            elif state[low]^state[high]==1:
                decal=False
            else:
                state[low]^=1
                state[high]^=1
                low-=1
                high+=1
rs=''
i=0
for s in state:
    rs+=str(s)+' '
    i+=1
    if i%20==0:
        rs+='\n'
rs=rs.strip()
print(rs)
