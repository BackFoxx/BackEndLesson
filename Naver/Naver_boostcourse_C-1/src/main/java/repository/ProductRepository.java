package repository;

import dto.*;

import java.util.List;

public interface ProductRepository {
    public List<Product> getProductsList(int categoryId, int start);
    public int getTotalCount(int categoryId);

    public double getAverageScore(int displayInfoId);
    public List<Comments> getComments(int displayInfoId);
    public DisplayInfo getDisplayInfo(int displayInfoId);
    public DisplayInfoImage getDisplayInfoImage(int displayInfoId);
    public List<ProductImages> getProductImages(int displayInfoId);
    public List<ProductPrices> getProductPrices(int displayInfoId);
}
