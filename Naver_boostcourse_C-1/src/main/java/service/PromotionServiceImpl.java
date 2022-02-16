package service;

import dto.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.PromotionRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService{
    private final PromotionRepository repository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public HashMap<String, Object> getPromotions() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("items", repository.getPromotionList());
        return map;
    }
}
