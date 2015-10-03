/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        
        if(points.length < 3) return points.length;
        
        HashMap<Double,Integer> record = new HashMap<Double,Integer>();
        
        int len = points.length - 1;
        int result = 0;
        
        for(int i = 0;i < len;i++){
         
            record.clear();
            int samepoint = 0;
            int max = 1;
            for(int j = i + 1;j < points.length;j++){
                
                double slope;
                
                if(points[i].x == points[j].x){
                  
                  slope = Double.MAX_VALUE;
                  if(points[i].y == points[j].y){
                     
                     samepoint++; 
                     continue;
                  }
                } 
                
                else slope = 0.0 + ((double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x));
                
             
                if(!record.containsKey(slope)){
                    
                    record.put(slope,2);
                    max = max < 2 ? 2 : max;
                }    
                else {
                    
                    int temp = record.get(slope) + 1;
                    max = temp > max ? temp : max;
                    record.put(slope,temp);
                }
            
            }   
            
            result = Math.max(result,max + samepoint);
        }
        
        return result;
    }
}
