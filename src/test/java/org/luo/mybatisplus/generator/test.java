package org.luo.mybatisplus.generator;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.util.ByteSource;
import org.luo.mybatisplus.utils.MD5Utils;

public class test {
    public static void main(String[] args) {

        System.out.println(ByteSource.Util.bytes("1"));
        System.out.println(MD5Utils.getMd5Simple("123456MQ=="));
    }
}
