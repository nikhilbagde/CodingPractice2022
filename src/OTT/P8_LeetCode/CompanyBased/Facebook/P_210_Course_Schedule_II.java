package LeetCode.CompanyBased.Facebook;

import java.util.*;

public class P_210_Course_Schedule_II {
    public static void main(String[] args) {
        /*
        Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
        which is expressed as a pair: [0,1]
        Input: 4, [[1,0],[2,0],[3,1],[3,2]]
        Output: [0,1,2,3] or [0,2,1,3]
         */
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] answer = findOrder(numCourses, prerequisites);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) {
            return new int[0];
        }

        if (prerequisites == null) {
            return new int[numCourses];
        }

        int[] inDegree = new int[numCourses];
        for (int[] each : prerequisites) {
            inDegree[each[0]]++;                                //for each 1st element of prerq. which is dependent, increment the in degree counter.
        }                                                                       // by this inDegree array, ith index is the course no, at the end we know which course has how many dependencies

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);                                                 //we add all those coruses which does not have any dependencies in the queue which we will explore later
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int current = q.poll();
            result.add(current);                                // first add this current course from queue, which does not have dependencies.

            for (int[] each : prerequisites) {           // now for same course, check all other courses from the prerequisite array to check which are dependent
                if (current == each[1]) {                   // on current course.
                    inDegree[each[0]]--;                    // decrement degree if we visit it. This is like breath wise for that current course
                    //we are going to see all dependent courses and decrement the inDegree.
                    if (inDegree[each[0]] == 0) {       // if any of that dependent course has in degree zero, meaning all courses are explored then add it to the queue.
                        q.offer(each[0]);                       // next time we will explore current added course in the queue, when it gets its turn.
                    }
                }
            }
        }

        if (!(result.size() == numCourses)) {    //if result size, does not have all courses covered then we didn't cover all courses. return blank array
            return new int[0];
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
