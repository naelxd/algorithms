import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.util.stream.IntStream;

public class PercolationStats {

    public PercolationStats(int n, int trials) {
        if (n <= 0 | trials <= 0) throw new IndexOutOfBoundsException("index n out of bounds");
    }

    public double mean() {
        return 0.1;
    }

    public double stddev() {
        return 0.1;
    }

    public double confidenceLo() {
        return 0.1;
    }

    public double confidenceHi() {
        return 0.1;
    }

    public static void main(String[] args) {
        int trashhold = 1;
        int n = 20;

        double xs[] = new double[trashhold];

        for (int i = 0; i < trashhold; i++) {
            Percolation percolation = new Percolation(n);
            int n_tryings = 0;
            do {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    System.out.println("Opened - " + row + col);
                    n_tryings += 1;
                }
//                System.out.println(percolation.percolates());
            } while (!percolation.percolates());
            System.out.println("Percolates!");
            xs[i] = (double)n_tryings / n;
        }

        System.out.println(StdStats.mean(xs));
    }
}
