package boot.bootdemo.controller;

import java.util.List;
import java.util.stream.Collectors;

import boot.bootdemo.model.dto.WordResponseDto;
import boot.bootdemo.model.mapper.WordMapper;
import boot.bootdemo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class ReviewController {
    private static final String PAGE_SIZE = "1000";
    private final WordService wordService;
    private final WordMapper mapper;

    @Autowired
    public ReviewController(WordService wordService,
                            WordMapper mapper) {
        this.wordService = wordService;
        this.mapper = mapper;
    }

    @GetMapping("/most-used-words")
    public List<WordResponseDto> getMostUsedWords(
            @RequestParam(defaultValue = PAGE_SIZE) int quantity) {
        return wordService.findMostUsedWords(quantity).stream()
                .map(mapper::mapWordToResponseDto)
                .collect(Collectors.toList());
    }
}
