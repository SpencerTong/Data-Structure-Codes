

public class ascii_art {
  public static void main(String args[]){
      int z = Integer.parseInt(args[0]);

      for (int i = 1; i<=z; i++){
        System.out.print(" ".repeat(z-i));
        System.out.print(i);
        System.out.print("*".repeat((i-1)*2));
        System.out.print(i);
        System.out.println();
      }

      for (int i = z-1; i>=1; i--){
       System.out.print(" ".repeat(z-i));
       System.out.print(i);
       System.out.print("*".repeat((i-1)*2));
       System.out.print(i);
       System.out.println();
     }
  } 


}
