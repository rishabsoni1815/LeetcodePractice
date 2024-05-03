class Solution {
  public int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");//I want to use the . to separate a character, because . itself is part of the regular expression, so you need to escape \, because the escape uses \, and this \ happens to be a regular expression character, so you have to use a \ , so two \\ are required.
    String[] levels2 = version2.split("\\.");
    int length = Math.max(levels1.length, levels2.length);
    for (int i=0; i<length; i++) {
    	int v1 = i < levels1.length ? Integer.valueOf(levels1[i]) : 0;
    	int v2 = i < levels2.length ? Integer.valueOf(levels2[i]) : 0;
    	if(v1>v2) return 1;
        else if(v1<v2) return -1;
    }
    
    return 0;
}
}