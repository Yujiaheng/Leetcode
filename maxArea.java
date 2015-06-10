/**
 * Created by JiahengYu on 29/05/15.
 */
public class maxArea {
    public int maxArea(int[] height) {
        if(height.length==0||height.length==1||height==null)return 0;
        int first=0;
        int last=height.length-1;
        int result=(height[first]<height[last]?height[first]:height[last])*(last-first);
        while (first<last){
            if (height[first]<height[last]) {
                do {
                    last--;
                } while (last > first && height[last] < height[last + 1]);
                int temp = (height[first] < height[last] ? height[first] : height[last]) * (last - first);
                if (temp > result)
                    result = temp;
            }else {
                do {
                    first++;
                } while (last > first && height[first] < height[first - 1]);
                int temp = (height[first] < height[last] ? height[first] : height[last]) * (last - first);
                if (temp > result)
                    result = temp;
            }
        }
        return result;
    }
}
