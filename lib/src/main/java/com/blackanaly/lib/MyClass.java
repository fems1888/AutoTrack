package com.blackanaly.lib;

public class MyClass {
    public static void main(String args[]){

        String str = "ed##dsd##dwd##";
        String[] split = str.split("##");
        for (String s : split){
            System.out.println(s);
        }
        System.out.println(split.length);

        boolean equals = "".equals(str);

        System.out.println(equals);
        System.out.println(1572924506489L - 1572924986000L);
        System.out.println("haha ");
        for (int i = 0; i < 3 - 1; i++) {
            System.out.println("haha "+i);
        }

    }
}
