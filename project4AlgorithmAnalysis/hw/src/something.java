////import java.util.Scanner;
////
////public class something {
////    boolean shouldCut[];
////
////    int m[][];
////
////
////
////    int optimalCut(int indexStart, int indexEnd){
////
////
////
////        int memorizedResult = m[indexStart][indexEnd];
////
////        if(memorizedResult != Double.POSITIVE_INFINITY){
////
////            return memorizedResult;
////
////        }
////
////
////
////        int minSubcutCost = (int)Double.POSITIVE_INFINITY;
////
////        for(int c=indexStart+1; c<indexEnd; c++){
////
////            if(shouldCut[c]){
////
////                int length = indexEnd - indexStart;
////
////                int cost = length + optimalCut(indexStart, c) + optimalCut(c, indexEnd);
////
////
////
////                if(cost < minSubcutCost){
////
////                    minSubcutCost = cost;
////
////                }
////
////            }
////
////        }
////
////
////
////        //There was nothing to cut. cost == 0
////
////        if(minSubcutCost == Double.POSITIVE_INFINITY) minSubcutCost = 0;
////
////
////
////        m[indexStart][indexEnd] = minSubcutCost;
////
////
////
////        return minSubcutCost;
////
////    }
////    int main(){
////
////        for(;;){
////        Scanner scan = new Scanner(System.in);
////            //Input - START
////
////            int stickLength;
////
////            stickLength = scan.nextInt();
////
////            if(stickLength == 0) break;
////
////            //Input - END
////
////
////
////            //Preprocessing - START
////
////            for(int i=0; i<=1000; i++){
////
////                shouldCut[i] = false;
////
////                for(int j=0; j<=1000; j++){
////
////                    m[i][j] = (int)Double.POSITIVE_INFINITY;
////                }
////
////            }
////
////            //Preprocessing - END
////
////
////
////            //Input - START
////
////            int numberOfCuts;
////
////            int cutIndex;
////
////            numberOfCuts  = scan.nextInt();;
////
////            for(int cut = 0; cut < numberOfCuts; cut++){
////
////                cutIndex  = scan.nextInt();;
////                shouldCut[cutIndex] = true;
////
////            }
////
////            //Input - END
////
////
////
////            //Solution - START
////
////            int optimalCost = optimalCut(0, stickLength);
////
////            System.out.println("The minimum cutting is " + optimalCost);
////        }
////        return 0;
////    }
////}
////
////    public int[][] max(int i,int cutSize,int cost, int[] cuts,int[][] cutCost,int[][] order, int totalMin) {
////        if(i<cutSize-1) {
////            if (cuts[i] < cuts[i + 1]) {
////                if (cutCost[i][1] > cutCost[i + 1][0]){
////                    order[i+1][1] = cost;
////                    order[i][1] = cost - cuts[i+1];
////                }
////                else if(cutCost[i][1] < cutCost[i + 1][0]){
////                    if(i<cutSize-2) {
////                        if (cutCost[i + 1][1] < cutCost[i][1] - cutCost[i + 2][1]&&order[i + 1][1]>cost - cuts[i]) {
////                            order[i + 1][1] = cost - cuts[i];
////                        }
////                        else if (cutCost[i + 1][1] > cutCost[i][1] - cutCost[i + 2][1]&&order[i + 1][1]<cost - cuts[i]) {
////                            if (order[i + 2][1]<cutCost[i][1]) {
////                                order[i + 2][1] = cutCost[i][1];
////                            }
////                            if(order[i + 1][1]<order[i + 2][0] - order[i + 1][0]){
////                                order[i + 1][1] = order[i + 2][0] - order[i + 1][0];
////                            }
////                        }
////                    }
////                    else {
////                        order[i + 1][1] = cost - cuts[i];
////                    }
////                }
////            }
////            if (cuts[i] > cuts[i + 1]) {
////                if (cutCost[i][1] < cutCost[i + 1][0]){
////                    order[i+1][1] = cost;
////                    order[i][1] = cost - cuts[i+1];
////                }
////                else if(cutCost[i][1] > cutCost[i + 1][0]){
////                    order[i+1][1] = cost - cuts[i];
////                }
////            }
////        }
////        order[0][2] = totalMin + order[i][1];
////        for(int j = 0; j < cutSize;j++){
////            System.out.println(order[j][0] + " " + order[j][1] + order[j][2]);
////        }
////        return order;
////    }
////    public void testMethod(){
////        Scanner input = new Scanner(System.in);
////        int cost = input.nextInt();
////        int cutSize = input.nextInt();
////        int[] cuts = new int[cutSize];
////        int[][] cutCost = new int[cutSize][cutSize+2];
////        int[][] order = new int[cutSize][2];
////        int[][] ans = new int[cutSize][3];
//////        for(int i = 0; i < cutSize; i++){
//////            cuts[i] = input.nextInt();
//////            order[i][0] = cuts[i];
//////        }
////        for(int i = 0;i<cutSize;i++) {
////            cuts[i] = input.nextInt();
////            order[i][0] = cuts[i];
////            order[i][1] = cost - cuts[i];
////            if(i>0&&cuts[i]>cuts[i-1]){
////                if(cutCost[i][0]<cutCost[i-1][0]&&cutCost[i][0]<cutCost[i-1][1]){
////                    order[i][1] = cost;
////                    order[i-1][1] = cuts[i] - order[i-1][0];
////                }
////            }
////            else if(i>0&&cuts[i]<cuts[i-1]){
////                if(cutCost[i][0]>cutCost[i-1][0]&&cutCost[i][0]>cutCost[i-1][1]){
////                    order[i][1] = cost;
////                    order[i-1][1] = cuts[i] - order[i-1][0];
////                }
////            }
////        }
////        int totalMin = 0;
////        for (int i = 0; i < cutSize;i++){
////            for (int j = 0; j < cutSize;j++){
////                if(i==0) {
////                    cutCost[i][j] = cost - cuts[j];
////                    if(j>0){
////                        if(cutCost[i][j]>cutCost[i][j-1]){
////                            cutCost[i][cutSize] = cutCost[i][j-1];
////                            cutCost[i][cutSize+1] = cost;
////                        }
////                        else if(cutCost[i][j]<cutCost[i][j-1]){
////                            cutCost[i][cutSize] = cutCost[i][j];
////                            cutCost[i][cutSize+1] = cost;
////                        }
////                    }
////                }
////                else {
////                    if(j>0) {
////                        if (cutCost[i - 1][j-1] > order[i][0] && cutCost[i - 1][j + 1] > order[i][0]) {
////                            cutCost[i][j] = cutCost[i - 1][j] - order[j][0];
////                        }
////                        if (cutCost[i - 1][j-1] < order[i][0] && cutCost[i - 1][j + 1] < order[i][0]) {
////                            cutCost[i][j] = order[i][0] - cutCost[i - 1][j];
////                        }
////                        if (cutCost[i - 1][j-1] > order[i-1][0] && cutCost[i - 1][j + 1] > order[i][0]) {
////                            cutCost[i][j] = cutCost[i - 1][j] - order[j][0];
////                        }
////                        if (cutCost[i - 1][j-1] < order[i-1][0] && cutCost[i - 1][j + 1] < order[i][0]) {
////                            cutCost[i][j] = order[i][0] - cutCost[i - 1][j];
////                        }
////                    }
////                    ans = max(j,cutSize, cost, cuts, order,ans, totalMin);
////                    totalMin = ans[0][2];
////                    if(j<cutSize-1){
////                        if(cutCost[i-1][j] > cuts[j+1]) {
////                            cutCost[i][j] = cutCost[i - 1][j] - cuts[j + 1];
////                        }
////                        else {
////                            cutCost[i][j] = cuts[j + 1] - cutCost[i - 1][j];
////                        }
//////                    if(cutCost[i-1][j-1] - cuts[j]<cutCost[i-1][j-1]){
//////                        cutCost[i][j] = cutCost[i-1][cutSize] - cuts[j];
//////                        if(cutCost[i][j]>cutCost[i-1][j-1]){
//////                            cutCost[i][cutSize] = cutCost[i][j-1];
//////                            cutCost[i][cutSize+1] = cutCost[i-1][cutSize];
//////                        }
//////                        else if(cutCost[i][j]<cutCost[i][j-1]){
//////                            cutCost[i][cutSize] = cutCost[i][j];
//////                            cutCost[i][cutSize+1] = cutCost[i-1][cutSize];
//////                        }
////                    }
////                }
////            }
////        }
////
////        //System.out.println(rodCut(cuts,cutSize));
//////        for(int i = 0; i < cutSize; i++){
//////
//////            System.out.println(order[i] + " ");
//////        }
////        //System.out.println();
////        for(int i = 0; i < cutSize; i++){
////            for(int j = 0; j < cutSize+2; j++){
////                System.out.print(cutCost[i][j] + " ");
////            }
////            System.out.println();
////        }
////        for(int i = 0; i < cutSize;i++){
////            System.out.println(order[i][0] + " " + order[i][1]);
////        }
////        System.out.println(totalMin);
////    }
////
//////    public static int rodCut(int[] price, int n)
//////    {
//////        // T[i] stores maximum profit achieved from rod of length i
//////        int[] T = new int[n + 1];
//////
//////        // consider rod of length i
//////        for (int i = 1; i <= n; i++)
//////        {
//////            // divide the rod of length i into two rods of length j
//////            // and i-j each and take maximum
//////            for (int j = 1; j <= i; j++) {
//////                T[i] = Integer.max(T[i], price[j - 1] + T[i - j]);
//////            }
//////        }
//////
//////        // T[n] stores maximum profit achieved from rod of length n
//////        return T[n];
//////    }
//////    public int methodC(int x, int y){
//////        if(x<y){
//////            return y - x;
//////        }
//////        if(y<x){
//////            return x - y;
//////        }
//////        else{
//////            return 0;
//////        }
//////    }
//////testMethod
//public  void meth(){
//        cmsc401 method = new cmsc401();
//        Scanner scan = new Scanner(System.in);
//        int cost;
//        cost = scan.nextInt();
//        shouldCut = new boolean[cost];
//        int numberOfCuts;
//        numberOfCuts  = scan.nextInt();
//        m = new int[cost+1][cost+1];
//        cutCost = new int[numberOfCuts][2];
////        for(int i=0; i<cost; i++){
////            for(int j=0; j<cost; j++){
////                m[i][j] = Integer.MAX_VALUE;
////            }
////        }
//        int[] price = new int[numberOfCuts];
//        for(int i = 0;i<numberOfCuts;i++) {
//        cutCost[i][0] = scan.nextInt();
//        price[i] = cutCost[i][0];
//        cutCost[i][1] = cost - cutCost[i][0];
//        shouldCut[cutCost[i][0]] = true;
//        }
//        int optimalCost = method.cutRod(price,numberOfCuts);//optimalCut(0, cost);
//        System.out.println("The minimum cutting is " + optimalCost);
//        optimalCost = optimalCut(0, cost);
//        System.out.println("The minimum cutting is " + optimalCost);
//        }
//    int optimalCut(int indexStart, int indexEnd){
//        int memorizedResult = m[indexStart][indexEnd];
//        if(memorizedResult != 0){//Double.NEGATIVE_INFINITY){
//            return memorizedResult;
//        }
//        int minSubcutCost = 0;//(int)Double.NEGATIVE_INFINITY;
//        for(int i=indexStart+1; i<indexEnd; i++){
//            if(shouldCut[i]){
//                int length = indexEnd - indexStart;
//                int cost = length + optimalCut(indexStart, i) + optimalCut(i, indexEnd);
//                //minSubcutCost = cost;
////                if(cost<cutCost[i][1]){
////                    cutCost[i][1] = cost;
////                }
//                if(cost > minSubcutCost){
//                    minSubcutCost = cost;
//                }
//            }
//        }
//        if(minSubcutCost != 0) { //minSubcutCost = 0;
//            m[indexStart][indexEnd] = minSubcutCost;
//        }
//        return minSubcutCost;
//    }
//int optimalCut(int indexStart, int indexEnd){
//    int memorizedResult = m[indexStart][indexEnd];
//    if(memorizedResult != Integer.MAX_VALUE){
//        return memorizedResult;
//    }
//    int minSubcutCost = Integer.MAX_VALUE;
//    for(int c=indexStart+1; c<indexEnd; c++){
//        if(shouldCut[c]){
//            int length = indexEnd - indexStart;
//            int cost = length + optimalCut(indexStart, c) + optimalCut(c, indexEnd);
//            if(cost < minSubcutCost){
//                minSubcutCost = cost;
//            }
//        }
//    }
//    //There was nothing to cut. cost == 0
//    if(minSubcutCost == Integer.MAX_VALUE){ minSubcutCost = 0;}
//    m[indexStart][indexEnd] = minSubcutCost;
//    return minSubcutCost;
//}
//    int optimalCut(int indexStart, int indexEnd){
//        int memorizedResult = m[indexStart][indexEnd];
//        if(memorizedResult != Double.POSITIVE_INFINITY){
//            return memorizedResult;
//        }
//        int minSubcutCost = (int)Double.POSITIVE_INFINITY;
//        for(int c=indexStart+1; c<indexEnd; c++){
//            if(shouldCut[c]){
//                int length = indexEnd - indexStart;
//                int cost = length + optimalCut(indexStart, c) + optimalCut(c, indexEnd);
//                if(cost < minSubcutCost){
//                    minSubcutCost = cost;
//                }
//            }
//        }
//        //There was nothing to cut. cost == 0
//        if(minSubcutCost == Double.POSITIVE_INFINITY){ minSubcutCost = 0;}
//        m[indexStart][indexEnd] = minSubcutCost;
//        return minSubcutCost;
//    }


