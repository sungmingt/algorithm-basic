package basic.algorithm.programmers.lv2;

import java.util.Arrays;
import java.util.List;

public class 스킬트리 {

    static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> reqSkills = Arrays.asList(skill.split(""));

        for (int i = 0; i < skill_trees.length; i++) {
            String[] skillTree = skill_trees[i].split("");
            int curIndex = 0;
            String reqSkill = reqSkills.get(curIndex);

            for (int j = 0; j < skillTree.length; j++) {
                if (reqSkills.contains(skillTree[j])) {

                    //현재 필요한 선행스킬과 일치하면
                    if (reqSkill.equals(skillTree[j])) {
                        if (curIndex + 1 < reqSkills.size()) {
                            reqSkill = reqSkills.get(++curIndex);
                        }
                    } else { //일치하지 않으면 false
                        answer--;
                        break;
                    }
                }
            }

            answer++;
        }

        return answer;
    }
}
