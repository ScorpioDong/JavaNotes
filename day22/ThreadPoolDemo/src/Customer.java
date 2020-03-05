/**
 * ThreadPoolDemo - Customer
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/3 8:18 下午
 */
public class Customer implements Runnable{
    private final Goods goods;

    public Customer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        synchronized (goods) {
            while (true) {
                if (goods.getCount() > 0) {
                    System.out.println("消费者购买了一件商品");
                    goods.setCount(goods.getCount() - 1);
                } else {
                    System.out.println("商品已售空");
                    goods.notify();
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
