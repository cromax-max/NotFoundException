package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductsRepositoryTest {
    ProductsRepository repo = new ProductsRepository();
    Product book = new Book(101, "Java", 800, "Horstmann");
    Product phone = new Smartphone(122, "P50", 1000, "Orange");

    @BeforeEach
    void setup() {
        repo.save(book);
        repo.save(phone);
    }

    @Test
    void shouldRemoveById() {
        repo.removeById(101);
        Product[] expected = {phone};
        assertArrayEquals(expected, repo.findAll());
    }

    @Test
    void shouldThrowNotFoundException() {
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(102);
        });
    }
}