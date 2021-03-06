package algorithm.alg4;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/10/28
 */
public class Solution003 {

    public static void main(String[] args) {
        System.out.println("3是素数吗? " + isPrime(3));
        System.out.println("4是素数吗? " + isPrime(4));
        System.out.println("11是素数吗? " + isPrime(11));
    }

    /**
     * 判断一个数是不是素数
     *
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if (2 > n) {
            return false;
        }

        for (int i = 2; i * i <= n; ++i) {
            if (0 == n % i) {
                return false;
            }
        }
        return true;
    }
}
