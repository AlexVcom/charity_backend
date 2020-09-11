package pl.coderslab.charity.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRegistrationDto {

    private Long id;
    private String name;
}
