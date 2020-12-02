package boot.bootdemo.service;

import boot.bootdemo.model.Word;
import java.util.List;

public interface WordService {
    void add(Word word);

    List<Word> addAll(List<Word> dtoList);

    Word get(Long id);

    List<Word> getAll();

    List<Word> findMostUsedWords(int quantity);
}
