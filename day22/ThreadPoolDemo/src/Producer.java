/**
 * ThreadPoolDemo -
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/3 8:19 下午
 */
public class Producer implements Runnable {
    private final Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        synchronized (goods) {
            while (true) {
                if (goods.getCount() < 100) {
                    System.out.println("生产者生产了10件商品");
                    goods.setCount(goods.getCount() + 10);
                } else {
                    System.out.println("生产完成，开始销售。。。");
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
