package 链表;
/*
 * public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 */

/*
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 */

public class Daoshudik {
	public static ListNode getKthFromEnd(ListNode head, int k) {
		ListNode res = head;  //两个指针，先走最终指向尾
		ListNode now = head;  //一个指向结果
		
		for(int i = 1; i < k; i++) {
			now = now.next;
		}
		
		while(now.next != null) {
			now = now.next;
			res = res.next;
		}
		
		
		return res;
    }

}
