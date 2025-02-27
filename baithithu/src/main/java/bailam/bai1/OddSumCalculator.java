package bailam.bai1;

public class OddSumCalculator {

    public int sumOddNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }
}
