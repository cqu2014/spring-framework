package summer.nj.util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/27
 * @since
 */
public class FibonacciUtil {
    public static void main(String[] args) {
        System.out.println(fibonacci(20));
    }

    public static BigInteger fibonacci(int n){
        Map<Integer,BigInteger> cache = new HashMap<>(n);
        cache.put(0,BigInteger.ZERO);
        cache.put(1,BigInteger.ONE);
        cache.put(2,BigInteger.ONE);
        return cache.computeIfAbsent(n,key -> fibonacci(key-1).add(fibonacci(key-2)));
    }
}
