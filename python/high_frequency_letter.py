def high_frequency_letter(word):
    letters=dict()
    for letter in word:
        if letter in letters:
            letters[letter]+=1
        else:
            letters[letter]=1
    print(letters)
    ret=-1
    for k in letters.keys():
        if letters[k]>ret:
            ret=letters[k]
    return ret
print(high_frequency_letter('test'))