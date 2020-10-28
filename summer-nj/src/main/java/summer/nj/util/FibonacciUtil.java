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

    // Recursion + Memorization
    public static BigInteger fibonacci(int n){
        Map<Integer,BigInteger> cache = new HashMap<>(n);
        cache.put(0,BigInteger.ZERO);
        cache.put(1,BigInteger.ONE);
        cache.put(2,BigInteger.ONE);
        return subStructure(n,cache);
    }

    private static BigInteger subStructure(int n,Map<Integer,BigInteger> cache){
        return cache.computeIfAbsent(n,key -> subStructure(key-1,cache).add(subStructure(n-2,cache)));
    }
}
