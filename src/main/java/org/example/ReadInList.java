package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadInList {
    public List<String> readFromFile() {

        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new ArrayList<>();
        try (RandomAccessFile file =
                     new RandomAccessFile("C:\\Users\\djura\\Downloads\\Telegram Desktop\\task1\\tasktext.txt", "rw");
             FileChannel channel = file.getChannel()) {


            ByteBuffer buffer = ByteBuffer.allocate(1000000);
            stringBuilder = new StringBuilder();
            int byteRead = channel.read(buffer);

            while (byteRead > 0) {
                System.out.println("Read " + byteRead);
                buffer.flip();

                while (buffer.hasRemaining()) {
                    stringBuilder.append((char) buffer.get());
                }
                buffer.clear();
                byteRead = channel.read(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        result = Arrays.stream(stringBuilder.toString().split("\r\n")).skip(1).toList();

        if (result.isEmpty()) {
            System.out.println("There is no data in given file...");
        }

        return result;
    }
}
