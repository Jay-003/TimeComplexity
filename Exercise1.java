import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        //Arraylist to store values of n.
        ArrayList<Long> values = new ArrayList<>();

        //using long to declare variables to store large values.
        long startTime, endTime, executionTime;
        long count = 1;
        long j,startingNo;

        System.out.print("Enter a positive Integer: ");

        //to take the input.
        long n = kb.nextLong();

        startTime = System.currentTimeMillis();

        //while loop to take input until the condition is false.
        while (n != 0) {
            for (long i = n; i >= 1; i--) {
                j = i;
                //condition for collatz sequence.
                while (j != 1) {
                    count++;
                    if (j % 2 == 0) {
                        j = j / 2;
                    } else {
                        j = j * 3 + 1;
                    }
                }
                values.add(count);
                count = 1;
            }
            Collections.reverse(values);
            long longestSeq = values.get(0);

            //for loop to find the starting no. of the longest sequence by iterating through the list of sequence size.
            for (Long value : values) {
                if (longestSeq < value) {
                    longestSeq = value;
                }
            }
            startingNo = values.indexOf(longestSeq) + 1;

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            //to print the observation.
            System.out.println(n + " " + (startingNo) + " " + longestSeq + " " + executionTime);

            //updating the input in the loop.
            n = kb.nextLong();
        }
    }

}
