// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int minRepeats(string A, string B) {
        int len1 = A.size(), len2 = B.size(), res = INT_MAX;
        for(int i=0; i<len1; i++) {

            if(A[i] == B[0]) {
                int x = i, y = 0;
                
                int curCnt = 1;
                bool check = true;
                while(y < len2) {
                    if(x == len1) {
                        x = 0;
                        curCnt++;
                    }
                    
                    if(A[x] != B[y]) {
                        check = false;
                        break;
                    }
                    
                    
                    x++, y++;
                }
                
                if(check) {
                    return curCnt;
                }
            }
            
        }
        
        return -1;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    scanf("%d ",&t);
    while (t--) {
        string A,B;
        getline(cin,A);
        getline(cin,B);

        Solution ob;
        cout << ob.minRepeats(A,B) << endl;
    }
    return 0;
}  // } Driver Code Ends