package 牛客机试;
import java.util.*;

/**
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述:
 * 连续输入字符串(输入多次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 123456789
 * 输出
 * 复制
 * abc00000
 * 12345678
 * 90000000
 */

public class SplitStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            if(s.length() % 8 != 0) {
                s = s + "00000000";
            }

            while(s.length() >= 8) {
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }

}
