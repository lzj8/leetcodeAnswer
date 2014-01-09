class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		RandomListNode p = head;
		while (p != null) {
			RandomListNode next = p.next;
			RandomListNode node = new RandomListNode(p.label);
			node.next = next;
			p.next = node;
			p = next;
		}

		p = head;
		RandomListNode head2 = p.next;
		RandomListNode q = head2;
		while (p != null) {
			q.random = p.random == null ? null : p.random.next;
			p = q.next;
			if (p != null)
				q = p.next;
		}

		p = head;
		while (p != null) {
			q = p.next;
			p.next = q.next;
			p = p.next;
			if (p != null)
				q.next = p.next;
		}

		return head2;
	}
}
