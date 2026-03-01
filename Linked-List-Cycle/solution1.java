/*
 *【概要】
 * ・Linked List Cycle 1周目
 * https://leetcode.com/problems/linked-list-cycle/description/
 * 
 * 
 * ・方針
 * 実装方針としては下記2つが考えられる。
 * 方針1の場合、空間的計算量がO(n)となるため方針1を採用する。
 * 
 * 1. 通過したノードをHashSetに追加し、HashSetに格納したノードと訪れたノードが同じかを判定する方法
 * 2. two pointerを利用して、two pointerが同じオブジェクトを訪れるかどうかを判定する方法
 * 　　（2つのpointerが同じオブジェクトに訪れたらサイクルがあると見なすことができる）
 * 
 * ・計算量
 * 時間的計算量：O(n)、空間的計算量：O(1)
 * 　＊n : ノード数
 * 　＊whileループが何周しようともポインタ（fast、slow）が移動するだけなのでデータ量が増えても一定のメモリ量しか利用されない
 * 
 * 
 * ・補足
 * HashSetの内部構造はHashMap（https://github.com/openjdk/jdk/blob/jdk-21%2B35/src/java.base/share/classes/java/util/HashSet.java#L106）であること、
 * HashMapの内部構造として「HashMapのインスタンスには、その性能に影響を与える2つのパラメータである初期容量および負荷係数があります。 容量はハッシュ表のバケット数であり、初期容量は単純にハッシュ表が作成された時点での容量です。 負荷係数は、ハッシュ表がどの程度いっぱいになると、その容量が自動的に増加されるかの基準です。 
 * ハッシュ表エントリ数が負荷係数と現在の容量の積を超えると、ハッシュ表のハッシュがやり直され (つまり、内部データ構造が再構築され)、ハッシュ表のバケット数は約2倍に約2倍になります。」
 * であることから、方針1はデータ量が大きくなると方針2よりも効率が悪くなると思われる。
 * 
 * 参照文献：https://docs.oracle.com/javase/jp/8/docs/api/java/util/HashMap.html
 * 
 * 
 * ・悩み
 * whileループの条件を検討するとき、fast.nextがnullになると「fast = fast.next.next;」の箇所で
 * NPEが発生発生してしまうから、「fast.next != null」になってしまうから条件に入れておこうといった思考になっています。
 * しかしこの発想は手で行えることをコードに置き換える考えとは対極にある（コードありきでの思考となっている）思考になっており、
 * この思考の流れは直した方が良いのでしょうか。
 */






public class Solution1 {
    public boolean hasCycle(ListNode head) {

        if(head == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }            
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
