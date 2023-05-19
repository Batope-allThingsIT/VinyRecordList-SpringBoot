package edu.cscc.controller;

import edu.cscc.model.Vinyl;
import edu.cscc.repository.VinylRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class VinylController {

    @Autowired
    VinylRepository vinylRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/records";
    }

    @GetMapping("/records")
        public String getAllRecords(Model model) {
        var vinyls = vinylRepository.findAll();
        model.addAttribute("vinylsList", vinyls);
        return "records";
    }

    @GetMapping("/add-record")
    public String addRecord(Model model) {
        model.addAttribute("vinyl", new Vinyl());

        var vinylsList = vinylRepository.findAll();

        //calculating the size of the list  from the database.
        var size = 0;
        for (var i : vinylsList) {
        	
            size= size + 1;
        }
        model.addAttribute("totalRecords", size + 1);
        return "add_record";
    }


    @PostMapping("/add-record")
    public String addRecord(@Valid @ModelAttribute("vinyl") Vinyl vinyl, BindingResult result) {
            if (result.hasErrors()) {
            return "add_record";
        } else {
            vinylRepository.save(vinyl);
            return "redirect:/records";
        }
    }

    
    @GetMapping("/records/{id}")
    public String getAllRecords(@PathVariable(name = "id") Integer id, Model model) {
            var vinyl = vinylRepository.findById(id);
             if (vinyl.isPresent()) {
               model.addAttribute("vinyl", vinyl.get());
               return "single_record";
        } else {
            return "redirect:/";
        }
    }
}