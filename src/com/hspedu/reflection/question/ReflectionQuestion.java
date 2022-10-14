package com.hspedu.reflection.question;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("calssfullpath="+classfullpath);
        System.out.println("method="+methodName);
        
        //使用反射机制
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

    }
}
