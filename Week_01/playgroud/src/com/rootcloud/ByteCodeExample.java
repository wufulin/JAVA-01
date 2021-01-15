package com.rootcloud;


public class ByteCodeExample {

    private int count = 0;
    private double sum = 0.0;

    public double add(double value){
        this.sum += value;
        this.count++;
        return this.sum;
    }

    public double sub(double value){
        this.sum -= value;
        this.count++;
        return this.sum;
    }

    public double multiply(double value){
        this.sum *= value;
        this.count++;
        return this.sum;
    }

    public double divide(double value){
        if( 0 ==  value){
            return this.sum;
        }
        return this.sum/value;
    }

    public static void main(String[] args) {
        ByteCodeExample hello = new ByteCodeExample();
        double result = 0.0;
        for (int i = 0; i < 5; i++) {
            result = hello.add(i);
        }
        System.out.println(result);
        result = hello.sub(-1.0);
        System.out.println(result);
        result = hello.multiply(2.0);
        System.out.println(result);
        result = hello.divide(1.5);
        System.out.println(result);
    }
}
