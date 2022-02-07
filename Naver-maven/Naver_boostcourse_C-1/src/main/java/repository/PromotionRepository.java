package repository;

import dto.Promotion;

import java.util.List;
import java.util.Map;

public interface PromotionRepository {
    public List<Map<String, Object>> getPromotionList();
}
