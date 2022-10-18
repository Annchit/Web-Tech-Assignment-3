import java.util.Scanner;
import java.util.Arrays;

public class Assignment3Que3 {
    public static void main(String[] args){
        
        Scanner getIn = new Scanner(System.in);

        System.out.println("give the input string");
        String str= getIn.nextLine();
        
        getIn.close();
        
        char[] array = str.toCharArray();
        Arrays.sort(array);

        str = new String(array);
        System.out.println("The string after sorting becomes " + str);
    }
}
