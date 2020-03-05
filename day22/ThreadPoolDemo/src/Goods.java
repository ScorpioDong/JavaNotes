/**
 * ThreadPoolDemo - Goods
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/3 8:13 下午
 */
public class Goods {
    private double price;
    private int count;
    private String name;

    public Goods() {
    }

    public Goods(double price, int count, String name) {
        this.price = price;
        this.count = count;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
