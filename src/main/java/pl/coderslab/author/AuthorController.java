package pl.coderslab.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.category.Category;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "author/list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "author/authorAddForm";
    }

    @PostMapping("/add")
    public String save(@Valid Author author,BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("authors", authorDao.findAll());
            return "author/authorAddForm";
        }
        authorDao.saveAuthor(author);
        return "redirect:/author/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model,
                               @PathVariable Long id
    ) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "author/authorEditForm";
    }
    @PostMapping("/edit")
    public String saveEdit(Author author){
        authorDao.update(author);
        return "redirect:/author/all";
    }
    @RequestMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.deleted(author);
        return "redirect:/author/all";
    }
}
