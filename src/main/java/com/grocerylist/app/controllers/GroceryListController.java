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
import java.util.Optional;

@Controller
public class GroceryListController {

    @Autowired
    private GroceryListRepository groceryListRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "New Grocery List");
        model.addAttribute("grocerylists",groceryListRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddGroceryListForm(Model model) {
        model.addAttribute("title", "New Grocery List");
//        GroceryList testlist=new GroceryList();
//        GroceryListItem list= new GroceryListItem("Food",5);
        model.addAttribute( new GroceryList());
        return "add";
    }

    @PostMapping("add")
    public String processAddGroceryListForm(@ModelAttribute @Valid GroceryList newGroceryList,
                                            Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "New Grocery List");
            return "add";
        }
        groceryListRepository.save(newGroceryList);
        model.addAttribute("grocerylists",groceryListRepository.findAll());

        return "redirect:";
    }

    @GetMapping("view/{grocerylist{Id}")
    public String displayViewGroceryList(Model model, @PathVariable int groceryListId) {

        Optional optGroceryList = groceryListRepository.findById(groceryListId);
        if (optGroceryList.isPresent()) {
            GroceryList groceryList = (GroceryList) optGroceryList.get();
            model.addAttribute("grocerylists", groceryList);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}


