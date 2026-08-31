class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        ## dict with value count pairs
        dict = {}
        for i in range(len(nums)):
            if nums[i] not in dict:
                dict[nums[i]] = 1
            else:
                dict[nums[i]] += 1
        
        top_n = sorted(dict, key=dict.get, reverse=True)[:k]
        return top_n

        