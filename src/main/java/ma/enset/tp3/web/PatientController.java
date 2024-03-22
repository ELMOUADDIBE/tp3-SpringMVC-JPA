package ma.enset.tp3.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.tp3.entities.Patient;
import ma.enset.tp3.repository.PatientRepository;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/user/index")
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

    @GetMapping("/delete")
    public String delete(Long id,
                         @RequestParam(name ="search", defaultValue = "") String search,
                         @RequestParam(name="page", defaultValue = "0") int page,
                         @RequestParam(name="size", defaultValue = "8") int size) {
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&size="+size+"&search="+search;
    }

    @GetMapping("/admin/edit")
    public String delete(Model model, Long id,
                         @RequestParam(name ="search", defaultValue = "") String search,
                         @RequestParam(name="page", defaultValue = "0") int page) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) throw new RuntimeException("Patient not found");
        model.addAttribute("patient", patient);
        model.addAttribute("search", search);
        model.addAttribute("page", page);
        return "editPatients";

    }

    @GetMapping("/admin/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping("/admin/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(name="search", defaultValue = "") String search,
                       @RequestParam(name="page", defaultValue = "0") int page) {
        if (bindingResult.hasErrors()) {
            return "formPatients";
        }
        if (patient.getId() != 0) {
            Patient existingPatient = patientRepository.findById(patient.getId()).orElse(null);
            if (existingPatient != null) {
                existingPatient.setName(patient.getName());
                existingPatient.setDateNaissance(patient.getDateNaissance());
                existingPatient.setMalade(patient.isMalade());
                existingPatient.setScore(patient.getScore());
                patient = existingPatient;
            }
        }
        patientRepository.save(patient);
        return "redirect:/user/index?page=" + page + "&search=" + search;
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

}
