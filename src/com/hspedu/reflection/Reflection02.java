package com.hspedu.reflection;

import com.hspedu.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
          m1();
          m2();

    }
        public static void m1(){
            Cat cat =new Cat();
            long start =System.currentTimeMillis();
            for(int i=0;i<9000000;i++){
                cat.hi();
            }
            long end =System.currentTimeMillis();
            System.out.println("传统方法调用："+(end-start));
        }
        public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            Class<?> aClass = Class.forName("com.hspedu.Cat");
            Object o =aClass.newInstance();
            Method hi = aClass.getMethod("hi");
            long start = System.currentTimeMillis();
            for(int i=0;i<90000000;i++){
                hi.invoke(o);
            }
            long end = System.currentTimeMillis();
            System.out.println("反射方法调用："+(end-start));

        }
}
