class Solution:
    def maxArea(self, heights: List[int]) -> int:
        def area(left, right):
            
            return (right - left) * min(heights[left], heights[right])
        
        left = 0
        right = len(heights) - 1
        max = area(left,right)
        
        
        ##why would greedy work here?
        while left < right:
            if heights[left] <= heights[right]:
                left +=1
            else:
                right -= 1
            if area(left,right) > max:
                    print(left)
                    print(right)
                    max = area(left,right)
        
        return max
