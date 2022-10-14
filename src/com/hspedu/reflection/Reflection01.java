package com.hspedu.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, IOException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        //使用反射机制
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        //（1）加载类
        Class<?> cls = Class.forName(classfullpath);
        //(2)通过cls得到你的加载类的com.hspedu.Cat的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型："+o.getClass());//运行类型
        //(3)通过cls得到加载的类com.hspedu.Cat的Method 的hi 方法对象
        //即：载反射中，可以把方法是为对象

        Method method1 = cls.getMethod(methodName);
        //（4）通过method1调用方法：即通过方法对象来实现方法
        method1.invoke(o);

        //java.lang.reflect.Field:代表类的成员变量,
        // Field对象表示某个类的成员变量 11得到name字段
          //getField不能得到私有的属性
        Field clsField = cls.getField("age");
        System.out.println(clsField.get(o));//传统写法 对象，
        // 成员变量,反射:成员变量对象.get(对象)
        //java. lang.reflect.Constructor:代表类的构造方法, Constructor对象表示构造器
        Constructor<?> clsConstructor = cls.getConstructor();//默认可以指定参数的类型
        System.out.println(clsConstructor);

        Constructor<?> clsConstructor1 = cls.getConstructor(String.class,int.class);//传的是String的Class对象
        System.out.println(clsConstructor1);

    }
}
