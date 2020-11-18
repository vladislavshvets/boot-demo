package boot.bootdemo.service;

import boot.bootdemo.exception.FileReadException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CsvReaderServiceImpl implements CsvReaderService {
    @Override
    public List<String> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new FileReadException("File at the path " + filePath + " not found.", e);
        } catch (IOException e) {
            throw new FileReadException("Couldn't read data from " + filePath, e);
        }
    }
}
