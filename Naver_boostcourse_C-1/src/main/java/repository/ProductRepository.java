package repository;

import dto.Comment;
import dto.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getProductsList(int categoryId, int start);
    public int getTotalCount(int categoryId);

    public double getAverageScore(int displayInfoId);
    public List<Comment> getComment(int displayInfoId);
}
