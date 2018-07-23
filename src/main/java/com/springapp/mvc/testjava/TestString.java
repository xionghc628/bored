package com.springapp.mvc.testjava;

public class TestString {

    /**
     * 反转字符串
     * @param chars
     * @param flag
     */
    public static void reverse(char[] chars,int flag){
        int leg = chars.length;
        if(leg/2 < flag){
            return;
        }
        char temp = chars[flag];
        chars[flag] = chars[leg-1-flag];
        chars[leg-1-flag] = temp;
        reverse(chars,flag+1);
    }

    public static void main(String[] args) {
        String str = "xionghuacheng";
        char[] chars = str.toCharArray();
        reverse(chars,0);
        System.out.println(chars);
    }
}
