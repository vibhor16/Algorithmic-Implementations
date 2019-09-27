Logic:  isalnum() fn very important
class Solution(object):
    def isPalindrome(self, s):
        
        s = s.lower()
        start = 0
        end = len(s) - 1
        
        while True:
            while start < len(s) and not s[start].isalnum():
                start+=1
            
            while end >= 0 and not s[end].isalnum():
                end -=1
            
            if start > end:
                break
            
            if s[start] != s[end]:
                return False
            else:
                start+=1
                end-=1
        
        return True;
