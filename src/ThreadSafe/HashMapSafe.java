package ThreadSafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapSafe {
    public static void main(String[] args) {
//        hashMap();
        synchronizedMap();
//        concurrentHashMap();
    }


    /**
     * 直接用 HashMap
     */
    public static void hashMap(){
        Map hashMap = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                hashMap.put(key,UUID.randomUUID().toString().substring(0,8));
                System.out.println("hashMap = " + hashMap);
            },"Thread-"+i).start();
        }
    }

    /**
     * 解决方法 ：
     * ConcurrentHashMap   推荐
     */
    public static void concurrentHashMap(){
        Map concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                concurrentHashMap.put(key,UUID.randomUUID().toString().substring(0,8));
                System.out.println("hashMap = " + concurrentHashMap);
            },"Thread-"+i).start();
        }
    }
    /**
     * 解决方法 ：
     * ConcurrentHashMap
     */
    public static void synchronizedMap(){
        Map synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                synchronizedMap.put(key,UUID.randomUUID().toString().substring(0,8));
                System.out.println("hashMap = " + synchronizedMap);
            },"Thread-"+i).start();
        }
    }
}
