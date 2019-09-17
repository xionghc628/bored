package com.springapp.mvc.lintcode;

/*******************************************************
 * Copyright (C) 2019 iQIYI.COM - All Rights Reserved
 *
 * <p>This file is part of bored.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * <p>Author(s): xionghuacheng
 * Created: 2019/9/17
 *******************************************************/
public class LongestPalindrome {

    public static void main(String[] args) {

        System.out.println(longestPalindromeTest("abba"));
    }

    public static String longestPalindromeTest(String s) {
        String result = s.substring(0);

        char[] chars = s.toCharArray();
        int length = chars.length - 1;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int res = i;
            int f = res;
            int e = res;
            while (true) {
                if(f == e){
                    while(true){
                        if(e >= length){
                            break;
                        }
                        if(chars[e] == chars[e+1]){
                            e++;
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                f--;
                e++;
                if (f < 0 || e > length) {
                    if (e - f - 1 > max) {
                        max = e - f - 1;
                        result = s.substring(f + 1, e);
                    }
                    break;
                }
                if (chars[f] != chars[e]) {
                    if (e - f - 1 > max) {
                        max = e - f - 1;
                        result = s.substring(f + 1, e);
                    }
                    break;
                }

            }
        }

        return result;
    }

}
