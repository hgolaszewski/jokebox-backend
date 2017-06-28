package pl.edu.wat.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.dto.SimpleCategoryDto;
import pl.edu.wat.model.Category;
import pl.edu.wat.repository.CategoryRepository;
import pl.edu.wat.service.interfaces.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hubert on 25.06.2017.
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public List<Category> listAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<SimpleCategoryDto> findAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> new SimpleCategoryDto(category))
                .collect(Collectors.toList());
    }
}
