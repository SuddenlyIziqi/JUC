package ThreadSafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *  HashSet   unSafe
 */
public class HashSetSafe {
    public static void main(String[] args) {
//        simpleSet();
//        copyOnWriteArraySet();




    }
    /**
     * 直接运行
     * 结果 ：" java.util.ConcurrentModificationException
     */
    public static void simpleSet(){
        Set set = new HashSet();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println("set = " + set);
            },"Thread-"+i).start();
        }
    }

    /**
     * 解决方法
     * 1. CopyOnWriteArraySet
     */
    public static void copyOnWriteArraySet(){
        CopyOnWriteArraySet<Object> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                copyOnWriteArraySet.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println("copyOnWriteArraySet = " + copyOnWriteArraySet);
            },"Thread-"+i).start();
        }
    }
}
