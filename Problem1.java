class Solution {
    public int bestClosingTime(String customers) {
        if (customers == null || customers.length()==0)
            return 0;
        int n = customers.length();
        int[] prefixN = new int[n+1];
        int[] postfixY = new int[n+1];
        for(int i =1; i<= n; i++){
            prefixN[i]=prefixN[i-1];
            if (customers.charAt(i-1)=='N')
                prefixN[i]++;
        }
        for(int i = n-1; i>=0; i--){
            postfixY[i]=postfixY[i+1];
            if (customers.charAt(i)=='Y')
                postfixY[i]++;
        }
        int minPenalty = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i<=n; i++){
            int currPenalty =prefixN[i]+postfixY[i];
            if (currPenalty < minPenalty){
                result = i;
                minPenalty = currPenalty;
            }
        }

        
        return result;
    }
}