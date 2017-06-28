package pl.edu.wat.web.rest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.dto.SimpleCategoryDto;
import pl.edu.wat.service.interfaces.CategoryService;

import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
@RestController
@RequestMapping("/category")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryRestController {

    CategoryService categoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SimpleCategoryDto>> listAllCategory(){
        return ResponseEntity.ok().body(categoryService.findAllCategory());
    }

}
