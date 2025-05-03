package az.developia.az.developia.info;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand; 
    private String type; 
    private String category; 
    private String description;
    private double price;
    private double rating;
    private String imageUrl;
    private String ownerId;

    
}

