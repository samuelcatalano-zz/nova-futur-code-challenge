package co.uk.novafutor.techchallenge.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Samuel Catalano
 * @since 20 March, 2020
 */

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CollatzService {

    private StringBuilder builder = new StringBuilder();

    /**
     * Iterative version.
     * @param n the number
     */
    public String collatzIterative(int n) {
        String result = "";
        while (n != 1) {
            builder.append(n + " ");

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 1 + (3 * n);
            }
        }

        builder.append(n);
        result = builder.toString();

        return result;
    }

    /**
     * Recursive version.
     * @param n the number
     * @return
     */
    public String collatzRecursive(int n) {
        String result = "";
        if (n == 1)
            result = builder.toString() + " 1";
        else
            if (n % 2 == 0) {
                builder.append(" " + n);
                return collatzRecursive(n / 2);
            } else {
                builder.append(" " + n);
                return collatzRecursive(1 + (3 * n));
            }

        return result;
    }
}