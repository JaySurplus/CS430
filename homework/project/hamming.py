import hashlib

def md5(string):
    m = hashlib.md5()
    m.update(string)
    return m.hexdigest()

def hamming_distance(_hash, other_hash, bitLength):
    x = (_hash ^ other_hash) & ((1 << bitLength) - 1)
    tot = 0
    while x:
        tot += 1
        x &= x-1
    return tot

if __name__ == '__main__':
    s2 = 'For example: This is google test'
    s1 = 'This is google test'

    print bin(md5(s1))
    print bin(md5(s2))


    print hamming_distance(s1,s2,128)