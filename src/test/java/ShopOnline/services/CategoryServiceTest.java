package ShopOnline.services;

import ShopOnline.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryServiceTest {
    CategoryService categoryService = new CategoryService();
    private ByteArrayOutputStream outputStream;

    @Test
    public void addCategoryTest() {
        // Given

        String categoryTest = "Chemia";

        // When
        categoryService.addCategory(categoryTest);

        // Then
        List<Category> categories = CategoryService.categories;
        boolean categoryExists = categories.stream().anyMatch(category -> category.getName().equals(categoryTest));
        assertTrue(categoryExists);

    }

}