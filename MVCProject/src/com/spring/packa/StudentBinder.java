package com.spring.packa;

import java.beans.PropertyEditorSupport;

public class StudentBinder extends PropertyEditorSupport {

	@Override
	public void setAsText(String name)
	{
		if(name.contains("MR.") || name.contains("MS."))
		{
			setValue(name);
		}
		else
		{
			name = "Ms."+name;
			setValue(name);
		}
	}
	
}
