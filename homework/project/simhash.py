
class simhash():
    def __init__(self, tokens='', hashbits=128):
        self.hashbits = hashbits
        self.hash = self.simhash(tokens)
 
    def __str__(self):
        return str(self.hash)
 
    def __long__(self):
        return long(self.hash)
 
    def __float__(self):
        return float(self.hash)
 
    def simhash(self, tokens):
        # Returns a Charikar simhash with appropriate bitlength
        v = [0]*self.hashbits
 
        for t in [self._string_hash(x) for x in tokens]:
            bitmask = 0
            #print (t)
            for i in range(self.hashbits):
                bitmask = 1 << i
                #print(t,bitmask, t & bitmask)
                if t & bitmask:
                    v[i] += 1 #Check current bit is 1 or not, if yes, current bit plus 1
                else:
                    v[i] += -1 #Otherwise, current bit minus 1.
 
        fingerprint = 0
        for i in range(self.hashbits):
            if v[i] >= 0:
                fingerprint += 1 << i
                print fingerprint
        print fingerprint
        return fingerprint
 
    def _string_hash(self, v):
        # A variable-length version of Python's builtin hash
        if v == "":
            return 0
        else:
            x = ord(v[0])<<7
            m = 1000003
            mask = 2**self.hashbits-1
            for c in v:
                x = ((x*m)^ord(c)) & mask
            x ^= len(v)
            if x == -1:
                x = -2
            return x
 
    def hamming_distance(self, other_hash):
        x = (self.hash ^ other_hash.hash) & ((1 << self.hashbits) - 1)
        tot = 0
        while x:
            tot += 1
            x &= x-1
        return tot

    
    '''
    def similarity(self, other_hash):
        a = float(self.hash)
        b = float(other_hash.hash)
        if a>b: return b/a
        return a/b
   '''
"""
def similarity(a,b):
    a = float(a)
    b = float(b)
    if a>b: return b/a
    return a/b
"""

def hamming_distance(_hash, other_hash, bitLength):
    x = (_hash ^ other_hash) & ((1 << bitLength) - 1)
    tot = 0
    while x:
        tot += 1
        x &= x-1
    return tot

if __name__ == '__main__':
    
    s1 = 'This is google test'
    hash1 =simhash(s1.split())
    #print("0x%x" % hash1)
    print ("%s\t[simhash = 0x%x]" % (s1, hash1))
    print ("%s\t[hash = 0x%x]" % (s1, hash1._string_hash(s1)))
    #print hash1._string_hash(s1)
  
    s2 = 'For example: This is google test'
    hash2 = simhash(s2.split())
    print ("%s\t[simhash = 0x%x]" % (s2, hash2))
    print ("%s\t[hash = 0x%x]" % (s2, hash2._string_hash(s2)))
    #print hash2._string_hash(s2)
 
    
 
    #print '%f%% percent similarity on simhash' %(100*(hash1.similarity(hash2)))
    print "Simhash Hamming distance: ",hash1.hamming_distance(hash2),"bits differ out of", hash1.hashbits

    #print '%f%% percent similarity on hash' %(100*similarity(hash1._string_hash(s1),hash2._string_hash(s2)))
    print "Hash Hamming distance: ",hamming_distance(hash1._string_hash(s1),hash2._string_hash(s2),128),"bits differ out of", hash1.hashbits 
    