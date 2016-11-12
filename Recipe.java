package com.example.farre.foodle;

/**
 * Created by User on 09/11/2016.
 */

public class Recipe
{
    public int Calories;
    public String Category;
    public String Directions;
    public Integer IDNumber;
    public String Img;
    public String Ingredients;
    public String Name;
    public String Rating;

    public Recipe()
    {
        //default constructor
    }

    public Recipe(int Calories, String Category, String Directions,Integer IDNumber , String Img, String Ingredients, String Name, String Rating)
    {
        this.Calories = Calories;
        this.Category = Category;
        this.Directions = Directions;
        this.IDNumber=IDNumber;
        this.Img =Img;
        this.Ingredients = Ingredients;
        this.Name = Name;
        this.Rating = Rating;
    }

    public Integer getIDNumber()
    {
        return this.IDNumber;
    }

    public String getName()
    {
        return this.Name;
    }

    public String getImg()
    {
        return this.Img;
    }

    public String getCategory()
    {
        return this.Category;
    }

    public String getDirections()
    {
        return this.Directions;
    }

    public String getIngredients()
    {
        return this.Ingredients;
    }

    public String getRating()
    {
        return this.Rating;
    }
}
