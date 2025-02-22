package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N10799 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Stack<Character> stk = new Stack<>();

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            
            if (cur == '(') {
                stk.push(cur);
                continue;
            }

            if (cur == ')') {
                stk.pop();
                
                if (arr[i - 1] == '(') {
                    answer += stk.size();
                    continue;
                }

                answer++;
            }
        }

        System.out.println(answer);
    }
}
