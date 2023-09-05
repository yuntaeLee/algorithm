package level2;

public class SkillTree {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        int actual = solution(skill, skillTrees);

        int expected = 2;
        System.out.println(actual == expected);
    }

    static int solution(String skill, String[] skillTrees) {
        int answer = 0;
        
        for (String skillTree : skillTrees) {
            String temp = skillTree;
            
            for (int i = 0; i < skillTree.length(); i++) {
                String s = String.valueOf(skillTree.charAt(i));
                if (!skill.contains(s)) {
                    temp = temp.replace(s, "");
                }
            }
            
            if (skill.indexOf(temp) == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
