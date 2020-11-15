package boot.bootdemo.service;

import java.util.List;

public interface CsvReaderService {
    List<String> read(String filePath);
}
