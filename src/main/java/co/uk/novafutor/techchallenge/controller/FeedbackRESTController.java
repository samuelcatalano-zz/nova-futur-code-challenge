package co.uk.novafutor.techchallenge.controller;

import co.uk.novafutor.techchallenge.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/feedback")
public class FeedbackRESTController {

    @Autowired
    private FeedbackService feedbackService;

    /**
     * Returns the iterative version of collatz conjecture.
     * @param number the number to be inferred
     * @return the iterative version of collatz conjecture
     */
    @GetMapping(value = "")
    public ResponseEntity<?> feedback(@RequestParam(value = "number", required = true) final long number) {
        final Long result = feedbackService.getFromCache(number);
        return ResponseEntity.ok(result);
    }
}