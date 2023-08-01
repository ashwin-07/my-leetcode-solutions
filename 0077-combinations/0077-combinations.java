class Solution {
    
    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> allCombinations = new ArrayList<List<Integer>>();
		recurseAndBuildCombinations(allCombinations, new ArrayList<Integer>(), 1, n, k);
		return allCombinations;
	}
    
	public static void recurseAndBuildCombinations(List<List<Integer>> allCombinations,
                                       List<Integer> currCombination,
                                       int start, int n, int k) {
		if (k == 0) {
			allCombinations.add(new ArrayList<Integer>(currCombination));
			return;
		}
        
		for (int i=start; i <= n; i++) {
			currCombination.add(i);
			recurseAndBuildCombinations(allCombinations, currCombination, i+1, n, k-1);
			currCombination.remove(currCombination.size()-1);
		}
    }
	
}