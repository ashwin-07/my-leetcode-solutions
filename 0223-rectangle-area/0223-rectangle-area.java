class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
 
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        
        int area2 = (bx2 - bx1) * (by2 - by1);
        
        int overR = Math.min(bx2, ax2);
        int overL = Math.max(ax1, bx1);
        
        int overT = Math.min(ay2, by2);
        int overB = Math.max(ay1, by1);
        
        int overlap = 0;
        
        if (overR > overL && overT > overB) {
            overlap = (overR - overL) * (overT - overB);
            
        }
        
        return area1 + area2 - overlap;
        
        
    }
}