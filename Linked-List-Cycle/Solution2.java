/*
 *【概要】
 * ・Linked List Cycle 2周目
 * https://leetcode.com/problems/linked-list-cycle/description/
 * 
 * 
 * ・方針
 * 実装方針としては下記2つが考えられる。
 * 今回はHashSetを利用して実装を行う
 * 
 * 1. 通過したノードをHashSetに追加し、HashSetに格納したノードと訪れたノードが同じかを判定する方法
 * 2. two pointerを利用して、two pointerが同じオブジェクトを訪れるかどうかを判定する方法
 * 　　（2つのpointerが同じオブジェクトに訪れたらサイクルがあると見なすことができる）
 * 
 * ・計算量
 * 時間的計算量：O(n)、空間的計算量：O(n)
 * 　＊n : ノード数
 */

public class Solution2 {
    public boolean hasCycle(ListNode head) {
    
        if(head == null){
            return false;
        }

        Set<ListNode> visited = new HashSet<>();

        while(head != null){

            if(visited.contains(head)){
                return true;
            }

            visited.add(head);
            head = head.next;
        }

        return false;
    }
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */