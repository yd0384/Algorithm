# -*- coding: utf-8 -*-
"""
Created on Thu Apr 18 09:25:58 2019

@author: Young Deok
"""

S=input()
st=[]
tmp=[]
check=True
for s in S:
    if s=='(':
        st.append(s)
    elif s=='[':
        st.append(s)
    elif s==')':
        if len(st)==0:
            check=False
            break
        if st.pop()=='[':
            check=False
            break
    elif s==']':
        if len(st)==0:
            check=False
            break  
        if st.pop()=='(':
            check=False
if len(st)!=0 or check==False:
    print(0)
else:    
    for s in S:
        if s=='(':
            st.append(s)
        if s=='[':
            st.append(s)
        if s==')':
            if st[-1]=='(':
                st[-1]=2
            else:
                tmp=[]
                for i in range(len(st)-1,-1,-1):
                    if st[i]!='(':
                        tmp.append(st.pop())
                    else:
                        v=0
                        for t in tmp:
                           v+=t
                        st[-1]=v*2
                        break
        if s==']':        
            if st[-1]=='[':
                st[-1]=3
            else:
                tmp=[]
                for i in range(len(st)-1,-1,-1):
                    if st[i]!='[':
                        tmp.append(st.pop())
                    else:
                        v=0
                        for t in tmp:
                           v+=t
                        st[-1]=v*3
                        break
    summ=0
    for s in st:
        summ+=s
    print(summ)