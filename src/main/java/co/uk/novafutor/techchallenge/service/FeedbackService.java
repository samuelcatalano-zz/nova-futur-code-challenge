package co.uk.novafutor.techchallenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Samuel Catalano
 * @since 20 March, 2020
 */

@Service
public class FeedbackService {

    private static final Logger LOG = LoggerFactory.getLogger(FeedbackService.class);

    private static Map<Long, Long> feebackCache = new HashMap<>();

    /**
     * Try to get the result from the cache.
     * @param number the number to calculated
     * @return cache
     */
    public Long getFromCache(final Long number) {
        if (feebackCache.containsKey(number)) {
            return feebackCache.get(number);
        } else {
            final Long feedback = this.feedback(number);
            feebackCache.put(number, feedback);
            return feedback;
        }
    }

    /**
     * Returns a feedback from any positive natural number ad infinitum.
     * @param number the number to be calculated
     * @return a feedback from any positive natural number ad infinitum
     */
    @Async("asyncExecutor")
    protected Long feedback(final long number) {
        long numberOfOperations = 0L; // 1 time
        long result = 1L; // 1 time

        for(long count = 1; count <= number; count++) { // number + 1 times
            result = result + count; // 1 time
            numberOfOperations++;
        }

        numberOfOperations = numberOfOperations + (number + 1);
        LOG.info("Operations: " + numberOfOperations);

        return result;
    }
}