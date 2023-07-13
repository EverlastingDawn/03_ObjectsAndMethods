import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<String> names = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private List<Double> prices = new ArrayList<>();
    private double maxWeight;
    private double totalWeight = 0;
    private double totalPrice = 0;
    private int count;
    private int maxAmount;

    public Basket(int maxWeight, int maxAmount) {
        this();
        this.maxWeight = maxWeight;
        this.maxAmount = maxAmount;
        setLimits();
    }

    public Basket() {
        setLimits();
    }

    public int add(String name, int quantity, double price) {
        if (contains(name) || quantity >= maxAmount) {
            return -1;
        }

        if (price <= 0) {
            return -2;
        }

        if (weightLimitReached()) {
            return -3;
        }

        names.add(name);
        quantities.add(quantity);
        prices.add(price);
        totalWeight += quantity;
        if (totalWeight > maxWeight) {
            if (quantity > maxWeight - totalWeight) {
                quantity = 0;
            }
        }

        totalPrice += quantity * price;

        return count++;
    }

    private boolean contains(String name) {
        return names.contains(name);
    }

    private boolean weightLimitReached() {
        return totalWeight >= maxWeight;
    }

    public List<String> makeNames() {
        return names;
    }

    public List<Integer> makeQuantities() {
        return quantities;
    }

    public List<Double> makePrices() {
        return prices;
    }

    public int getCount() {
        return count;
    }

    public double getTotalPrice() {
        return Math.round(totalPrice);
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void print() {
        System.out.println("База товаров: " + names.stream().collect(Collectors.joining()));
    }

    private void setLimits() {
        maxWeight = Math.min(maxWeight, 1000);

        maxAmount = 10;
        count = 0;
        totalPrice = 0;
        totalWeight = 0;
        names = new ArrayList<>();
        quantities = new ArrayList<>();
        prices = new ArrayList<>();
    }

    static class Product {
        private String name;
        private int quantity;
        private double price;

        public Product(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public long compareTo(Product product) {
            return Double.compare(price, product.price);
        }
    }
}


