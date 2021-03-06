package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionDto {

    private Long id;
    private String name;
    private String description;
}
