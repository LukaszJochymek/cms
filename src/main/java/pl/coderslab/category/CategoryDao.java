package pl.coderslab.category;

import org.springframework.stereotype.Repository;
import pl.coderslab.article.Article;
import pl.coderslab.author.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<Category> findAll(){
        Query select = entityManager.createQuery("SELECT c FROM Category c ");
        return select.getResultList();
    }
    public void saveCategory(Category category) {
        entityManager.persist(category);
    }
    public void deleted(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }
    public void update(Category category) {

        entityManager.merge(category);
    }
    public Category finfByid(long id) {
        return entityManager.find(Category.class, id);
    }
}
