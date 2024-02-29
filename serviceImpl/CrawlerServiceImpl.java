package serviceImpl;

import org.jsoup.Jsoup;
import service.CrawlerService;

import javax.swing.text.Document;
import java.io.IOException;

public class CrawlerServiceImpl implements CrawlerService {
    @Override
    public void findNamesFromWeb() throws IOException {
        Document doc = (Document) Jsoup.connect("웹데이터를 가져올 주소").get();
    }
}
