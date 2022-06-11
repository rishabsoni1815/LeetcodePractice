class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        
        int solution = 0;
        for (int i = 0; i < points.length; i++)
        {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < points.length; j++)
            {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];
                
                
                int gcd = gcd(deltaX, deltaY);//as if not do this than 14 7 will be diff. from 2 1 and our method will fail
                int dX = deltaX / gcd;
                int dY = deltaY / gcd;
                
                map.put(dX + "," + dY, map.getOrDefault(dX + "," + dY, 0) + 1);
                max = Math.max(max, map.get(dX + "," + dY));
            }
            
            solution = Math.max(solution, max + 1);
        }
        
        return solution;
    }
    
    public int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
}