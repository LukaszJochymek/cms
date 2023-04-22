package pl.coderslab.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorDao;


public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String source) {
        return categoryDao.finfByid(Integer.parseInt(source));
    }
}