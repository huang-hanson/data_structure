package com.hanson.leetcode;

/**
 * 实现一个函数，判断一个字符串是否为另一个字符串的字串
 *
 * @author hanson
 * @date 2024/3/26 14:05
 */
public class SubString {

    public static void main(String[] args) {
        String str = "abcd1234";
        String substr = "cd1";
//        String substr = "cda1";

        boolean b = judgmentSubstring(str, substr);
        String result = b ? "是" : "不是";
        System.out.println("字符串" + substr + result + "字符串" + str + "的子串。");

    }

    /**
     * @param str    原字符串
     * @param substr 子字符串
     * @return 原字符串中是否包含子字符串
     */
    public static boolean judgmentSubstring(String str, String substr) {

        int strLen = str.length();
        int subStrLen = substr.length();

        // 如果子串长度大于原串，则肯定不是子串
        if (strLen < subStrLen) {
            return false;
        }

        // 遍历原字符串，尝试匹配子串
        for (int i = 0; i <= strLen - subStrLen; i++) {
            int j;

            // 在原字符串的当前位置开始尝试匹配子串
            for (j = 0; j < subStrLen; j++) {
                if (str.charAt(i + j) != substr.charAt(j)) {
                    break;
                }
            }

            // 如果遍历完整个子串都匹配成功，则返回 true
            if (j == subStrLen) {
                return true;
            }

        }

        // 如果无法在原字符串中找到与子串匹配的部分，则返回 false
        return false;
    }
}
