package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {
    public static long sizeFiles = 0;
    public static int countFiles, countDirectories = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileParh = reader.readLine();
        Path path = Paths.get(fileParh);

        if(!Files.isDirectory(path)){
            System.out.format("%s - не папка%n", fileParh);
            return;
        }

        Files.walkFileTree(path, new Vivsitor());

        System.out.format("Всего папок - %s%n",countDirectories - 1);
        System.out.format("Всего файлов - %s%n",countFiles);
        System.out.format("Общий размер - %s%n",sizeFiles);

    }

    public static class Vivsitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            countDirectories += 1;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            countFiles +=1;
            sizeFiles += attrs.size();
            return FileVisitResult.CONTINUE;
        }
    }
}
