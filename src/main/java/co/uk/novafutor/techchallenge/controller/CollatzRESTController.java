package co.uk.novafutor.techchallenge.controller;

import co.uk.novafutor.techchallenge.service.CollatzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Samuel Catalano
 * @since 20 March, 2020
 */

@RestController
@RequestMapping(value = "/collatz")
public class CollatzRESTController {

    @Autowired
    private CollatzService collatzService;

    /**
     * Returns the iterative version of collatz conjecture.
     * @param number the number to be inferred
     * @return the iterative version of collatz conjecture
     */
    @GetMapping(value = "/iterative")
    public ResponseEntity<?> collatzIterative(@RequestParam(value = "number", required = true) final Integer number) {
        final String result = this.collatzService.collatzIterative(number);
        return ResponseEntity.ok(result);
    }

    /**
     * Returns the recursive version of collatz conjecture.
     * @param number the number to be inferred
     * @return the recursive version of collatz conjecture
     */
    @GetMapping(value = "/recursive")
    public ResponseEntity<?> collatzRecursive(@RequestParam(value = "number", required = true) final Integer number) {
        final String result = this.collatzService.collatzRecursive(number);
        return ResponseEntity.ok(result);
    }
}