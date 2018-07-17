package tsutlovic.com.timekeeper.model;

import java.util.ArrayList;

public class Category {

    //region Field Variables

    private String name;
    private ArrayList<String> actions;
    //endregion

    //region Constructors
    public Category(String name, ArrayList<String> actions){
        this.name = name;
        this.actions = actions;
    }

    public Category(String name){
        this.name = name;
    }
    //endregion

    //region Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getActions() {
        return actions;
    }

    public void setActions(ArrayList<String> actions) {
        this.actions = actions;
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return name;
    }
    //endregion
}
