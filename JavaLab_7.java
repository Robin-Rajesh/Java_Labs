import java.util.*;

// Customer class to manage customer details
class Customer {
    private String id;
    private String name;
    private int loyaltyPoints;

    public Customer(String id, String name, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}

// Product class to manage product details
class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// Order class to manage order placement
class Order {
    private String id;
    private String customerId;
    private Date deliveryDate;

    public Order(String id, String customerId, Date deliveryDate) {
        this.id = id;
        this.customerId = customerId;
        this.deliveryDate = deliveryDate;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}

// Comparator for sorting products by price
class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

// Comparator for sorting customers by loyalty points
class CustomerLoyaltyComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c2.getLoyaltyPoints(), c1.getLoyaltyPoints());
    }
}

public class Main {
    public static void main(String[] args) {
        // Data structures
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<Order> orderList = new ArrayList<>();

        HashMap<String, Customer> customerMap = new HashMap<>();
        HashMap<String, Product> productMap = new HashMap<>();

        HashSet<Product> uniqueProducts = new HashSet<>();

        // Add some data
        Customer c1 = new Customer("C001", "Alice", 120);
        Customer c2 = new Customer("C002", "Bob", 200);
        customerList.add(c1);
        customerList.add(c2);

        customerMap.put(c1.getId(), c1);
        customerMap.put(c2.getId(), c2);

        Product p1 = new Product("P001", "Laptop", 1500.00);
        Product p2 = new Product("P002", "Mouse", 25.00);
        productList.add(p1);
        productList.add(p2);

        productMap.put(p1.getId(), p1);
        productMap.put(p2.getId(), p2);

        uniqueProducts.add(p1);
        uniqueProducts.add(p2);

        Order o1 = new Order("O001", "C001", new Date());
        orderList.add(o1);

        // TreeSet with custom sorting
        TreeSet<Product> sortedProductsByPrice = new TreeSet<>(new ProductPriceComparator());
        sortedProductsByPrice.addAll(productList);

        TreeSet<Customer> sortedCustomersByLoyalty = new TreeSet<>(new CustomerLoyaltyComparator());
        sortedCustomersByLoyalty.addAll(customerList);

        // Display sorted data
        System.out.println("Products sorted by price:");
        for (Product product : sortedProductsByPrice) {
            System.out.println(product);
        }

        System.out.println("\nCustomers sorted by loyalty points:");
        for (Customer customer : sortedCustomersByLoyalty) {
            System.out.println(customer);
        }
    }
}

