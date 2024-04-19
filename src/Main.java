public class Main {
    public static void main(String[] args) {
        int[] reference = {1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6};
        int frames = 3;

        FIFOFaultReplacement fifo = new FIFOFaultReplacement(reference, frames);
        System.out.println("Number of faults (FIFO): " + fifo.calculateFaults());
        LRUReplacement lru = new LRUReplacement(reference, frames);
        System.out.println("Number of faults (LRU): " + lru.calculateFaults());
        OptimalReplacement optimal = new OptimalReplacement(reference, frames);
        System.out.println("Number of faults (Optimal): " + optimal.calculateFaults());
    }
}