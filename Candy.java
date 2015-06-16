/**
 * Created by JiahengYu on 11/06/15.
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings==null||ratings.length==0)
            return 0;
        int candies[]=new int[ratings.length];
        candies[0]=1;
        for (int i=1;i<candies.length;i++){
            if (ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }else {
                candies[i]=1;
            }
        }
        for (int i=candies.length-1;i>0;i--){
            if (ratings[i]<ratings[i-1]){
                candies[i-1]=Math.max(candies[i]+1,candies[i-1]);
            }
        }
        int sum=0;
        for (int i=0;i<candies.length;i++){
            sum+=candies[i];
        }
        return sum;
    }


    public static void main(String args[]){
        Candy test=new Candy();
        int a[]={2,1};
        System.out.print(test.candy(a));
    }
}
