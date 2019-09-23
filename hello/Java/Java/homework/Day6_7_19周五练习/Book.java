package Day6_7_19周五练习;

public class Book {
    String BookName;
    double Price;
    private int number;

    public int getNumber() {
        return number;
    }

    public String getBookName() {
        return BookName;
    }

    public double getPrice() {
        return Price;
    }

    public Book(String BookName,double Price,int number){
        this.BookName = BookName;
        this.Price = Price;
        this.number = number;
    }
}
