package az.developia.az.developia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.az.developia.info.ClothingItem;

public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
    List<ClothingItem> findByBrand(String brand);
    List<ClothingItem> findByCategory(String category);
    List<ClothingItem> findByType(String type);
}
