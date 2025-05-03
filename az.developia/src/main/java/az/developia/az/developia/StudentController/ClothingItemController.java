package az.developia.az.developia.StudentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.az.developia.Servicee.ClothingItemService;
import az.developia.az.developia.info.ClothingItem;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/clothes")
public class ClothingItemController {

    @Autowired
    private ClothingItemService service;

    @GetMapping
    public List<ClothingItem> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public ClothingItem getItem(@PathVariable Long id) {
        return service.getItemById(id);
    }

    @PostMapping
    public ClothingItem addItem(@RequestBody ClothingItem item) {
        return service.addItem(item);
    }

    @PutMapping("/{id}")
    public ClothingItem updateItem(@PathVariable Long id, @RequestBody ClothingItem item) {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }
}
