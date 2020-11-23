package boot.bootdemo.model.mapper;

import boot.bootdemo.model.Review;
import boot.bootdemo.model.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review map(ReviewDto reviewDto) {
        Review review = new Review();
        review.setHelpfulnessNumerator(Long.valueOf(reviewDto.getHelpfulnessNumerator()));
        review.setHelpfulnessDenominator(Long.valueOf(reviewDto.getHelpfulnessDenominator()));
        review.setScore(Long.valueOf(reviewDto.getScore()));
        review.setTime(reviewDto.getTime());
        review.setSummary(reviewDto.getSummary());
        review.setText(reviewDto.getText());
        return review;
    }
}
