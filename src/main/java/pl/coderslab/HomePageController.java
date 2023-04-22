package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.article.ArticleDao;

@Controller
public class HomePageController {
    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("article", articleDao.home());
        return "article/home";
    }
}
