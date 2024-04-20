package com.vamsi.FirstJob.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
}
