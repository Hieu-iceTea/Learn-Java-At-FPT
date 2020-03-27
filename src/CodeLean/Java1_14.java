package CodeLean;

public class Java1_14 {
    public static void main(String[] args) {
        //testAuthor();
        //testBook();
        //testLine();
        testCircleP();
    }

    private static void testAuthor(){
        Author me = new Author("Hieu_iceTea", "Hieu.iceTea@gmail.com", 'm');
        System.out.println(me);
    }

    private static void testBook () {
        Author hieu = new Author("Hieu_iceTea", "Hieu.iceTea@gmail.com", 'm');
        Book thanhXuan = new Book("Thanh Xuân Của Tôi Có Bạn", hieu, 99000, 5);

        System.out.println(thanhXuan);
    }

    private static void testLine(){
        Line line1 = new Line(1 , 2, 3, 4);
        Line line2 = new Line(new Point(5, 6), new Point(7, 8));

        System.out.println(line1);
        System.out.println(line2);

        System.out.printf("Length line1 = %.4f", line1.getLength());
    }

    private static void testCircleP() {
        CircleP circle1 = new CircleP(2, 3, 5.5);
        CircleP circle2 = new CircleP(new Point(5, 6), 8.0);

        System.out.printf("Area of circle1 is: %.4f%n", circle1.getArea());
        System.out.printf("Circumference of circle1 is: %.4f%n", circle1.getCircumference());

        System.out.printf("Distance is: %.4f%n", circle1.distance(circle2));
        System.out.printf("Distance is: %.4f%n", circle2.distance(circle1));

        System.out.printf("Distance [ circle1 <> circle1 ] is: %.4f%n", circle1.distance(circle1));
    }
}

/** A */
class Author {
    private String name;
    private String email;
    private char gender;

    Author (String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    };

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

    public String toString(){
        return String.format("%s (%c) at %s", name, gender, email);
    }
}

class Book {
    private String name;
    private Author author;
    private double price;
    private int qty;

    public Book (){
        //none
    }

    public Book (String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
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
        return String.format("'%s' by %s", this.name, author);
    }
}

/** B */
class Point {
    private int x;
    private int y;

    public Point(){
        //none
    }

    public Point(int x, int y){
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

    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public int[] getXY(){
        int[] results = new int[2];
        results[0] = this.x;
        results[1] = this.y;
        return results;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public double distance(Point anotherPoint) {
        int xDiff = this.x - anotherPoint.x;
        int yDiff = this.y - anotherPoint.y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }

    public double distance() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
}

class Line {
    Point begin;
    Point end;

    public Line(){
        //none
    }

    public Line(Point begin, Point end){
        this.begin = begin;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2){
        this.begin = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    // copy:
    public int getBeginX() {
        return begin.getX();  // Point's getX()
    }
    public void setBeginX(int x) {
        begin.setX(x);  // Point's setX()
    }
    public int getBeginY() {
        return begin.getY();  // Point's getY()
    }
    public void setBeginY(int y) {
        begin.setY(y);  // Point's setY()
    }
    public int[] getBeginXY() {
        return begin.getXY();  // Point's getXY()
    }
    public void setBeginXY(int x, int y) {
        begin.setXY(x, y);  // Point's setXY()
    }
    public int getEndX() {
        return end.getX();  // Point's getX()
    }
    public void setEndX(int x) {
        end.setX(x);  // Point's setX()
    }
    public int getEndY() {
        return end.getY();  // Point's getY()
    }
    public void setEndY(int y) {
        end.setY(y);  // Point's setY()
    }
    public int[] getEndXY() {
        return end.getXY();  // Point's getXY()
    }
    public void setEndXY(int x, int y) {
        end.setXY(x, y);  // Point's setXY()
    }
    //end copy

    public String toString() {
        return String.format("Line[begin=%s, end=%s]", begin, end);
    }

    public double getLength(){
        return begin.distance(end);
    }
}

class CircleP { //Circle use Point
    private Point center;
    private double radius;

    public CircleP(){
        //nothing
    }

    public CircleP(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    public CircleP(int xCenter, int yCenter, double radius) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getCenterX() {
        return center.getX();
    }

    public int getCenterY() {
        return center.getY();
    }

    public int[] getCenterXY() {
        return center.getXY();
    }

    public void setCenterX(int x) {
        center.setX(x);
    }

    public void setCenterY(int y) {
        center.setY(y);
    }

    public void setCenterXY(int x, int y) {
        center.setXY(x, y);
    }

    public String toString() {
        return String.format("Circle[center=%s, radius=%.4f]", center, radius);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2.0 * Math.PI * radius;
    }

    public double distance(CircleP anotherCircle) {
        return center.distance(anotherCircle.center);
    }
}