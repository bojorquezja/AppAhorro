package com.portafolio.appahorro.controller;

import com.portafolio.appahorro.entity.Operation;
import com.portafolio.appahorro.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("operation")
public class OperationController {
    @Autowired
    private OperationRepository operationRepository;

    @GetMapping
    public String operaciones(Model model){
        model.addAttribute("list", operationRepository.findAll());
        return "operation/operationlist";
    }
    @GetMapping("/{id}")
    public String operacion(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0){
            model.addAttribute("operation", operationRepository.findById(id).orElse(new Operation()));
        }else{
            model.addAttribute("operation", new Operation());
        }
        return "operation/operation";
    }
    @PostMapping
    public String operacionSave(Operation operation, Model model){
        operationRepository.save(operation);
        return "redirect:/operation";
    }
    /*
    @GetMapping("/del/{id}")
    public String operacionDelete(@PathVariable("id") Long id, Model model){
        operationRepository.deleteById(id);
        return "redirect:/operation";
    }
    */
    @DeleteMapping("/{id}")
    public String operacionDelete(@PathVariable("id") Long id, Model model){
        operationRepository.deleteById(id);
        return "redirect:/operation";
    }
}
