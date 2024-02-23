package view;

import builder.ProductBuilder;
import model.ProductDTO;
import service.UtilService;
import serviceImpl.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductView {

    private static List<ProductDTO> products;

    public static void main(String[] args) {
        List<ProductDTO> products = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();
        for(int i = 0; i < 5; i++)
            products.add(new ProductBuilder()
                    .i(util.createRandomInt(0, 10))
                    .name(util.createRandomName())
                    .company(util.createRandomCompany())
                    .price(util.createRandomInt(1000, 9000)).build());

        products.forEach(i -> System.out.println(i.toString()));
    }
}
