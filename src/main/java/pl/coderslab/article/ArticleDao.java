package pl.coderslab.article;

import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Article> findAll() {
        Query select = entityManager.createQuery("SELECT a FROM Article a ");
        return select.getResultList();
    }
//    public  findALlByAuthor(Category category){
//        Query select = entityManager.createQuery("SELECT a FROM Article a  join FETCH a.categories   WHERE :category member of a.categories");
//    }

    public void saveArticle(Article article) {
        entityManager.persist(article);
    }

    public void deleted(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public void update(Article article) {
        entityManager.merge(article);
    }


    public List<Article> home() {
        Query select = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC   ");
        select.setMaxResults(5);
        return select.getResultList();
    }
    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }
}


