import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF id;
    private int size;
    private boolean[][] sides;

    public Percolation(int n) {
        if (n <= 0) throw new IndexOutOfBoundsException("index n out of bounds");
        id = new WeightedQuickUnionUF(n*n);
        size = n;
        sides = new boolean[n][n];
    }

    private int TwoDToOneD(int row, int col) {
        return size * (row - 1) + col - 1;
    }

    public void open(int row, int col) {
        if (row < 1 | col < 1) throw new IndexOutOfBoundsException("index n out of bounds");

        sides[row - 1][col - 1] = true;

        if (row - 1 > 0 && isOpen(row - 1, col)) {
            id.union(TwoDToOneD(row - 1, col), TwoDToOneD(row, col));
        }

        if (row + 1 <= size && isOpen(row + 1, col)) {
            id.union(TwoDToOneD(row + 1, col), TwoDToOneD(row, col));
        }

        if (col - 1 > 0 && isOpen(row, col - 1)) {
            id.union(TwoDToOneD(row, col - 1), TwoDToOneD(row, col));
        }

        if (col + 1 <= size && isOpen(row, col + 1)) {
            id.union(TwoDToOneD(row, col + 1), TwoDToOneD(row, col));
        }
    }

    public boolean isOpen(int row, int col) {
        return sides[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        return id.find(TwoDToOneD(row, col)) < size;
    }

    public int numberOfOpenSites() {
        int num = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (sides[i][j]) {
                        num += 1;
                }
            }
        }
        return num;
    }

    public boolean percolates() {
        for (int j = 0; j < size; j++) {
            if (isFull(size, j)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
