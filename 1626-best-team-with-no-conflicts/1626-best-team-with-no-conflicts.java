class Solution {
    
    class PlayerDetail {
        int age;
        int score;
        
        PlayerDetail(int age, int score) {
            this.age = age;
            this.score = score;
        }     
    }
    
    
    public int bestTeamScore(int[] scores, int[] ages) {    
        int n = scores.length;
        
        List<PlayerDetail> players = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            players.add(new PlayerDetail(ages[i], scores[i]));
        }
        
        Collections.sort(players, (a, b) -> a.age == b.age? Integer.compare(a.score, b.score) : Integer.compare(a.age, b.age));
        
        int[] scoresDP = new int[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            scoresDP[i] = players.get(i).score;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (players.get(j).score <= players.get(i).score) {
                    scoresDP[i] = Math.max(scoresDP[i], players.get(i).score + scoresDP[j]);
                }   
            }  
            result = Math.max(result, scoresDP[i]);
        }
        
        return result;   
    }
}
