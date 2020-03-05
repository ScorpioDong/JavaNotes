import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池和线程通信练习
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/3 8:09 下午
 */
public class Demo {
    public static void main(String[] args) {
        Goods goods = new Goods(2.5, 100, "iphone12 Pro Max Plus");
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Producer(goods));
        service.submit(new Customer(goods));
    }
}
