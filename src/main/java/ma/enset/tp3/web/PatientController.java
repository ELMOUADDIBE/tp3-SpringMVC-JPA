package ma.enset.tp3.web;

import lombok.AllArgsConstructor;
import ma.enset.tp3.entities.Patient;
import ma.enset.tp3.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page", defaultValue = "0") int page,
                        @RequestParam(name="size", defaultValue = "8") int size,
                        @RequestParam(name="search", defaultValue = "") String name) {
        Page<Patient> patientPage = patientRepository.findByNameContains(name, PageRequest.of(page, size));
        model.addAttribute("patients", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("name", name);
        return "patients";
    }
        @GetMapping("/")
        public String home() {
            return "redirect:/index";
        }

}
