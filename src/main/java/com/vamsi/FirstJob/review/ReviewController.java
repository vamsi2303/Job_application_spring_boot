package com.vamsi.FirstJob.review;

import com.vamsi.FirstJob.company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReviews(@PathVariable Long companyId,@RequestBody Review review)
    {
        boolean isReviewed = reviewService.addReview(companyId, review);
        if(isReviewed) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review isn't added", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> GetReviewById(@PathVariable Long companyId,@PathVariable Long reviewId)
    {
        return new ResponseEntity<>(reviewService.GetReviewById(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review)
    {
        boolean isupdated = reviewService.updateReview(companyId, reviewId, review);
        if(isupdated)
        {
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Unable to update the review", HttpStatus.NOT_FOUND);

    }

}
