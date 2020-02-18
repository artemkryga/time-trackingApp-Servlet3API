package ua.kryha.timetrack.service;

import ua.kryha.timetrack.dao.CategoryDao;
import ua.kryha.timetrack.model.Category;

import java.util.List;

public class CategoryService {

    private CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> getAllCategory() {
        return categoryDao.findAll();
    }


}
