package com.example.dia11;

import java.util.List;
import java.util.Optional;

import com.example.dia11.models.Category;
import com.example.dia11.models.Product;
import com.example.dia11.services.CategoryService;
import com.example.dia11.services.ProductService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Dia11ApplicationTests {

	// Product Service
	@Autowired
	private ProductService productService;

	// Category Service
	@Autowired
	private CategoryService categoryService;

	@Test
	void contextLoads() {
	}
	
	// Product Tests
	@Test
	void findAllProducts(){
		List<Product> products = productService.findAll();

		// Products list should not be null object
		Assertions.assertNotNull(products);

		// Products list should not be empty
		Assertions.assertFalse(products.isEmpty());
	}

	@Test 
	void findProductById(){
		Long id = (long) 2;

		Product product =  productService.findById(id).get();

		// Check for each of Product attributes or compare Objects
		Assertions.assertEquals("Credit", product.getName());

	}

	@Test
	void createProduct(){
		// Create new product
		Product newProduct = new Product();
		newProduct.setName("JUnit Test");
		// Save new product to DB
		productService.create(newProduct);

		// Get products list
		List<Product> productList = productService.findAll();
		// Check last (newest) product from the list
		Product checkProduct = productList.get(productList.size()-1);

		Assertions.assertEquals("JUnit Test", checkProduct.getName());

	}

	@Test
	void updateProduct(){
		// Get product to update
		List<Product> productList = productService.findAll();
		Product productToUpdate = productList.get(productList.size()-1);
		// Make changes to the product
		productToUpdate.setName("Update Test");
		// Save modified product
		productService.update(productToUpdate.getId(), productToUpdate);

		// Check changes on the DB
		Product updatedProduct = productService.findById(productToUpdate.getId()).get();

		Assertions.assertEquals("Update Test", updatedProduct.getName());
		
	}

	@Test
	void deleteProduct(){
		// Get id of product to delete
		List<Product> productList = productService.findAll();
		Product productToDelete = productList.get(productList.size()-1);

		// Delete form DB
		productService.delete(productToDelete.getId());

		// Check product is no longer in DB
		Assertions.assertEquals(Optional.empty(), productService.findById(productToDelete.getId()));;
	}

	// Category Tests
	@Test
	void findAllCategories(){
		List<Category> categories = categoryService.findAll();

		// Categories list should not be null object
		Assertions.assertNotNull(categories);

		// Categories list should not be empty
		Assertions.assertFalse(categories.isEmpty());
	}

	@Test 
	void findCategoryById(){
		Long id = (long) 2;

		Category category =  categoryService.findById(id).get();

		// Check for each of Category attributes or compare Objects
		Assertions.assertEquals("Business", category.getName());

	}

	@Test
	void createCetegory(){
		// Create new Category
		Category newCategory = new Category();
		newCategory.setName("JUnit Test");
		// Save new category to DB
		categoryService.create(newCategory);

		// Get categories list
		List<Category> categoryList = categoryService.findAll();
		// Check last (newest) category from the list
		Category checkCategory = categoryList.get(categoryList.size()-1);

		Assertions.assertEquals("JUnit Test", checkCategory.getName());

	}

	@Test
	void updateCategory(){
		// Get category to update
		List<Category> categoryList = categoryService.findAll();
		Category categoryToUpdate = categoryList.get(categoryList.size()-1);
		// Make changes to the category
		categoryToUpdate.setName("Update Test");
		// Save modified category
		categoryService.update(categoryToUpdate.getId(), categoryToUpdate);

		// Check changes on the DB
		Category updatedCategory = categoryService.findById(categoryToUpdate.getId()).get();

		Assertions.assertEquals("Update Test", updatedCategory.getName());
		
	}

	@Test
	void deleteCategory(){
		// Get id of category to delete
		List<Category> categoryList = categoryService.findAll();
		Category categoryToDelete = categoryList.get(categoryList.size()-1);

		// Delete form DB
		categoryService.delete(categoryToDelete.getId());

		// Check category is no longer in DB
		Assertions.assertEquals(Optional.empty(), categoryService.findById(categoryToDelete.getId()));;
	}

}
