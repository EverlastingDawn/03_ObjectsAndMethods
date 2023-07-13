public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket(1000, 10);
        basket.add("Milk", 1, 40.0);
        basket.add("Bread", 2, 10.0);
        basket.add("Eggs", 1, 20.0);
        basket.add("Meat", 1, 80.0);
        basket.add("Potatoes", 2, 2.0);
        basket.add("Tomatoes", 1, 3.0);

        basket.print();
        System.out.println("Товаров: " + basket.makeNames());

        System.out.println("Стоимость: " + basket.getTotalPrice());

        System.out.println("Вес: " + basket.getTotalWeight());
    }
}
