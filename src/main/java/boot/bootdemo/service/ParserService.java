package boot.bootdemo.service;

public interface ParserService<T> {
    T parseLine(String line);
}
