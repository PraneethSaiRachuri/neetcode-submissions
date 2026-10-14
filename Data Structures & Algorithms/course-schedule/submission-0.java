class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){

            graph.add(new ArrayList<>());

        }

        for(int[] prerequistite : prerequisites) {
            
            int course = prerequistite[0];

            int prereq = prerequistite[1];

            graph.get(prereq).add(course);

            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int course = 0; course < numCourses; course++){

            if(inDegree[course] == 0 ){

                queue.offer(course);
            }
        }

        int completedCourses = 0;

        while(!queue.isEmpty()){

            int course = queue.poll();

            completedCourses++;
            
            for(int nextCourse : graph.get(course)){

                 inDegree[nextCourse]--; 

                if(inDegree[nextCourse] == 0 ){

                   queue.offer(nextCourse);
                }
            }

        }

        return completedCourses == numCourses;

    }
}
