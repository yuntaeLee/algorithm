package medium;

public class N2 {
	
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode() {}
		
		ListNode(int val) { this.val = val; }
		
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }

		@Override
		public String toString() {
			String ans = "[" + String.valueOf(val) + ",";
			
			while (next != null) {
				ans += next.val + ",";
				next = next.next;
			}
			
			ans = ans.substring(0, ans.length() - 1);
			
			return ans + "]";
		}
		
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		
		System.out.println(addTwoNumbers(l1, l2));
	}
	
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode ans = node;
        int sum = 0;
        
        while (l1 != null || l2 != null || sum > 0) {
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            node.next = new ListNode(sum % 10);
            sum /= 10;
            
            node = node.next;
        }
        
        return ans.next;
    }

}
