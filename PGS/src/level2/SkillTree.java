package level2;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skillTree : skill_trees) {
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
