//This program detects a prime number
//Owner: Ayush Joshi

import java.util.*;
public class PrimeCheck {
    public static void main(String[] args) {
        try(Scanner sc= new Scanner(System.in)){
            int n;
            System.out.println("Number: ");
            while(true){
                if(sc.hasNextInt()){//sc.hasNextInt checks whether the input taken holds an integer value or not
                    n=sc.nextInt();
                    isprime(n);
                    break;//To break out of the infinite loop
                }else{
                    System.out.println("Error!! enter Integer values only: ");
                    sc.next();//To avoid going into infinite loop
                }
            }
        }
    }
    public static void isprime(int n){
        int count=0;
        for(int i=1; i<=Math.sqrt(n);i++){
            if(n%i == 0){
                count++;
                if(n/i != i){
                    count++;
                }
            }
        }
        if(count==2){
            System.out.println("The given number is PRIME");
        }else{
            System.out.println("The give number is NOT PRIME");
        }
    }
}
