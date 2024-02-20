package org.example.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int publicationYear;
    private int stock;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "publisher_id") // publisher da id olarak tuttuğumuz için referencedColumnName yazmaya gerek kalmadı
private Publisher publisher;
@ManyToMany
@JoinTable(
        name= "book_category",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
)
private List<Category> categorieList;
@OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE) // kitap silindiğinde, ödünç almadakikitabı da sil
private List<BookBorrowing> bookBorrowing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<BookBorrowing> getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(List<BookBorrowing> bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }

    public List<Category> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Category> categorieList) {
        this.categorieList = categorieList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                ", author=" + author +
                ", publisher=" + publisher +
                ", categorieList=" + categorieList +
            //    ", bookBorrowing=" + bookBorrowing +
                '}';
    }
}
