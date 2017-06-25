package pl.edu.wat.dao.interfaces;

import pl.edu.wat.model.Category;

import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
public interface CategoryDao {
    List<Category> listAllCategory();
}
