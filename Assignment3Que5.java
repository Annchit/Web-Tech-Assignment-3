import java.util.Scanner;
import java.util.ArrayList;

public class Assignment3Que5 {

    static ArrayList<ArrayList<String>> ListofLists = new ArrayList<ArrayList<String>>();

    // Function for printing the steps

    static void printAllChanges(String firstWord, String secondWord, ArrayList<String> changes,int[][] cost) {

        int i = firstWord.length();
        int j = secondWord.length();

        while (true) {

            if (i == 0 || j == 0) {

              // Add this list to our List of lists.

                ListofLists.add(changes);
                break;
            }

            if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1)) {
                i--;
                j--;
            }

            else {
                boolean if1 = false, if2 = false;

                // Replace

                if (cost[i][j] == cost[i - 1][j - 1] + 1) {

                    // Add this step

                    changes.add("Change " + firstWord.charAt(i - 1) + " to " + secondWord.charAt(j - 1));
                    i--;
                    j--;

                    // note whether this 'if' was true.

                    if1 = true;
                }

                // Delete

                if (cost[i][j] == cost[i - 1][j] + 1) {
                    if (if1 == false) {
                        changes.add("Delete " + firstWord.charAt(i - 1));
                        i--;
                    } 
                    else {

                        // If the previous method was true,
                        // create a new list as a copy of previous.

                        ArrayList<String> changeword2 = new ArrayList<String>();
                        changeword2.addAll(changes);

                        // Remove last operation

                        changeword2.remove(changes.size() - 1);

                        // Add this new operation

                        changeword2.add("Delete " + firstWord.charAt(i));

                        // initiate new new instance of this
                        // function with remaining substrings

                        printAllChanges(firstWord.substring(0, i),
                                secondWord.substring(0, j + 1), changeword2,cost);
                    }

                    if2 = true;
                }
                // Add character step

                if (cost[i][j] == cost[i][j - 1] + 1) {
                    if (if1 == false && if2 == false) {
                        changes.add("Add " + secondWord.charAt(j - 1));
                        j--;
                    } else {

                        // Add steps

                        ArrayList<String> changeword2 = new ArrayList<String>();
                        changeword2.addAll(changes);
                        changeword2.remove(changes.size() - 1);
                        changeword2.add("Add " + secondWord.charAt(j));

                        // Recursively call for the next steps

                        printAllChanges(firstWord.substring(0, i + 1), secondWord.substring(0, j), changeword2,cost);
                    }
                }
            }
        }
    }

    static void printWays(String firstWord, String secondWord, ArrayList<String> changes,int[][] cost) {

        // Function to print all the ways

        printAllChanges(firstWord, secondWord, new ArrayList<String>(),cost);

        int i = 1;

        // print all the possible ways

        for (ArrayList<String> ar : ListofLists) {
            System.out.println("\nMethod " + i++ + " : \n");
            for (String s : ar) {
                System.out.println(s);
            }
        }
    }

    // Function to compute the cost matrix

    static int[][] costArray(String firstWord, String secondWord) {
        int m = firstWord.length();
        int n = secondWord.length();

        int[][] cost = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1))
                    cost[i][j] = cost[i - 1][j - 1];
                
                else {
                    int a = cost[i - 1][j - 1]; 
                    int b = cost[i][j - 1];
                    int c = cost[i - 1][j]; 

                    // minimum of three operations possible

                    cost[i][j] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i][j]++;
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) throws Exception {

        Scanner getIn = new Scanner(System.in);

        System.out.println("give first input");
        String firstWord = getIn.nextLine();
        
        System.out.println("give second input");
        String secondWord = getIn.nextLine();

        getIn.close();

        int[][] cost = costArray(firstWord, secondWord);

        printWays(firstWord, secondWord, new ArrayList<String>(),cost);
    }
}
