package com.example.utils;


import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author wc
 * @date 2023/2/20 9:54
 * desc   Stay hungry, stay foolish
 **/
public class FileTest {

    @Test
    public void testCreatFiles() throws IOException {
        String fileName="D:\\data\\test\\newFils.txt";
        Path path = Paths.get(fileName);
        // 使用newBufferedWriter创建文件并写文件
        // 这里使用了try-with-resources方法来关闭流，不用手动关闭
        try(
        BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){
            writer.write("Hello word --创建文件");
        }
        //追加写模式
//        try(Files.newBufferedWriter())
    }
}
