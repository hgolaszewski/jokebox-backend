package pl.edu.wat.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.dto.SimpleCategoryDto;
import pl.edu.wat.dto.SimpleCategoryInputDto;
import pl.edu.wat.domain.Category;
import pl.edu.wat.repository.CategoryRepository;
import pl.edu.wat.service.interfaces.CategoryService;
import pl.edu.wat.web.rest.errors.NoSuchCategoryException;

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
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Category addCategory(SimpleCategoryInputDto simpleCategoryInputDto) {
        Category category = categoryRepository.findOneByName(simpleCategoryInputDto.getName()).orElse(null);
        if (category != null){
            throw new IllegalArgumentException();
        }
        category = new Category(simpleCategoryInputDto.getName(),
                simpleCategoryInputDto.getRequestparam(),
                simpleCategoryInputDto.getAddress());
        category = categoryRepository.save(category);
        return category;
    }

    @Override
    public Category deleteCategory(int id) {
        Category category = categoryRepository.findOne(id);
        if (category == null){
            throw new NoSuchCategoryException();
        }
        categoryRepository.delete(id);
        return category;
    }
}
