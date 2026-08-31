# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        slow = dummy
        fast = dummy

        for i in range(n + 1): ##node before removal
            fast = fast.next

        while(fast != None):
            slow = slow.next
            fast = fast.next

        if slow.next == None:
            return dummy.next
        if slow.next.next == None:
            slow.next = None
        else:
            slow.next = slow.next.next
        return dummy.next
        