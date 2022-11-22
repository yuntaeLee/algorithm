package level3;

import java.util.HashMap;
import java.util.Map;

public class MultilevelToothbrushSales {

	public static void main(String[] args) {
		
	}
	
	static class Member {
        String name;
        Member parent;
        int money;

        Member(String name, Member parent, int money) {
            this.name = name;
            this.parent = parent;
            this.money = money;
        }

        void calMoney(int money) {
            int parentMoney = money / 10;
            this.money += money - parentMoney;

            if (this.parent != null && parentMoney >= 1) {
                this.parent.calMoney(parentMoney);
            }
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Member> memberMap = new HashMap<>();

        for (String name : enroll) {
            memberMap.put(name, new Member(name, null, 0));
        }

        for (int i = 0; i < enroll.length; i++) {
            if (referral.equals("-")) continue;
            memberMap.get(enroll[i]).parent = memberMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            memberMap.get(seller[i]).calMoney(amount[i] * 100);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = memberMap.get(enroll[i]).money;
        }

        return answer;
    }

}
