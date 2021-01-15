## 1. 字节码文件分析

源文件ByteCodeExample.java

```java
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

```



使用javac src\com\rootcloud\ByteCodeExample.java编译后结果如下：

```java
D:\code\backend\playgroud>javac src\com\rootcloud\ByteCodeExample.java

D:\code\backend\playgroud>javap -c -v src\com\rootcloud\ByteCodeExample.class
Classfile /D:/code/backend/playgroud/src/com/rootcloud/ByteCodeExample.class
  Last modified 2021-1-15; size 1047 bytes
  MD5 checksum 265299162e8e0165e56fdb9ea81d7e74
  Compiled from "ByteCodeExample.java"
public class com.rootcloud.ByteCodeExample
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #18.#38        // java/lang/Object."<init>":()V
   #2 = Fieldref           #4.#39         // com/rootcloud/ByteCodeExample.count:I
   #3 = Fieldref           #4.#40         // com/rootcloud/ByteCodeExample.sum:D
   #4 = Class              #41            // com/rootcloud/ByteCodeExample
   #5 = Methodref          #4.#38         // com/rootcloud/ByteCodeExample."<init>":()V
   #6 = Methodref          #4.#42         // com/rootcloud/ByteCodeExample.add:(D)D
   #7 = Fieldref           #43.#44        // java/lang/System.out:Ljava/io/PrintStream;
   #8 = Methodref          #45.#46        // java/io/PrintStream.println:(D)V
   #9 = Double             -1.0d
  #11 = Methodref          #4.#47         // com/rootcloud/ByteCodeExample.sub:(D)D
  #12 = Double             2.0d
  #14 = Methodref          #4.#48         // com/rootcloud/ByteCodeExample.multiply:(D)D
  #15 = Double             1.5d
  #17 = Methodref          #4.#49         // com/rootcloud/ByteCodeExample.divide:(D)D
  #18 = Class              #50            // java/lang/Object
  #19 = Utf8               count
  #20 = Utf8               I
  #21 = Utf8               sum
  #22 = Utf8               D
  #23 = Utf8               <init>
  #24 = Utf8               ()V
  #25 = Utf8               Code
  #26 = Utf8               LineNumberTable
  #27 = Utf8               add
  #28 = Utf8               (D)D
  #29 = Utf8               sub
  #30 = Utf8               multiply
  #31 = Utf8               divide
  #32 = Utf8               StackMapTable
  #33 = Utf8               main
  #34 = Utf8               ([Ljava/lang/String;)V
  #35 = Class              #41            // com/rootcloud/ByteCodeExample
  #36 = Utf8               SourceFile
  #37 = Utf8               ByteCodeExample.java
  #38 = NameAndType        #23:#24        // "<init>":()V
  #39 = NameAndType        #19:#20        // count:I
  #40 = NameAndType        #21:#22        // sum:D
  #41 = Utf8               com/rootcloud/ByteCodeExample
  #42 = NameAndType        #27:#28        // add:(D)D
  #43 = Class              #51            // java/lang/System
  #44 = NameAndType        #52:#53        // out:Ljava/io/PrintStream;
  #45 = Class              #54            // java/io/PrintStream
  #46 = NameAndType        #55:#56        // println:(D)V
  #47 = NameAndType        #29:#28        // sub:(D)D
  #48 = NameAndType        #30:#28        // multiply:(D)D
  #49 = NameAndType        #31:#28        // divide:(D)D
  #50 = Utf8               java/lang/Object
  #51 = Utf8               java/lang/System
  #52 = Utf8               out
  #53 = Utf8               Ljava/io/PrintStream;
  #54 = Utf8               java/io/PrintStream
  #55 = Utf8               println
  #56 = Utf8               (D)V
{
  public com.rootcloud.ByteCodeExample();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=3, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: iconst_0
         6: putfield      #2                  // Field count:I
         9: aload_0
        10: dconst_0
        11: putfield      #3                  // Field sum:D
        14: return
      LineNumberTable:
        line 4: 0
        line 6: 4
        line 7: 9

  public double add(double);
    descriptor: (D)D
    flags: ACC_PUBLIC
    Code:
      stack=5, locals=3, args_size=2
         0: aload_0
         1: dup
         2: getfield      #3                  // Field sum:D
         5: dload_1
         6: dadd
         7: putfield      #3                  // Field sum:D
        10: aload_0
        11: dup
        12: getfield      #2                  // Field count:I
        15: iconst_1
        16: iadd
        17: putfield      #2                  // Field count:I
        20: aload_0
        21: getfield      #3                  // Field sum:D
        24: dreturn
      LineNumberTable:
        line 10: 0
        line 11: 10
        line 12: 20

  public double sub(double);
    descriptor: (D)D
    flags: ACC_PUBLIC
    Code:
      stack=5, locals=3, args_size=2
         0: aload_0
         1: dup
         2: getfield      #3                  // Field sum:D
         5: dload_1
         6: dsub
         7: putfield      #3                  // Field sum:D
        10: aload_0
        11: dup
        12: getfield      #2                  // Field count:I
        15: iconst_1
        16: iadd
        17: putfield      #2                  // Field count:I
        20: aload_0
        21: getfield      #3                  // Field sum:D
        24: dreturn
      LineNumberTable:
        line 16: 0
        line 17: 10
        line 18: 20

  public double multiply(double);
    descriptor: (D)D
    flags: ACC_PUBLIC
    Code:
      stack=5, locals=3, args_size=2
         0: aload_0
         1: dup
         2: getfield      #3                  // Field sum:D
         5: dload_1
         6: dmul
         7: putfield      #3                  // Field sum:D
        10: aload_0
        11: dup
        12: getfield      #2                  // Field count:I
        15: iconst_1
        16: iadd
        17: putfield      #2                  // Field count:I
        20: aload_0
        21: getfield      #3                  // Field sum:D
        24: dreturn
      LineNumberTable:
        line 22: 0
        line 23: 10
        line 24: 20

  public double divide(double);
    descriptor: (D)D
    flags: ACC_PUBLIC
    Code:
      stack=4, locals=3, args_size=2
         0: dconst_0
         1: dload_1
         2: dcmpl
         3: ifne          11
         6: aload_0
         7: getfield      #3                  // Field sum:D
        10: dreturn
        11: aload_0
        12: getfield      #3                  // Field sum:D
        15: dload_1
        16: ddiv
        17: dreturn
      LineNumberTable:
        line 28: 0
        line 29: 6
        line 31: 11
      StackMapTable: number_of_entries = 1
        frame_type = 11 /* same */

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=5, args_size=1
         0: new           #4                  // class com/rootcloud/ByteCodeExample
         3: dup
         4: invokespecial #5                  // Method "<init>":()V
         7: astore_1
         8: dconst_0
         9: dstore_2
        10: iconst_0
        11: istore        4
        13: iload         4
        15: iconst_5
        16: if_icmpge     33
        19: aload_1
        20: iload         4
        22: i2d
        23: invokevirtual #6                  // Method add:(D)D
        26: dstore_2
        27: iinc          4, 1
        30: goto          13
        33: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
        36: dload_2
        37: invokevirtual #8                  // Method java/io/PrintStream.println:(D)V
        40: aload_1
        41: ldc2_w        #9                  // double -1.0d
        44: invokevirtual #11                 // Method sub:(D)D
        47: dstore_2
        48: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
        51: dload_2
        52: invokevirtual #8                  // Method java/io/PrintStream.println:(D)V
        55: aload_1
        56: ldc2_w        #12                 // double 2.0d
        59: invokevirtual #14                 // Method multiply:(D)D
        62: dstore_2
        63: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
        66: dload_2
        67: invokevirtual #8                  // Method java/io/PrintStream.println:(D)V
        70: aload_1
        71: ldc2_w        #15                 // double 1.5d
        74: invokevirtual #17                 // Method divide:(D)D
        77: dstore_2
        78: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
        81: dload_2
        82: invokevirtual #8                  // Method java/io/PrintStream.println:(D)V
        85: return
      LineNumberTable:
        line 35: 0
        line 36: 8
        line 37: 10
        line 38: 19
        line 37: 27
        line 40: 33
        line 41: 40
        line 42: 48
        line 43: 55
        line 44: 63
        line 45: 70
        line 46: 78
        line 47: 85
      StackMapTable: number_of_entries = 2
        frame_type = 254 /* append */
          offset_delta = 13
          locals = [ class com/rootcloud/ByteCodeExample, double, int ]
        frame_type = 250 /* chop */
          offset_delta = 19
}
SourceFile: "ByteCodeExample.java"

```

## 2. 画一张图，展示 Xmx、Xms、Xmn、Metaspace、DirectMemory、Xss 这些内存参数的关系

> ![JVM内存结构](D:\code\backend\JAVA-01\Week_01\JVM内存模型.jpg)