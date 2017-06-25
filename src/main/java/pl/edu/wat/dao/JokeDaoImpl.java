package pl.edu.wat.dao;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wat.dao.interfaces.JokeDao;
import pl.edu.wat.model.Joke;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
@Repository
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JokeDaoImpl implements JokeDao {

    EntityManager entityManager;

    @Override
    public void addJoke(Joke joke) {
        entityManager.persist(joke);
    }

    @Override
    public List<Joke> listJokeByCategory(String category) {
        return entityManager.createQuery("Select j from Joke j join Category c on j.category = c where c.requestparam = '" + category +"'", Joke.class).getResultList();
    }

    @Override
    public void cleanJokes() {
        entityManager.createQuery("Delete from Joke").executeUpdate();
    }

}
