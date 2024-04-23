package com.vamsi.FirstJob.review.impl;

import com.vamsi.FirstJob.company.Company;
import com.vamsi.FirstJob.company.CompanyRepository;
import com.vamsi.FirstJob.company.CompanyService;
import com.vamsi.FirstJob.review.Review;
import com.vamsi.FirstJob.review.ReviewRepository;
import com.vamsi.FirstJob.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService{


    private final CompanyService companyService;
    private final ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService= companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company=companyService.getCompanyById(companyId);
        if(company !=null)
        {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;

    }

    @Override
    public Review GetReviewById(Long companyId, Long reviewId) {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
         return reviews.stream()
                    .filter(review -> review.getId().equals(reviewId))
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedreview) {
            if(companyService.getCompanyById(companyId)!=null) {
                if (reviewRepository.findById(reviewId).isPresent()) {
                    updatedreview.setCompany(companyService.getCompanyById(companyId));
                    updatedreview.setId(reviewId);
                    reviewRepository.save(updatedreview);
                    return true;
                }
                return false;
            }
            return false;
    }


}
