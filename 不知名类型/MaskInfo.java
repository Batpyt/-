package 不知名类型;

/**
 * 给你一条个人信息字符串 S，它可能是一个 邮箱地址 ，也可能是一串 电话号码 。
 *
 * 我们将隐藏它的隐私信息，通过如下规则:
 *
 *  
 *
 * 1. 电子邮箱
 *
 * 定义名称 name 是长度大于等于 2 （length ≥ 2），并且只包含小写字母 a-z 和大写字母 A-Z 的字符串。
 *
 * 电子邮箱地址由名称 name 开头，紧接着是符号 '@'，后面接着一个名称 name，再接着一个点号 '.'，然后是一个名称 name。
 *
 * 电子邮箱地址确定为有效的，并且格式是 "name1@name2.name3"。
 *
 * 为了隐藏电子邮箱，所有的名称 name 必须被转换成小写的，并且第一个名称 name 的第一个字母和最后一个字母的中间的所有字母由 5 个 '*' 代替。
 *
 *  
 *
 * 2. 电话号码
 *
 * 电话号码是一串包括数字 0-9，以及 {'+', '-', '(', ')', ' '} 这几个字符的字符串。你可以假设电话号码包含 10 到 13 个数字。
 *
 * 电话号码的最后 10 个数字组成本地号码，在这之前的数字组成国际号码。注意，国际号码是可选的。我们只暴露最后 4 个数字并隐藏所有其他数字。
 *
 * 本地号码是有格式的，并且如 "***-***-1111" 这样显示，这里的 1 表示暴露的数字。
 *
 * 为了隐藏有国际号码的电话号码，像 "+111 111 111 1111"，我们以 "+***-***-***-1111" 的格式来显示。在本地号码前面的 '+' 号和第一个 '-' 号仅当电话号码中包含国际号码时存在。例如，一个 12 位的电话号码应当以 "+**-" 开头进行显示。
 *
 * 注意：像 "("，")"，" " 这样的不相干的字符以及不符合上述格式的额外的减号或者加号都应当被删除。
 *
 *  
 *
 * 最后，将提供的信息正确隐藏后返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/masking-personal-information
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaskInfo {
    public static void main(String[] args) {
        String s = "LeetCode@LeetCode.com";
        String s1 = "1(234)567-890";
        System.out.println(maskPII(s));
        System.out.println(maskPII(s1));
    }

    public static String maskPII(String S) {
        boolean isemail = false;
        String res = "";
        for(char c : S.toCharArray()) {
            if(c == '@') {
                isemail = true;
                break;
            }
        }
        if(isemail) {
            int i = 0;
            //System.out.println(S);
            while(true) {
                if(S.charAt(i + 1) == '@') break;
                i++;
            }
            res = S.charAt(0) + "*****" + S.charAt(i) + S.substring(i+1);
            res = res.toLowerCase();
        }
        else {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(char c : S.toCharArray()) {
                if(!Character.isDigit(c)) {
                    count++;
                }
                else {
                    sb.append(c);
                }
            }
            int size = S.length() - count;
            String s = sb.toString();
            if(s.length() == 10) {
                res = "***-***-" + s.substring(s.length() - 4);
            }
            if(s.length() == 11) {
                res = "+*-***-***-" + s.substring(s.length() - 4);
            }
            if(s.length() == 13) {
                res = "+***-***-***-" + s.substring(s.length() - 4);
            }
            if(s.length() == 12) {
                res = "+**-***-***-" + s.substring(s.length() - 4);
            }
        }
        return res;
    }
}
