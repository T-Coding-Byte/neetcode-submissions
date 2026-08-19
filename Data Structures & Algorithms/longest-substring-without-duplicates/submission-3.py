class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        word = list(s)
        front = 0;
        rear = 0;
        longest = 0;
        subString = set()

        while rear < len(word):
            if(word[rear] not in subString):
                subString.add(word[rear])
                rear += 1
                
            else: 
                while(word[rear] in subString):
                    
                    subString.remove(word[front])
                    front += 1
                subString.add(word[rear])
                rear += 1
            longest = max(longest, len(subString))
        return longest

        