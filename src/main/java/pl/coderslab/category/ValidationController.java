package pl.coderslab.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.article.Article;
import pl.coderslab.author.Author;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")

    public String checkBook(Model model) {

        Category category = new Category();
        Author author = new Author();
        Article article = new Article();

        Set<ConstraintViolation<Category>> constraintViolationsCategory = validator.validate(category);
        Set<ConstraintViolation<Author>> constraintViolationsAuthor = validator.validate(author);
        Set<ConstraintViolation<Article>> constraintViolationsArticle = validator.validate(article);
        if (constraintViolationsCategory.isEmpty()) {
            return "ok";
        } else {
            model.addAttribute("validationsCategory", constraintViolationsCategory);

        }
        if (constraintViolationsAuthor.isEmpty()) {
            return "ok";
        } else {
            model.addAttribute("validateAuthor",constraintViolationsAuthor);


        }if (constraintViolationsArticle.isEmpty()) {
            return "ok";
        } else {
            model.addAttribute("validateArticle",constraintViolationsArticle);

        }
        return "validate/validate";

    }
}
