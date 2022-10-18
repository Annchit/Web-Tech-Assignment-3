import java.util.Scanner;

public class Assignment3Que4 {
    public static void main(String[] args){

        Scanner getIn = new Scanner(System.in);

        System.out.println("give the input ");
        int input = getIn.nextInt();

        getIn.close();
        
        System.out.println("The Hailstone Sequence for " + input + " is :- ");
        
        System.out.println(input);
        
        // While n is not equal to 1 give the condition for the Hailstone Sequence using if else statements

        while(input!=1){

            if(input%2==0){
                input = input/2;
            }
            else{
                input = (3*input)+1;
            }
            System.out.println(input);
        }
    }
}
