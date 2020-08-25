//// Joey Luck
import java.util.Scanner;
import java.lang.*;

public class cmsc401 {

    public void print1(int[][] arr,int cut,int[][] order, int total){
        for(int i = 0; i< cut; i++){
            System.out.print(arr[i][0] + " " + arr[i][1]);
            System.out.println("");
            System.out.print(order[i][0] + " " + order[i][1]);
            System.out.println(" ");
            System.out.println("next");
        }
        System.out.println(total);
    }
    public void temp(){
        Scanner input = new Scanner(System.in);
        int cost = input.nextInt();
        int cutSize = input.nextInt();
        int[] cuts = new int[cutSize];
        int[][] cutCost = new int[cutSize][2];
        int[][] order = new int[cutSize][2];
        for(int i = 0;i<cutSize;i++) {
            cuts[i] = input.nextInt();
            cutCost[i][0] = cuts[i];
            cutCost[i][1] = cost - cuts[i];
            order[i][0] = cuts[i];
            if(i>0&&cuts[i]>cuts[i-1]){
                if(cutCost[i][0]<cutCost[i-1][0]&&cutCost[i][0]<cutCost[i-1][1]){
                    order[i][1] = cost;
                    order[i-1][1] = cuts[i] - order[i-1][0];
                }
            }
            else if(i>0&&cuts[i]<cuts[i-1]){
                if(cutCost[i][0]>cutCost[i-1][0]&&cutCost[i][0]>cutCost[i-1][1]){
                    order[i][1] = cost;
                    order[i-1][1] = cuts[i] - order[i-1][0];
                }
            }
        }
        int totalMin = 0;
        for(int i = 0;i<cutSize;i++){
            if(i<cutSize-1) {
                if (cuts[i] < cuts[i + 1]) {
                    if (cutCost[i][1] > cutCost[i + 1][0]&&(double)order[i+1][0]>=cost/2.0){
                        order[i+1][1] = cost;
                        order[i][1] = cost - cuts[i+1];
                    }
                    else if(cutCost[i][1] > cutCost[i + 1][0]&&(double)order[i+1][0]<cost/2.0){
                        order[i][1] = cutCost[i+1][1] - cuts[i];
                    }
                    else if(cutCost[i][1] < cutCost[i + 1][0]){
                        if(i<cutSize-2) {
                            if (cutCost[i + 1][1] < cutCost[i][1] - cutCost[i + 2][1]&&order[i + 1][1]>cost - cuts[i]) {
                                order[i + 1][1] = cost - cuts[i];
                            }
                            else if (cutCost[i + 1][1] > cutCost[i][1] - cutCost[i + 2][1]&&order[i + 1][1]<cost - cuts[i]) {
                                if (order[i + 2][1]<cutCost[i][1]) {
                                    order[i + 2][1] = cutCost[i][1];
                                }
                                if(order[i + 1][1]<order[i + 2][0] - order[i + 1][0]){
                                    order[i + 1][1] = order[i + 2][0] - order[i + 1][0];
                                }
                            }
                        }
                        else {
                            order[i + 1][1] = cost - cuts[i];
                            order[i][1] = cuts[i-1];
                        }
                    }
                    if(i<cutSize-2) {
                        if (cutCost[i + 2][0] - cutCost[i][0]<order[i+1][1]&&cutCost[i][1] < cost/2.0){//cutCost[i + 2][0] - cutCost[i][1]  < cutCost[i + 2][0] - cutCost[i+1][1]) {//cutCost[i][1] < cutCost[i + 2][0] && cutCost[i][1] < cutCost[i + 1][0] &&
                            order[i + 2][1] = cutCost[i][1];
                            order[i+1][1] = order[i + 2][0] - order[i + 1][0];
                        }
                    }
                }
                if (cuts[i] > cuts[i + 1]) {
                    if (cutCost[i][1] < cutCost[i + 1][0]){
                        order[i+1][1] = cost;
                        order[i][1] = cost - cuts[i+1];
                    }
                    else if(cutCost[i][1] > cutCost[i + 1][0]){
                        order[i+1][1] = cost - cuts[i];
                    }
                }
            }
            totalMin = totalMin + order[i][1];
        }
        cmsc401 method = new cmsc401();
        //method.print1(cutCost,cutSize,order,totalMin);
        System.out.println(totalMin);
    }
    public static void main(String[] args) {
        cmsc401 method = new cmsc401();
        method.temp();
    }
}
