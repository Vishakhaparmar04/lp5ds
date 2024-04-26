import mpi.*;

public class ArrMultiply {
    public static void main(String[] args) {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();  //id
        int size = MPI.COMM_WORLD.Size();  //number of processes

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = array.length;
        int localProduct = 1;

        int elementsPerProc = n / size;
        int start = rank * elementsPerProc;
        int end = start + elementsPerProc;

        // Compute local product
        for (int i = start; i < end; i++) {
            localProduct *= array[i];
        }

        // Display intermediate sums
        System.out.println("Processor " + rank + ": Partial product = " + localProduct);

        // Gather partial products to root processor
        int[] globalProduct = new int[1];
        MPI.COMM_WORLD.Reduce(new int[] { localProduct }, 0, globalProduct, 0, 1, MPI.INT, MPI.PROD, 0); 

        // Display final product
        if (rank == 0) {
            System.out.println("Total product = " + globalProduct[0]);
        }

        MPI.Finalize();
    }
}
// javac -cp /home/ubuntu/Downloads/mpj-v0_44/lib/mpj.jar ArrMultiply.java
// /home/ubuntu/Downloads/mpj-v0_44/bin/mpjrun.sh -np 2 ArrMultiply