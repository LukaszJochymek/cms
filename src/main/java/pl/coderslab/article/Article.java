package pl.coderslab.article;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=200)
    @NotEmpty
    private String title;
    @ManyToOne
    private Author author;
    @ManyToMany
    @Size(min=1)
    private List<Category> categories;
    @NotEmpty
    @Size(min=500)
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }


}
