package pl.coderslab.author;

import org.springframework.stereotype.Repository;
import pl.coderslab.article.Article;
import pl.coderslab.category.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<Author> findAll(){
        Query select = entityManager.createQuery("SELECT a FROM Author a ");
        return select.getResultList();
    }
    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }
    public void deleted(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }
    public void update(Author author) {

        entityManager.merge(author);
    }
    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }
}
