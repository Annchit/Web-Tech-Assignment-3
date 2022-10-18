import java.util.Scanner;

public class Assignment3Que1{
    public static void main(String[] args){

        Scanner getIn = new Scanner(System.in);
        int comp=0; 

        System.out.println("give input for first string ");
        String firstString = getIn.nextLine();
        
        System.out.println("give input for second string ");
        String secondString = getIn.nextLine();
        
        getIn.close();

        // the first instance that has a different value amoung the 2 strings lexicographically will 
        // tell which string evaluates to a smaller value 

        for(int iter=0; iter < firstString.length() && iter < secondString.length(); iter++){

            int stringChar1 = firstString.charAt(iter);
            int stringChar2 = secondString.charAt(iter);

            if(stringChar1 != stringChar2){
                comp = stringChar1-stringChar2;
                break;
            }
        }
        
        // in case no difference is found, check if the sizes of the two string were same

        if(comp == 0 && firstString.length() != secondString.length()){
            comp = firstString.length() - secondString.length();
        }

        if(comp > 0){
            System.out.println(" first string is lexicographically greater than second string");
        } 
        if(comp == 0){
            System.out.println(" first string is lexicographically same as second string");
        } 
        if(comp < 0){
            System.out.println(" first string is lexicographically lesser than second string");
        } 
    }
}