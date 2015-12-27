package lintcode.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
	
	class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode arg0, ListNode arg1) {
			return arg0.val - arg1.val;
		}
		
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0) return null;
		
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),
									new ListNodeComparator());
		for(int i = 0; i < lists.size(); i++) {
			ListNode temp = lists.get(i);
			if(temp != null) {
				queue.add(temp);
			}
		}
		
		while(!queue.isEmpty()) {
			ListNode temp = queue.poll();
			current.next = temp;
			current = current.next;
			
			if(temp.next != null) {
				queue.add(temp.next);
			}
			current.next = null;
		}
		
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