//    int optimalCut(int indexStart, int indexEnd,int[][] cutCost){
////        int memorizedResult = m[indexStart][indexEnd];
////        if(memorizedResult != 0){//Double.NEGATIVE_INFINITY){
////            return memorizedResult;
////        }
//        int minSubcutCost = 0;//(int)Double.NEGATIVE_INFINITY;
//        for(int i=indexStart+1; i<indexEnd; i++){
//            if(shouldCut[i]){
//                int length = indexEnd - indexStart;
//                int cost = length + optimalCut(indexStart, i,cutCost) + optimalCut(i, indexEnd,cutCost);
//                if(cost < minSubcutCost){
//                    minSubcutCost = cost;
//                }
//            }
//        }
//        if(minSubcutCost != 0) { //minSubcutCost = 0;
//            m[indexStart][indexEnd] = minSubcutCost;
//        }
//        return minSubcutCost;
//    }
//  int main(){

//        for(;;){
//            Scanner scan = new Scanner(System.in);
//            //Input - START
//
//            int stickLength;
//
//            stickLength = scan.nextInt();
//
//            if(stickLength == 0) break;
//
//            //Input - END
//
//
//
//            //Preprocessing - START
//
//            for(int i=0; i<=1000; i++){
//
//                shouldCut[i] = false;
//
//                for(int j=0; j<=1000; j++){
//
//                    m[i][j] = (int)Double.POSITIVE_INFINITY;
//                }
//
//            }
//
//            //Preprocessing - END
//
//
//
//            //Input - START
//
//            int numberOfCuts;
//
//            int cutIndex;
//
//            numberOfCuts  = scan.nextInt();;
//
//            for(int cut = 0; cut < numberOfCuts; cut++){
//
//                cutIndex  = scan.nextInt();;
//                shouldCut[cutIndex] = true;
//
//            }
//
//            //Input - END
//
//
//
//            //Solution - START
//
//            int optimalCost = optimalCut(0, stickLength);
//
//            System.out.println("The minimum cutting is " + optimalCost);
//
//            //Solution - END
//
//        }



// return 0;

//}