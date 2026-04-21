
//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}



public class step1 {
    public ListNode detectCycle(ListNode head) {

        if(head == null) {
            return null;
        }

        
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;


        while(current != null) {

            if(visited.contains(current)) {
                return current;
            }

            visited.add(current);
            current = current.next;
        }

        return null;
    }
}