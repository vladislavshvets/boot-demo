package boot.bootdemo.model.mapper;

import boot.bootdemo.model.Word;
import boot.bootdemo.model.dto.WordResponseDto;
import org.springframework.stereotype.Component;

@Component
public class WordMapper {
    public WordResponseDto mapWordToResponseDto(Word word) {
        return WordResponseDto.builder()
                .word(word.getWord())
                .amount(word.getAmount())
                .build();
    }
}
