import java.util.Stack;

/**
 * Created by JiahengYu on 07/06/15.
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        int largestArea=Integer.MIN_VALUE;
        int dp[][]=new int[height.length][height.length];
        for (int i=0;i<height.length;i++){
            dp[i][i]=height[i];
            if (dp[i][i]>largestArea)
                largestArea=dp[i][i];
        }
        for (int i=1;i<height.length-1;i++){
            for (int j=0;j<height.length-i;j++){
                int start=j;
                int end=j+i;
                int width=end-start+1;
                int minPrevious=dp[start][end-1]/(width-1);
                int minNow=minPrevious>height[end]?height[end]:minPrevious;
                dp[start][end]=minNow*width;
                if (dp[start][end]>largestArea)
                    largestArea=dp[start][end];
            }
        }
        return largestArea;
    }



    public int largestRectangleArea2(int[] height) {
        int result=Integer.MIN_VALUE;
        Stack<Integer>stack=new Stack<Integer>();
        if (height==null||height.length==0)
            return 0;
        if (height.length==1)
            return height[0];
        for (int i=0;i<height.length;) {
            if (stack.isEmpty()) {
                stack.push(i);
                i++;
            } else {
                if (height[i] >= height[stack.peek()]) {
                    stack.push(i);
                    i++;
                }
                else {
                    int m = 1;
                    if(!stack.isEmpty() && height[stack.peek()] > height[i]) {
                        if (height[stack.peek()] * m > result) {
                            result = (height[stack.pop()] * m);
                        } else {
                            stack.pop();
                        }
                        m++;
                    }
                }
            }
        }
        int m=1;
        while (!stack.isEmpty()){
            if(height[stack.peek()] * m > result ){
                result=(height[stack.pop()] * m);
            }else {
                stack.pop();
            }
            m++;
        }
        return result;
    }

    public static void main(String args[]){
        LargestRectangleinHistogram test=new LargestRectangleinHistogram();
        int []data={1,2,3,4};
        System.out.print(test.largestRectangleArea2(data));
    }
}
