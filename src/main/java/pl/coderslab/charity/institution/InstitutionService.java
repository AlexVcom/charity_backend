package pl.coderslab.charity.institution;


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
public class InstitutionService {

    private final InstitutionRepository institutionRepo;
    private final ModelMapper modelMapper;


    public List<InstitutionDto> findAllInstitution (){
        List<InstitutionDto> institutionDtoList = institutionRepo.findAll()
                .stream()
                .map(i -> modelMapper.map(i, InstitutionDto.class ))
                .collect(Collectors.toList());
        return institutionDtoList;
    }


}
