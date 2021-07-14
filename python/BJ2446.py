# -*- coding: utf-8 -*-
"""
Created on Thu Mar 26 13:27:03 2020

@author: Young Deok
"""

n=int(input())
x=2*n-1
blank=0
flag=True
ans=''
for i in range(2*n-1):
    if flag:
        for j in range(blank):
            ans+=' '
        for j in range(x):
            ans+='*'
        ans+='\n'
        if x==1:
            flag=False
            x+=2
            blank-=1
        else:    
            x-=2
            blank+=1
    else:
        for j in range(blank):
            ans+=' '
        for j in range(x):
            ans+='*'
        ans+='\n'
        x+=2
        blank-=1
print(ans[:-1])
            