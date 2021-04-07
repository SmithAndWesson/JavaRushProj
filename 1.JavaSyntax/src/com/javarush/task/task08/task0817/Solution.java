package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            map.put("F" + i, "N" + i);
        }
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        String name = "";
        int count = 0;
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            name = pair.getValue();
            for (Map.Entry<String, String> pair1 : copy.entrySet()) {
                if(pair1.getValue().equals(name)) count++;
                if(count > 1){
                    removeItemFromMapByValue(map, name);
                    count = 0;
                }
            }
            count = 0;
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map <String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }
}
