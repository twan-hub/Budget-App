package com.grocerylist.app.controllers;

import com.grocerylist.app.models.GroceryList;
import com.grocerylist.app.models.GroceryListData;
import com.grocerylist.app.models.data.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;

@Controller
@RequestMapping("search")
public class SearchController {


    @Autowired
    private GroceryListRepository groceryListRepository;

    static HashMap<String, String> columnChoices = new HashMap<String,String>();

    static {
        columnChoices.put("all","All");
        columnChoices.put("location", "Location");
        columnChoices.put("name", "Name");
        columnChoices.put("category", "Category");
    }



    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<GroceryList> jobs;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            jobs = groceryListRepository.findAll();
        } else {
            jobs = GroceryListData.findByColumnAndValue(searchType, searchTerm, groceryListRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Grocery List with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("grocerylists", jobs);

        return "search";
    }
}
