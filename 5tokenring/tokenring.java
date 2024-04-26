import java.util.Scanner;

class tokenring{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        
        int token = 0;

        for (int i = 0; i < n; i++)
            System.out.print(" " + i);

        System.out.println(" " + 0);

        while(true){
            System.out.print("Enter sender: ");
            int s = sc.nextInt();
            System.out.print("Enter receiver: ");
            int r = sc.nextInt();
            System.out.print("Enter Data: ");
            String d = sc.next();

            System.out.println("Sender "+ s + " sending data: "+d+" to receiver "+r);

            System.out.println("Token is currently with node "+token);

            System.out.println("Token Passing");

            boolean keepgoing = true;
            for (int i = token ; (keepgoing) ; i=(i+1)%n) {
                System.out.print(i);
                if(i==s)
                keepgoing=false;
                else
                System.out.print(" --> ");
            }

            System.out.println("\nData Passing");

            boolean keepgoing1 = true;
            for (int i = s ; (keepgoing1) ; i=(i+1)%n) {
                System.out.print(i );
                if(i==r){
                    keepgoing1=false;
                }
                else
                System.out.print(" --> ");
            }

            System.out.println("\nData Received at: "+r+" which is: "+d);

            token = s;

        }

        
    }
}