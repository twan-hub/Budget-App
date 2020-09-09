package com.grocerylist.app.controllers;

import com.grocerylist.app.models.GroceryList;
import com.grocerylist.app.models.GroceryListItem;
import com.grocerylist.app.models.data.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    private GroceryListRepository groceryListRepository;

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
//        model.addAttribute("title", "Add Grocery List");
//
//        neGr.addItem(new GroceryListItem());
//        model.addAttribute("grocerylist",neGr);
        return "/item/add";
    }

    @PostMapping("add")
    public String JobForm(Model model) {
//        model.addAttribute("title", "REDIRECTING. . .");
//        GroceryList neGr= new GroceryList();
//        neGr.addItem(new GroceryListItem());
//        model.addAttribute("grocerylist",neGr);
//        model.addAttribute("title", "Add Skill");
        return "redirect:/add";
    }

}
