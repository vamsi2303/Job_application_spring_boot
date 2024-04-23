package com.vamsi.FirstJob.review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);

    Review GetReviewById(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review review);
}
