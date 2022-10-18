import java.util.Scanner;

public class Assignment3Que2 {
    public static void main(String[] arg) {

        Scanner getIn = new Scanner(System.in);

        System.out.println("Give the size of the array ");
        int arraySize = getIn.nextInt();

        int arr[] = new int[arraySize];
        
        // Take a count array to store the count of each number in array arr

        int count[] = new int[21];

        System.out.println("give all values for the array");
        for (int iter = 0; iter < arraySize; iter++) {
            arr[iter] = getIn.nextInt();
            count[arr[iter]]++;
        }

        // Modify the count array such that each element at each index stores the sum of previous counts.

        for (int i = 1; i < 21; i++) {
            count[i] += count[i - 1];
        }
        int k = arraySize - 1;
        int sortedarray[] = new int[arraySize]; 

        // justify all the elements of the sorted array 

        while (k >= 0) {
            sortedarray[count[arr[k]] - 1] = arr[k];
            count[arr[k]] -= 1;
            k -= 1;
        }

        System.out.println("the final sorted array becomes ");
        for (int i = 0; i < arraySize; i++) {
            System.out.println(sortedarray[i]);
        }
        getIn.close();

    }
}


