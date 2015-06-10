/**
 * Created by JiahengYu on 10/06/15.
 */
public class GasStation {
    /**
     * time limit exceeds
     */
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int diff[]=new int[gas.length];
//        for (int i=0;i<diff.length;i++){
//            diff[i]=gas[i]-cost[i];
//        }
//        for (int i=0;i<diff.length;i++){
//            if (diff[i]<=0)
//                continue;
//            else {
//                boolean circle=true;
//                int currentGas=diff[i];
//                for (int j=i+1;j<diff.length+i;j++){
//                    currentGas+=diff[j%diff.length];
//                    if (currentGas<0) {
//                        circle=false;
//                        break;
//                    }
//                }
//                if (circle)
//                    return i;
//            }
//        }
//        return -1;
//    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff[]=new int[gas.length];
        for (int i=0;i<diff.length;i++){
            diff[i]=gas[i]-cost[i];
        }
        int currentSum=0;
        int currentBeg=0;
        for (int i=0;i<diff.length;i++){
            currentSum+=diff[i];
            if(currentSum<0) {
                currentBeg = i+1;
                currentSum = 0;
            }
        }
        int Sum=0;
        for (int i=currentBeg;i<diff.length+currentBeg;i++){
            Sum+=diff[i%diff.length];
            if (Sum<0){
                return -1;
            }
        }
        return currentBeg;
    }
}
