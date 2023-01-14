class Solution {
    
    
    int findParent(int value, int[] parent) {
      
        if(parent[value] != value) {
            parent[value] = findParent(parent[value], parent);
        }
        return parent[value];
        
    }
    

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int[] parent = IntStream.range(0, 26).toArray();
        
        for (int i = 0; i < s1.length(); i++) {
            
            int char1 = s1.charAt(i) - 'a';
            int char2 = s2.charAt(i) - 'a';
            int parent1 = findParent(char1, parent);
            int parent2 = findParent(char2, parent);

            if (parent1 < parent2) {
                parent[parent2] = parent1;
            }
            else {
               parent[parent1] = parent2; 
            }  
            
        }
        

        StringBuilder response = new StringBuilder();
        
        for (char ch:baseStr.toCharArray()) {
            int newChar = 'a' + findParent(ch-'a', parent);
            response.append((char)newChar);
        }
        
        return response.toString();
    }
}