package boot.bootdemo.service.impl;

import boot.bootdemo.model.Review;
import boot.bootdemo.repository.ReviewRepository;
import boot.bootdemo.service.ReviewService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImp(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void saveAll(List<Review> comments) {
        reviewRepository.saveAll(comments);
    }
}
