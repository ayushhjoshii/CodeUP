//This program takes an input from the user and prints the table
//Owner: Ayush Joshi

import java.util.Scanner;
public class Table {
    public static void main(String[] args){
        printTable();
    }

    public static void printTable(){
        try(Scanner sc= new Scanner(System.in)){
            int n, multiplier;
            System.out.println("Number: ");
            if(sc.hasNextInt()){
                n=sc.nextInt();
                System.out.println("Multiplier: ");
                if(sc.hasNextInt()){
                    multiplier= sc.nextInt();
                    for(int i=1; i<=multiplier; i++){
                        System.out.println(n+" * "+i+" = "+(n*i));
                    }
                }else{
                    System.out.println("Error!! Please enter integer values only: ");
                    printTable();
                }
            }else{
                System.out.println("Error!! Please enter integer values only: ");
                printTable();
            }
            
        }
    }
}