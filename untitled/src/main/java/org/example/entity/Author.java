package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String country;
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> bookList; // kitap listesinin olduğu yerde cascadetype verdik, yani yazarı sildiğinde kitabı da sil dedik, aksi halde yazara bağlı kitap olduğundan yazar silinmeyecekti

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", country='" + country + '\'' +
               // ", bookList=" + bookList +
                '}';
    }
}
