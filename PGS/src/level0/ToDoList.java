package level0;

import java.util.Arrays;

public class ToDoList {

    public static void main(String[] args) {
        String[] todoList = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        String[] actual = solution(todoList, finished);

        String[] expected = {"practiceguitar", "studygraph"};
        System.out.println(Arrays.equals(actual, expected));
    }
    
    static String[] solution(String[] todoList, boolean[] finished) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < finished.length; i++){
            if (!finished[i]) {
                answer.append(todoList[i]).append(',');
            }
        }

        return answer.toString().split(",");
    }
}
