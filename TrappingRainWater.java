/**
 * Created by JiahengYu on 01/06/15.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A==null||A.length==0||A.length==1)return 0;
        int volumn=0;
        int start=0;
        int end=A.length-1;
        while (start<A.length&&A[start]==0)
            start++;
        while (end>=0&&A[end]==0)
            end--;
        if (start>=end)
            return 0;
        for (int move=start;move<=end;move++){
            int leftPad=A[move];
            int Right=move+1;
            int currentVolumn=0;
            while (Right<=end&&A[Right]<leftPad){
                currentVolumn+=leftPad-A[Right];
                Right++;
            }
            if (Right>end){
                currentVolumn=0;
                int nextMax=-1;
                int nextIndex=-1;
                for (int secondPointer=move+1;secondPointer<=end;secondPointer++){
                    if (A[secondPointer]>nextMax) {
                        nextMax = A[secondPointer];
                        nextIndex = secondPointer;
                    }
                }
                for (int secondPointer=move+1;secondPointer<nextIndex;secondPointer++){
                    currentVolumn+=(nextMax-A[secondPointer])>0?(nextMax-A[secondPointer]):0;
                }
                volumn+=currentVolumn;
                if (nextIndex>0) {
                    move = nextIndex;
                    move--;
                }
            }else{
                move=Right-1;
                volumn+=currentVolumn;
            }
        }
        return volumn;
    }
    public static void main(String args[]){
        TrappingRainWater a= new TrappingRainWater();
        int water[]={2,1,0,2};
        int volumn=a.trap(water);
        System.out.print(volumn);
    }

}
