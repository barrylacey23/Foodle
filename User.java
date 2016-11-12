package com.example.farre.foodle;
import android.support.annotation.NonNull;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Goat on 31/10/2016.
 */

public class User {

    public String Name;
    public String email;
    public List<Integer> Liked_Recipes = new ArrayList<Integer>();
    public List<Integer> Disliked_Recipes = new ArrayList<Integer>();

    public User()
    {
        //default constructor
    }
    //user will enter this information at login
    public User(String name, String email) {
        this.Name = name;
        this.email = email;
    }

    public void Like_recipe(int i)
    {
        Liked_Recipes.add(i);
    }

    public void Dislike_recipe(int i)
    {
        Disliked_Recipes.add(i);
    }

    public String getName()
    {
        return this.Name;
    }

    public String getEmail()
    {
        return this.email;
    }
}
