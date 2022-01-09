class Solution {
    public boolean isRobotBounded(String s) {
        int n=s.length();
        int x=0,y=0;char dir='N';
        for(int i=0;i<n;i++){
            int c=s.charAt(i);
            if(c=='L'){
                if(dir=='N'){
                    dir='W';
                }else if(dir=='S'){
                    dir='E';
                }else if(dir=='E'){
                    dir='N';
                }else if(dir=='W'){
                    dir='S';
                }
            }else if(c=='R'){
                if(dir=='N'){
                    dir='E';
                }else if(dir=='S'){
                    dir='W';
                }else if(dir=='E'){
                    dir='S';
                }else if(dir=='W'){
                    dir='N';
                }
            }else{
                if(dir=='N'){
                    y++;
                }else if(dir=='S'){
                    y--;
                }else if(dir=='E'){
                    x++;
                }else if(dir=='W'){
                    x--;
                }
            }
        }
        if(x==0&&y==0) return true;
        if(dir!='N') return true;
        return false;
    }
}