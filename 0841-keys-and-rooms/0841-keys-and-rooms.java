class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            for (int j : rooms.get(i)) {
                if (!visited.contains(j)) {
                    stack.add(j);
                    visited.add(j);
                    if (rooms.size() == visited.size()) {
                        return true;
                    }
                }
            }
        }
        return rooms.size() == visited.size();
    }
}