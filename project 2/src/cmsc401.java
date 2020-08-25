//Joey Luck
import java.util.Scanner;

import static java.lang.Math.floor;

public class cmsc401 {
    private static int totalGardenSize;
    private static int[][] SortedFarmArray(){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
       int[][] farm = new int[size][2];
       for(int i = 0;i < size; i++){
           farm[i][0] = input.nextInt();
           farm[i][1] = input.nextInt();
           totalGardenSize = totalGardenSize + farm[i][1];
       }
       SortPipeline(farm,0,size-1);
       return farm;
    }
    private static int PartitionPipeline(int[][] farm, int left, int right)
    {
        int i = left, j = right;
        int temp;
        int tempGarden;
        int pivot = farm[(left + right) / 2][0];
        while (i <= j) {
            while (farm[i][0] < pivot)
                i++;
            while (farm[j][0] > pivot)
                j--;
            if (i <= j) {
                temp = farm[i][0];
                tempGarden = farm[i][1];
                farm[i][0] = farm[j][0];
                farm[i][1] = farm[j][1];
                farm[j][0] = temp;
                farm[j][1] = tempGarden;
                i++;
                j--;
            }
        };
        return i;
    }
    private static void SortPipeline(int[][] farm, int left, int right) {
        int index = PartitionPipeline(farm, left, right);
        if (left < index - 1)
            SortPipeline(farm, left, index - 1);
        if (index < right)
            SortPipeline(farm, index, right);
    }
    private static int IdealPipeLine(int[][] farm, int index, int sum){
        int ideal = 0;
        if(sum< floor((double)totalGardenSize/2.0)){
            sum = farm[index][1] + sum;
            ideal = IdealPipeLine(farm,index+1,sum);
        }
        else{
            return (int) floor((double)(farm[index-1][0]+farm[index][0])/2.0);
        }
        return ideal;
    }
    public static int left(int i){
        return i*2;
    }
    public static int right(int i){
        return i*2 + 1;
    }
    public static void MaxHeapify(int[] A,int n, int i){
        int l,r,largest;
        l = left(i);
        r = right(i);
        if(l<=n && A[l] > A[i]){
            largest = l;
        }
        else{
            largest = i;
        }
        if(r<=n && A[r]>A[largest]){
            largest = r;
        }
        if(largest !=i)
        {
            int temp;
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            System.out.println(A[i] +" "+A[r] + " " + r+" "+i+" "+largest);
            for(int j = 0; j<9;j++){
                System.out.print(A[j]+ ", ");

            }
            System.out.println();
            MaxHeapify(A,n,largest);
        }
    }
    public static void buildmaxHeap(int[] A, int n){
    int i;

    for(i= (int) floor(n/2); i>=1; i--)
        MaxHeapify(A,n,i);
    }

    public static void main(String[] args) {
        //int y = IdealPipeLine(SortedFarmArray(),0,0);
        //System.out.println(y);
        int[] A = {3,5,12,1,8,21,5,16,0};
        buildmaxHeap(A,8);
        for(int i = 0;i<A.length;i++) {
            System.out.print(A[i] + ", ");
        }
        //MaxHeapify
    }
}
