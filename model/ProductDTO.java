package model;

public class ProductDTO {
    private int id;
    private int i;
    private String name;
    private String company;
    private int price;

    public ProductDTO(int i, String name, String company, int price) {
        this.i = i;
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "상품{" +
                "i=" + i +
                ", 이름='" + name + '\'' +
                ", 회사='" + company + '\'' +
                ", 가격=" + price +
                '}';
    }
}
