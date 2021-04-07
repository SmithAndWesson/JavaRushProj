package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        T result = null;
        ObjectMapper objectMapper = new ObjectMapper();
//        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
//
//        String str =  "";
//
//        while (fileReader.ready()){
//            str+= fileReader.readLine();
//        }
//
//        StringReader stringReader = new StringReader(str);
//        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new FileReader(fileName), clazz);
    }

    public static void main(String[] args) {

    }
}
