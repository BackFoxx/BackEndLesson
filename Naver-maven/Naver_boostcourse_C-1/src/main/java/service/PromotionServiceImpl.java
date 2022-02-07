package service;

import dto.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PromotionRepository;

import java.util.List;
import java.util.Map;

@Service
public class PromotionServiceImpl implements PromotionService{
    private final PromotionRepository repository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Map<String, Object>> getPromotionList() {
        return repository.getPromotionList();
    }
}
