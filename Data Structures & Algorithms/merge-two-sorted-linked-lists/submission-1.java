/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;  
        
        
        ListNode newList;
        ListNode current1;
        ListNode current2;

        if(list1.val < list2.val){
            newList = list1;
            current1 = list1.next;
            current2 = list2;

        }
        else{
            newList = list2;
            current2 = list2.next;
            current1 = list1;
        }
        
        ListNode newListTracker = newList;
        

        while((current1 != null) && (current2 != null)){
            if(current1.val < current2.val){
                newListTracker.next = current1;
                current1 = current1.next;
                newListTracker = newListTracker.next;
            }
            else{
                newListTracker.next = current2;
                current2 = current2.next;
                newListTracker = newListTracker.next;
            }

        }
        while(current1 != null){
            newListTracker.next = current1;
            current1 = current1.next;
            newListTracker = newListTracker.next;
        }
        while(current2 != null){
            newListTracker.next = current2;
            current2 = current2.next;
            newListTracker = newListTracker.next;
        }

    
    
    
    return newList;
    }
}