package com.grocerylist.app.controllers;

import com.grocerylist.app.models.GroceryList;
import com.grocerylist.app.models.AddGroceryListForm;

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

    // private GroceryList grocerylist = new GroceryList();


    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "Grocery List");
        model.addAttribute("grocerylists", groceryListRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(@ModelAttribute GroceryList grocerylists, Model model) {
        model.addAttribute("title", "Add Grocery List");

        AddGroceryListForm form = new AddGroceryListForm();
        form.setAddItem("false");
        model.addAttribute("grocerylist", form);
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid AddGroceryListForm newGroceryList,
                                    Errors errors, Model model) {

//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Grocery List");
//            return "add";
//        }

        if (newGroceryList.getAddItem().equals("true")) {
            newGroceryList.setAddItem("false");
            newGroceryList.addItem(new GroceryListItem());
            model.addAttribute("grocerylist", newGroceryList);
            return "add";
        } else {
            groceryListRepository.save(newGroceryList.asGroceryList());
            model.addAttribute("grocerylist", groceryListRepository.findAll());

            return "redirect:";
        }


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

    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
//        model.addAttribute("title", "Delete Grocery List");
        model.addAttribute("grocerylists", groceryListRepository.findAll());
        return "delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] groceryListIds) {

        if (groceryListIds != null) {
            for (int id : groceryListIds) {
                groceryListRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("edit/{Id}")
    public String displayEditForm(Model model, @PathVariable("Id") int Id) {

        Optional optGroceryList = groceryListRepository.findById(Id);
        if (optGroceryList.isPresent()) {
            GroceryList groceryList = (GroceryList) optGroceryList.get();
            model.addAttribute("grocerylist", groceryList);
            groceryListRepository.deleteById(Id);
            return "edit";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("edit/{Id}")
    public String updateList(@PathVariable("Id") int Id, Model model, GroceryList groceryList) {
        groceryListRepository.save(groceryList);
        model.addAttribute("grocerylist", groceryListRepository.findAll());
        return "redirect:../";
    }
}

