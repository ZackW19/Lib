public class Book {
    private String name;
    private String author;
    private int pages;
    private int produceYear;
    private int rentStatus;  //1 - wypożyczona, 0 - wolna

    public Book(String name, String author, int pages, int produceYear, int rentStatus) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.produceYear = produceYear;
        this.rentStatus = rentStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(int produceYear) {
        this.produceYear = produceYear;
    }

    public int getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(int rentStatus) {
        this.rentStatus = rentStatus;
    }


    @Override
    public String toString() {
        return name + ":" + author + ":" + pages + ":" + produceYear + ":" + rentStatus;
    }
}
