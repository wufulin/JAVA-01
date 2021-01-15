package com.rootcloud;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    static {
        System.out.println("Hello Xlass Initialized!");
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = this.getClass().getResource(".").getPath();
        File file = new File(path + name);
        InputStream inputStream = null;
        Class<?> c = null;

        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            for(int i = 0; i < bytes.length; i++){
                bytes[i] = (byte) (255-bytes[i]);
            }
            c = defineClass(name, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != inputStream){
                try {
                   inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        try {
            Class<?> c = new HelloClassLoader().findClass("Hello.xlass");
            Method method = c.getMethod("hello");
            method.invoke(c.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
