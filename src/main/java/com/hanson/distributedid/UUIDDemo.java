package com.hanson.distributedid;

import java.util.UUID;

/**
 * @author hanson
 * @date 2024/3/14 21:36
 */
public class UUIDDemo {

    // UUID(Universally Unique Identifier)的标准型式包含32个16进制数字，以连字号分为五段，形式为8-4-4-4-12的36个字符
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String rawUUID = UUID.randomUUID().toString();
            System.out.println(rawUUID);
            //去除“-”
            String UUID = rawUUID.replaceAll("-","");
            System.out.println(UUID);
        }
    }
}
