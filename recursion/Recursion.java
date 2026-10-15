package recursion;

public class Recursion{
    public static void main(String[] args){
        int x = 0;
        int n = 8;
        System.out.println("The fibonacci sequence of " + n); 
        for(int i = 0; i < n; i++){
            System.out.print(fibonacci(i) + " ");
        }
        
    }
    public static int stackCount(int x){
        if(x > 9){ System.out.println(); return x;} 
        x += 1;
        System.out.print(x + " ");
        stackCount(x);
        System.out.print( x + " ");
        return x; 
    }
    public static int sum(int x){
        if(x == 1) return 1; 
        x += sum(x-1); 
        return x; 
    }
    public static int fibonacci(int n){
        if(n == 1) return 1;
        else if(n < 1) return 0;
        else{ return fibonacci(n-1) + fibonacci(n-2);}
    }

}
