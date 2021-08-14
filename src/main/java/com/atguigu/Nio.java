package com.atguigu;

import java.nio.ByteBuffer;

/**
 * capacity
 * position
 * limit
 * mark
 */
public class Nio {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(20);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("----");

        //向缓冲区填从数据
        buffer.put("hello".getBytes());

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("----");

        //该方法会将limit设为当前缓冲区数据的结束索引，并将position设为0-------用于buffer的读取
        buffer.flip();

        System.out.println(buffer.position()); //0
        System.out.println(buffer.limit());//5
        System.out.println(buffer.capacity());//20
        System.out.println("----");

        byte by[] = new byte[5];
        buffer.get(by);
        System.out.println(new String(by));
        System.out.println("----");

        System.out.println("--update-1--");



    }
}
