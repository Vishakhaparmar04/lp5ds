import mpi.*;

public class ArrSum1 {
    public static void main(String[] args) {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();  //id
        int size = MPI.COMM_WORLD.Size();  //number of processses

        int[] array = {1,2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = array.length;
        int localSum = 0;

        int elementsPerProc = n / size;
        int start = rank * elementsPerProc;
        int end = start + elementsPerProc;

        // Compute local sum
        for (int i = start; i < end; i++) {
            localSum += array[i];
        }

        // Display intermediate sums
        System.out.println("Processor " + rank + ": Partial sum = " + localSum);

        // Gather partial sums to root processor
        int[] globalSum = new int[1];
        MPI.COMM_WORLD.Reduce(new int[] { localSum }, 0, globalSum, 0, 1, MPI.INT, MPI.SUM, 0); //logo1iso

        // Display final sum
        if (rank == 0) {
            System.out.println("Total sum = " + globalSum[0]);
        }

        MPI.Finalize();
    }
}
// javac -cp /home/ubuntu/Downloads/mpj-v0_44/lib/mpj.jar ArrSum1.java
// /home/ubuntu/Downloads/mpj-v0_44/bin/mpjrun.sh -np 2 ArrSum1