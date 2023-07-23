class Solution {
private int[][]dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};

    class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    public double knightProbability(int N, int K, int r, int c) {
        Map<Pair, Double> cur = new HashMap<>(), next = new HashMap<>();
        cur.put(new Pair(r, c), 1.0);
        int t = K;
        while (t-- > 0) {
            for (Map.Entry<Pair, Double> point : cur.entrySet()) {
                int x = point.getKey().x, y = point.getKey().y;
                double value = point.getValue();
                for (int[] d : dir) {
                    int i = x + d[0];
                    int j = y + d[1];
                    if (i < 0 || i > N - 1 || j < 0 || j > N - 1) {
                        continue;
                    }
                    Pair tmp = new Pair(i, j);
                    next.put(tmp, next.getOrDefault(tmp, 0.0) + value);
                }
            }
            Map<Pair, Double> map = cur;
            cur = next;
            next = map;
            next.clear();
        }
        double count = 0;
        for (Double v : cur.values()) {
            count += v;
        }
        return count / Math.pow(8, K);
    }
}