class Solution {
    public int[] finalPrices(int[] prices) {
        //finding next smaller ele
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=prices.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(prices[i]);
                res[i] = prices[i];
            }else{
                if(stack.peek()<=prices[i]){
                    res[i] = prices[i]-stack.peek();
                    stack.push(prices[i]);
                }else{
                    while(!stack.isEmpty() && stack.peek()>prices[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        res[i] = prices[i];
                    }else{
                        res[i] = prices[i]-stack.peek();
                    }
                    stack.push(prices[i]);
                }
            }
        }
        return res;
    }
}