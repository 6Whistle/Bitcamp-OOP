package builder;

import model.ProductDTO;

public class ProductBuilder {
    private int i;
    private String name;
    private String company;
    private int price;

    public ProductBuilder i(int i){
        this.i = i;
        return this;
    }

    public ProductBuilder name(String name){
        this.name = name;
        return this;
    }

    public ProductBuilder company(String company){
        this.company = company;
        return this;
    }
    public ProductBuilder price(int price){
        this.price = price;
        return this;
    }

    public ProductDTO build(){
        return new ProductDTO(this.i, this.name, this.company, this.price);
    }
}
