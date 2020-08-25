// Joey Luck
import java.util.Scanner;
import java.lang.*;

public class cmsc401 {
    /// builds a boolean matrix
    public int InitializeMatrix(){
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine().trim());
        int M = Integer.parseInt(input.nextLine().trim());
        int result = 0;
        if(N>=3 && N<=100 && M>=3 && M<=100 ) {
            boolean[][] courses = new boolean[N][M];
            int hallsAvailable[] = new int[M];
            // sets an array for the halls available
            for (int i = 0; i < M; ++i) {
                hallsAvailable[i] = -1;
            }
            // goes through each course to determine availability of halls
            for (int course = 0; course < N; course++) {
                int count = 0;
                boolean booked[] = new boolean[M];
                // sets an array to keep track of what halls are booked
                for (int i = 0; i < M; ++i) {
                    booked[i] = false;
                }
                String variable = input.nextLine();
                String[] halls = variable.split(" "); // splits line into string array
                int size = halls.length;
                // takes apart the input
                for (int j = 0; j < size; j++) {
                    // finds a c and sets count to the value
                    if (halls[j].contains("C")) {
                        String has = halls[j].replace("C", "").replace(":", "").trim();
                        int num = Integer.parseInt(has);
                        count = num - 1;
                    }
                    // finds an h and uses the number to set its place in the matrix to true
                    if (halls[j].contains("H")) {
                        String has = halls[j].replace("H", "").trim();
                        int num = Integer.parseInt(has);
                        courses[count][num - 1] = true;
                    }
                }
                if (Availability(courses, course, booked, hallsAvailable, M)) {
                    result++;
                }
            }
        }
        input.close();
        return result;
    }
        boolean Availability(boolean courses[][], int course,
                    boolean booked[], int halls[],int M)
        {
            // checks through each hall to see if its been booked
            for (int hall = 0; hall < M; hall++)
            {
                // checks if its a possibility for the course and if its been booked
                if (courses[course][hall] && !booked[hall])
                {
                    booked[hall] = true;
                    if (halls[hall] < 0 || Availability(courses, halls[hall],
                            booked, halls,M))
                    {
                        halls[hall] = course;
                        return true;
                    }
                }
            }
            return false;
        }
        public static void main(String[] args) {
            cmsc401 method = new cmsc401();
            System.out.println(method.InitializeMatrix());
    }
}
