package net.elbakay.hospital.web;

import lombok.AllArgsConstructor;
import net.elbakay.hospital.entities.Patient;
import net.elbakay.hospital.repository.PatientRepository;
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
    public String index(Model model , @RequestParam(name="page" , defaultValue = "0") int page
        , @RequestParam(name="size" , defaultValue = "4")int size
         ,@RequestParam(name="keyword" , defaultValue = "") String kw){
   // Page<Patient> pagePatient = patientRepository.findAll(PageRequest.of(page,size /*saisi dans l'url*/));
    Page<Patient> pagePatient = patientRepository.findByNomContains(kw,PageRequest.of(page,size));
    model.addAttribute("ListPatients" , pagePatient.getContent());
    model.addAttribute("pages" , new int[pagePatient.getTotalPages()]);
    model.addAttribute("currentPage", page);
    model.addAttribute("keyword",kw);
        return "patients";  // un vue creer dans templates
    }
    @GetMapping("/delete")
    public String delete(Long id , String keyword , int page){
    patientRepository.deleteById(id);
    return "redirect:/index?page="+page+"&keyword="+keyword;
    }

}
