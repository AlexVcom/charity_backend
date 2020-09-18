package pl.coderslab.charity.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @CrossOrigin
    @GetMapping("/category")
    public ResponseEntity <List<CategoryDto>> getAllCategory()  {
        List<CategoryDto> category = categoryService.findAllCategory();
        return ResponseEntity.ok(category);
    }
}
