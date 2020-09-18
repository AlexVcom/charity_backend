package pl.coderslab.charity.category;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public List<CategoryDto> findAllCategory(){
        return categoryRepository.findAll()
                .stream()
                .map(i -> modelMapper.map(i, CategoryDto.class ))
                .collect(Collectors.toList());
    }

}
