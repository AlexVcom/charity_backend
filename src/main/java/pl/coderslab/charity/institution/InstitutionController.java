package pl.coderslab.charity.institution;

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
public class InstitutionController {

    private final InstitutionService institutionServes;

    @CrossOrigin
    @GetMapping("/institution")
    public ResponseEntity<List<InstitutionDto>> getAllInst() {
        List<InstitutionDto> institution = institutionServes.findAllInstitution();
        return ResponseEntity.ok(institution);
    }
}
