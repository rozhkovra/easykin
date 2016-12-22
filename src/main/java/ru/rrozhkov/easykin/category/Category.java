package ru.rrozhkov.easykin.category;

public class Category implements ICategory{
	private int id;
	private String name;       

    public Category (int id, String name) {
        this.id = id;
    	this.name = name;
    }
    
    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
        return this.name;
    }
}