package service;

import java.io.IOException;
import java.util.List;

public interface CrawlerService {
    List<?> findNamesFromWeb() throws IOException;
}
