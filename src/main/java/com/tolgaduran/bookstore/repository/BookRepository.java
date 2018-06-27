package com.tolgaduran.bookstore.repository;

import com.tolgaduran.bookstore.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookRepository {
    @PersistenceContext(unitName = "bookStorePU")
    private EntityManager em;

    public Book find(Long id) {
        return em.find(Book.class, id);
    }

    public Book create(Book book) {
        em.persist(book);
        return book;
    }

    public void delete(Long id) {
        em.remove(em.getReference(Book.class, id));
    }

    public List<Book> findAll(){
        TypedQuery<Book> query=em.createQuery("select b from Book b order by b.title",Book.class);
        return query.getResultList();
    }
}
