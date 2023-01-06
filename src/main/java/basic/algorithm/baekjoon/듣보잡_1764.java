package basic.algorithm.baekjoon;

import java.util.*;

public class 듣보잡_1764 { //ArrayList.contains()와 HashSet.contains() 내부 동작방식 차이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();

        Set<String> hashSet = new HashSet<>(left);
        List<String> bothList = new ArrayList<>(right);

        for (int i = 0; i < left; i++) {
            hashSet.add(sc.next());
        }

        for (int i = 0; i < right; i++) {
            String name = sc.next();
            if (hashSet.contains(name)) {
                bothList.add(name);
            }
        }

        Collections.sort(bothList);

        System.out.println(bothList.size());
        for (String s : bothList) {
            System.out.println(s);
        }



    }
}
