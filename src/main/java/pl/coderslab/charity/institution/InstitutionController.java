package pl.coderslab.charity.institution;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionServes institutionServes;
    private final ObjectMapper objectMapper;

    @GetMapping("/institution")
    public ResponseEntity <?> getAllInst() throws JsonProcessingException {
        List<InstitutionDto> institution = institutionServes.findAllInstitution();
        return ResponseEntity.ok(objectMapper.writeValueAsString(institution));
    }
}
