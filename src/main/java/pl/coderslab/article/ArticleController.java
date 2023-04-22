package pl.coderslab.article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.category.CategoryDao;

import javax.validation.Valid;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }
    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "article/list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        Article article = new Article();
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("articl  e", article);
        return "article/articleAddForm";
    }

    @PostMapping("/add")
    public String save(@Valid Article article, BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("categories", categoryDao.findAll());
            model.addAttribute("authors", authorDao.findAll());
            return "article/articleAddForm";
        }
        articleDao.saveArticle(article);
        return "redirect:/article/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteArticle(@PathVariable long id) {
        Article article = articleDao.findById(id);
        articleDao.deleted(article);
        return "redirect:/article/all";
    }
    @GetMapping("/edit/{id}")
    public String showArticleForm(Model model,
                               @PathVariable Long id
    ) {
        Article article = articleDao.findById(id);
        model.addAttribute("article", article);
        return "article/articleEditForm";
    }
    @PostMapping("/edit")
    public String saveEdit(Article article){
        articleDao.update(article);
        return "redirect:/article/all";
    }
}

