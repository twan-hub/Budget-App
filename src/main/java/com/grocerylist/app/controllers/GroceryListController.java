package com.grocerylist.app.controllers;

import com.grocerylist.app.models.GroceryList;
import com.grocerylist.app.models.GroceryListItem;
import com.grocerylist.app.models.data.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class GroceryListController {


    @Autowired
    private GroceryListRepository groceryListRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "Grocery List");
        model.addAttribute("grocerylists", groceryListRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Grocery List");
        model.addAttribute("grocerylist",new GroceryList());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid GroceryList newGroceryList,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Grocery List");
            return "add";
        }

//        Optional<Employer> optEmployer = employerRepository.findById(employerId);
//        if(optEmployer.isEmpty()){
//            return "add";
//        }else{
//            Employer employer = optEmployer.get();
//            newJob.setEmployer(employer);
//            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//            newJob.setSkills(skillObjs);
        groceryListRepository.save(newGroceryList);
        model.addAttribute("grocerylist",groceryListRepository.findAll());
//        }


        return "redirect:";
    }

    @GetMapping("view/{grocerylistId}")
    public String displayViewJob(Model model, @PathVariable int grocerylistId) {
        Optional optGroceryList = groceryListRepository.findById(grocerylistId);
        if (optGroceryList.isPresent()) {
            GroceryList groceryList = (GroceryList) optGroceryList.get();
            model.addAttribute("grocerylists", groceryList);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}


