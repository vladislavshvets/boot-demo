package boot.bootdemo.service;

import boot.bootdemo.model.Review;
import java.util.List;

public interface ReviewService {
    void saveAll(List<Review> entities);
}
