package boot.bootdemo.service.impl;

import boot.bootdemo.model.Word;
import boot.bootdemo.repository.WordRepository;
import boot.bootdemo.service.WordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public void add(Word word) {
        wordRepository.save(word);
    }

    @Override
    public List<Word> addAll(List<Word> words) {
        return wordRepository.saveAll(words);
    }

    @Override
    public Word get(Long id) {
        return wordRepository.getOne((long) id.intValue());
    }

    @Override
    public List<Word> getAll() {
        return wordRepository.findAll();
    }

    @Override
    public List<Word> findMostUsedWords(int quantity) {
        return wordRepository.findAllByOrderByAmountDesc(PageRequest.of(0, quantity));
    }
}
