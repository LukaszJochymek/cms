package pl.coderslab.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {

        Category category = categoryDao.finfByid(id);
        categoryDao.deleted(category);
        return "redirect:/category/all";
    }
    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "category/list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/categoryAddForm";
    }

    @PostMapping("/add")
    public String save(@Valid Category category,BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("categories", categoryDao.findAll());
            return "category/categoryAddForm";
        }
        categoryDao.saveCategory(category);
        return "redirect:/category/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model,
                               @PathVariable Long id
    ) {
        Category category = categoryDao.finfByid(id);
        model.addAttribute("category", category);
        return "category/categoryEditForm";
    }
    @PostMapping("/edit")
    public String saveEdit(Category category){
        categoryDao.update(category);
        return "redirect:/category/all";
    }

}
