package com.example.new_one;

//used for setting and getting row data of each items in listfragment    ( imageview and TextView ).
public class RowItem {

	///add more variable if you have more fields
	/// set and get those fields
	private String title;
	private int icon;
	
	public RowItem(int icon,String title)
	{
		this.title=title;
		this.icon=icon;
		
	}
	public void setTitle(String Title)
	{
		this.title=Title;
	}
	public void setIcon(int Icon)
	{
		this.icon=Icon;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	public int getIcon()
	{
		return this.icon;			
	}
	
	

}
