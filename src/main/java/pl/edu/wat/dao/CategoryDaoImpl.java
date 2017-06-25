package pl.edu.wat.dao;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wat.dao.interfaces.CategoryDao;
import pl.edu.wat.model.Category;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
@Repository
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryDaoImpl implements CategoryDao {

    EntityManager entityManager;

    @Override
    public List<Category> listAllCategory() {
        return entityManager.createQuery("From Category", Category.class).getResultList();
    }

}
