class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       if (asteroids == null) {
            return null;
        } else if (asteroids.length <= 1) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            if (cur > 0) { 
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && -cur > stack.peek()) { 
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(cur);
                } else if (stack.peek() == -cur) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}