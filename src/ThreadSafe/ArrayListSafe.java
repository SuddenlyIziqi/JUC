package ThreadSafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  ArrayLIst 线程不安全
 *  解决方法
 *  1. Vector
 *  2. Collections
 *  3. CopyOnWriteArratList  推荐
 */
public class ArrayListSafe {
    public static void main(String[] args) {

//        vector();
//        synchronizedList();
        copyOnWriteArrayList();

    }



    /**
     * 直接运行 ArrayLIst 线程不安全
     * 异常：java.util.ConcurrentModificationException
     */
    public static void arrayList(){

        List list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println("set = " + list);
            },"Thread-"+i).start();
        }
    }

    /**
     * 解决办法 1
     * Vector
     */

    public static void vector(){

        List list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println("set = " + list);
            },"Thread-"+i).start();
        }
    }

    /**
     * 解决办法 2
     * Collections.synchronizedList()
     */

    public static void synchronizedList(){

        List synchronizedList = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                synchronizedList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println("set = " + synchronizedList);
            },"Thread-"+i).start();
        }
    }

    public static void copyOnWriteArrayList(){

        List copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                copyOnWriteArrayList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println("set = " + copyOnWriteArrayList);
            },"Thread-"+i).start();
        }
    }
}
