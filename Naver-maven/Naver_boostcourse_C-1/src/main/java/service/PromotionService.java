package service;

import dto.Promotion;

import java.util.List;
import java.util.Map;

public interface PromotionService {
    public List<Map<String, Object>> getPromotionList();
}
