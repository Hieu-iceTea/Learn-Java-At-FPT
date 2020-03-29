package CodeLean;

public class Java1_15 {
    public static void main(String[] args) {
        //testBookV2();
        //testInvoice();
        //testAccountV2();
    }

    private static void testBookV2() {
        AuthorV2 author1 = new AuthorV2("Hieu_iceTea", "Hieu.iceTea@gmail.com", 'm');
        AuthorV2 author2 = new AuthorV2("Dang Kim Thi", "ThiDK@gmail.com", 'f');
        System.out.println(author2);

        AuthorV2[] authors = {author1, author2};

        BookV2 book1 = new BookV2("Thanh Xuan Cua Toi", authors, 999000, 25);
        System.out.println(book1);
        System.out.println("Author Name of book1 is: " + book1.getAuthorNames());;

        BookV2 book2 = new BookV2("Tu Hoc JAVA", new AuthorV2[] {author1, author2}, 150000);
        System.out.println(book2);
    }

    private static void testInvoice() {
        Customer customer1 = new Customer(96, "Nguyen Dinh Hieu", 500000);
        Invoice invoice1 = new Invoice(15, customer1, 900000);

        System.out.println(customer1);
        System.out.println(invoice1.getCustomerName() + ": " + invoice1.getAmountAfterDiscount() + " vnd");
    }

    private static void testAccountV2() {
        Customer customer = new Customer(96, "Nguyễn Đình Hiếu", 'm');
        AccountV2 account = new AccountV2(123, customer, 99000000);

        System.out.println(account);

        account.deposit(500000);
        System.out.println(account);

        account.withdraw(100000);
        System.out.println(account);
    }
}

class AuthorV2 { //https://www.codelean.vn/2020/02/jp04-luyen-tap-oop-composition.html
    private String name;
    private String email;
    private char gender;

    public AuthorV2(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("Author[name=%s, email=%s, gender=%c]", name, email, gender);
    }
}

class BookV2 {
    private String name;
    private AuthorV2[] authors;
    private double price;
    private int qty;

    public BookV2(String name, AuthorV2[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public BookV2(String name, AuthorV2[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public AuthorV2[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        String AuthorNames = "";

        /*for (AuthorV2 author : authors) {
            AuthorNames += author + ", ";
        }*/

        for (int i = 0; i < authors.length; i++){
            AuthorNames += authors[i];
            if (i != authors.length-1){
                AuthorNames += ", ";
            }
        }

        return String.format("Book[name=%s, author={%s}, price=%s, qty=%s]", name, AuthorNames, price, qty);
    }

    public String getAuthorNames() {
        String result = "";

        /*for (AuthorV2 author : authors) {
            result += author.getName() + ", ";
        }*/

        for (int i = 0; i < authors.length; i++){
            result += authors[i].getName();
            if (i != authors.length-1){
                result += ", ";
            }
        }

        return result;
    }
}

/**
class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        //nothing
    }

    public MyPoint(int x, int y) {
        this.setXY(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        return new int[] {x, y};
    }

    public void setXY (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%s,%s)", x, y);
    }

    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public double distance(MyPoint anotherPoint) {
        int xDiff = this.x - anotherPoint.x;
        int yDiff = this.y - anotherPoint.y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }

    public double distance() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
}
*/

class Customer {
    private int ID;
    private String name;
    private int discount;
    private char gender; //CustomerAccount

    public Customer(int ID, String name, int discount) {
        this.ID = ID;
        this.name = name;
        this.discount = discount;
    }

    public Customer(int ID, String name, char gender) { //CustomerAccount
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }

    public char getGender() { //CustomerAccount
        return gender;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String toString() {
        return String.format("%s(%s)", name, ID);
    }
}

class Invoice {
    private int ID;
    private Customer customer;
    private double amount;

    public Invoice(int ID, Customer customer, double amount) {
        this.ID = ID;
        this.customer = customer;
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    /**public double getAmount() {
        return amount;
    }*/

    public String getAmount() {
        return String.format("%.4f" ,amount);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public double getAmountAfterDiscount() {
        return amount - customer.getDiscount();
    }
}

class AccountV2 {
    private int ID;
    private Customer customer;
    private double balance;

    public AccountV2(int ID, Customer customer, double balance) {
        this.ID = ID;
        this.customer = customer;
        this.balance = balance;
    }

    public AccountV2(int ID, Customer customer) {
        this.ID = ID;
        this.customer = customer;
    }

    public int getID() {
        return ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        return String.format("%s balance=$%.2f", customer, balance);
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public AccountV2 deposit(double amount) {
        this.balance += amount;
        return this;
    }

    public AccountV2 withdraw(double amount) {
        if (this.balance > amount){
            this.balance -= amount;
        } else {
            System.out.println("amount withdraw exceeds the current balance!");
        }
        return this;
    }
}