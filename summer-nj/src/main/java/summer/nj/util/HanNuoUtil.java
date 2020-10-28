package summer.nj.util;

import cn.hutool.core.lang.Console;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/28
 * @since
 */
public class HanNuoUtil {
    public static void main(String[] args) {
        hanNuo(64,'a','b','c');
    }

    /**
     * 递归打印汉诺塔移动步骤
     * @param n 盘子个数
     * @param a 初始盘子
     * @param b 中间盘子
     * @param c 目的盘子
     */
    private static void hanNuo(int n,char a,char b,char c){
        if (n < 1){
            return;
        }
        if (n == 1){
            Console.log("将[{}]盘子从{} ----> {}",n,a,c);
        } else {
            // 将上面n-1个盘子从a 移动 b
            hanNuo(n-1,a,c,b);
            Console.log("将[{}]盘子从{} ----> {}",n,a,c);
            hanNuo(n-1,b,a,c);
        }
    }
}
