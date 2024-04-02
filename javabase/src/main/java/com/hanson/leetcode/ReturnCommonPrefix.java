package com.hanson.leetcode;

import java.util.Stack;

/**
 * 给你一个大小为n的字符串数组strs，其中包含n个字符串，编写一个函数来查找字符串数组中最长的公前缀，返回这个公共前缀
 * <p>
 * 输入：{"abca,"abc9","abca","abc8","abcc"}
 * 返回值："abc"
 *
 * @author hanson
 * @date 2024/4/2 9:57
 */
public class ReturnCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        int count = strs.length;

        String prefix = strs[0];

        for (int i = 1; i < count; i++) {

            prefix = contrastStringPrefix(prefix, strs[i]);

            if (prefix == "") {
                break;
            }

        }
        return prefix;
    }

    public String contrastStringPrefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < length && s1.charAt(index) == s2.charAt(index)) {
            index++;
        }
        return s1.substring(0, index);
    }

    public static void main(String[] args) {
        String[] str = {"abca", "abc9", "abca", "abc8", "abcc" };
        ReturnCommonPrefix returnCommonPrefix = new ReturnCommonPrefix();
        String s = returnCommonPrefix.longestCommonPrefix(str);
        System.out.println(s);
    }

}
