package view;


import builder.BoardBuilder;
import model.BoardDTO;
import service.UtilService;
import serviceImpl.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BoardView {
    public static void main(String[] args) {
        List<BoardDTO> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();
        for(int i = 0; i < 5; i++)
            articles.add(new BoardBuilder()
                    .writer(util.createRandomName())
                    .title(util.createRandomTitle())
                    .content(util.createRandomContent())
                    .build());

        articles.forEach(i -> System.out.println(i.toString()));
    }
}
