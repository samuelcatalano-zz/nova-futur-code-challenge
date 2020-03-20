package co.uk.novafutor.techchallenge.controller;

import co.uk.novafutor.techchallenge.dto.GraphicsPointDTO;
import co.uk.novafutor.techchallenge.service.GraphicsPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Samuel Catalano
 * @since 20 March, 2020
 */

@RestController
@RequestMapping(value = "/graphics-point")
public class GraphicsPointRESTController {

    @Autowired
    private GraphicsPointService graphicsPointService;

    /**
     * Returns the dot between to vectors.
     * @param dto the object requets that contais the vectors.
     * @return the dot between to vectors
     */
    @PostMapping(value = "/dot-product")
    public ResponseEntity<?> dotProduct(@RequestBody final GraphicsPointDTO dto) {
        final Integer result = this.graphicsPointService.dotProduct(dto.getN(), dto.getVectorA(), dto.getVectorB());
        return ResponseEntity.ok("Dot product: " + result);
    }
}