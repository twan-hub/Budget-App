package com.grocerylist.app.models;

import com.grocerylist.app.models.GroceryList;

import java.util.ArrayList;

// This is a change made in sandbox.

/**
 * Created by LaunchCode
 */
public class GroceryListData {


    /**
     * Returns the results of searching the Jobs data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Job field that should be searched.
     * @param value Value of the field to search for.
     * @param allList The list of jobs to search.
     * @return List of all jobs matching the criteria.
     */
    public static ArrayList<GroceryList> findByColumnAndValue(String column, String value, Iterable<GroceryList> allList) {

        ArrayList<GroceryList> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<GroceryList>) allList;
        }

        if (column.equals("all")){
            results = findByValue(value, allList);
            return results;
        }
        for (GroceryList groceryList : allList) {

            String aValue = getFieldValue(groceryList, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(groceryList);
            }
        }

        return results;
    }

    public static String getFieldValue(GroceryList groceryList, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = groceryList.getName();
        } else if (fieldName.equals("location")){
            theValue = groceryList.getLocation().toString();
        } else if (fieldName.equals("category")){
            theValue = groceryList.getCategory().toString();
        }else {
            theValue = groceryList.getItem().toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allList The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<GroceryList> findByValue(String value, Iterable<GroceryList> allList) {
        String lower_val = value.toLowerCase();

        ArrayList<GroceryList> results = new ArrayList<>();

        for (GroceryList groceryList : allList) {

            if (groceryList.getName().toLowerCase().contains(lower_val)) {
                results.add(groceryList);
            } else if (groceryList.getLocation().toString().toLowerCase().contains(lower_val)) {
                results.add(groceryList);
            } else if (groceryList.getCategory().toString().toLowerCase().contains(lower_val)) {
                results.add(groceryList);
            } else if (groceryList.getItem().toString().toLowerCase().contains(lower_val)) {
            results.add(groceryList);
            } else if (groceryList.toString().toLowerCase().contains(lower_val)) {
                results.add(groceryList);
            }

        }

        return results;
    }


}


