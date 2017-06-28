package pl.edu.wat.service.interfaces;

import pl.edu.wat.dto.SimpleCategoryDto;
import pl.edu.wat.model.Category;

import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
public interface CategoryService {
    List<Category> listAllCategory();
    List<SimpleCategoryDto> findAllCategory();
}
