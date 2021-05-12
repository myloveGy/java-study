package map;

public class Goods implements Comparable {

    private final String name;

    private final float price;

    public Goods(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{name: " + this.name+", price: " + this.price + "}";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods g = (Goods) o;
            int i = Float.compare(this.price, g.price);
            if (i == 0) {
                return this.name.compareTo(g.name);
            }

            return i;
        }

        throw new RuntimeException("传入数据存在问题");
    }
}
