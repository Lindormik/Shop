package ShopOnline.services;
import ShopOnline.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryServiceTest {

    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        categoryService = new CategoryService();
    }

    @Test
    public void givenGenerateCategoriesMethod_whenCalled_thenCategoryListShouldNotBeEmpty() {
        // Given

        // When
        List<Category> categoryList = categoryService.generateCategories();

        // Then
        Assertions.assertNotNull(categoryList);
        Assertions.assertFalse(categoryList.isEmpty());
    }

    @Test
    public void givenAddCategoryMethod_whenNewCategoryAdded_thenCategoryListSizeShouldIncrease() {
        // Given
        int initialSize = categoryService.getAllCategories().size();
        String categoryName = "TestCategory";

        // When
        categoryService.addCategory(categoryName);

        // Then
        int finalSize = categoryService.getAllCategories().size();
        Assertions.assertEquals(initialSize + 1, finalSize);
    }

    @Test
    public void givenShowOneCategoryMethod_whenExistingCategoryShown_thenOutputContainsCorrectCategory() {
        // Given
        Category testCategory = new Category("TestCategory");
        categoryService.addCategory(testCategory.getName());

        // When

        // Then

    }

    @Test
    public void givenShowOneCategoryMethod_whenNonExistingCategoryShown_thenOutputContainsErrorMessage() {
        // Given
        int nonExistingCategoryId = 999;

        // When

        // Then
    }

    @Test
    public void givenFindOrCreateCategoryMethod_whenCategoryFound_thenCorrectCategoryShouldBeReturned() {
        // Given
        Category testCategory = new Category("TestCategory");
        categoryService.addCategory(testCategory.getName());

        // When
        Category foundCategory = categoryService.findOrCreateCategory("TestCategory");

        // Then
        assertThat(testCategory).isEqualTo(foundCategory);
    }
}