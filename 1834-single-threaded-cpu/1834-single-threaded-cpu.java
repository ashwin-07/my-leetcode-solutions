class Solution {
    
    class Task {
        int startTime;
        int processTime;
        int index;

        public Task(int startTime, int processTime, int index) {
            this.startTime = startTime;
            this.processTime = processTime;
            this.index = index;
        }
        
                @Override
        public String toString() {
            return "Task{" +
                    "startTime=" + startTime +
                    ", processTime=" + processTime +
                    ", index=" + index +
                    '}';
        }
        
    }
    
    public int[] getOrder(int[][] tasks) {
        
        int[] taskCompletionOrder = new int[tasks.length];

        List<Task> taskList = new ArrayList<>(IntStream.range(0, tasks.length)
                .mapToObj(idx -> new Task(tasks[idx][0], tasks[idx][1], idx)).toList());
        
       

        Collections.sort(taskList, (a, b) -> a.startTime - b.startTime);
        
         
        
        Queue<Task> heap = new PriorityQueue<>((a, b) -> {
            if (a.processTime == b.processTime) {
                return a.index - b.index;
            }
            else {
                return a.processTime - b.processTime;
            }
        });
        
        
        
         int currentTime = taskList.get(0).startTime;
         int currIdx = 1, completedIdx = 0;
         heap.add(taskList.get(0));
        

        while(completedIdx < taskList.size()) {
            
            if (heap.isEmpty() && taskList.get(currIdx).startTime > currentTime) {
                Task task = taskList.get(currIdx);
                heap.add(task);
                currIdx++;
                currentTime = task.startTime;
            }
            
            while (currIdx < taskList.size() &&
                   taskList.get(currIdx).startTime <= currentTime) { 
                heap.add(taskList.get(currIdx));
                currIdx++;
    
            }
            // System.out.println(heap);
            Task currentTask = heap.poll();
            
            currentTime+= currentTask.processTime;
            // System.out.println(currentTime);
            taskCompletionOrder[completedIdx++] = currentTask.index;
        }

        
       return taskCompletionOrder;
    }
}