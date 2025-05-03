package az.developia.az.developia.Servicee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.az.developia.info.ClothingItem;
import az.developia.az.developia.repository.ClothingItemRepository;

@Service
public class ClothingItemService {

    @Autowired
    private ClothingItemRepository repository;

    public List<ClothingItem> getAllItems() {
        return repository.findAll();
    }

    public ClothingItem getItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ClothingItem addItem(ClothingItem item) {
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public ClothingItem updateItem(Long id, ClothingItem updatedItem) {
        ClothingItem item = repository.findById(id).orElse(null);
        if (item != null) {
            item.setBrand(updatedItem.getBrand());
            item.setType(updatedItem.getType());
            item.setCategory(updatedItem.getCategory());
            item.setDescription(updatedItem.getDescription());
            item.setPrice(updatedItem.getPrice());
            item.setRating(updatedItem.getRating());
            item.setImageUrl(updatedItem.getImageUrl());
            item.setOwnerId(updatedItem.getOwnerId());
            return repository.save(item);
        }
        return null;
    }
}
