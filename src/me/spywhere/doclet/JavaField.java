package me.spywhere.doclet;

import java.util.ArrayList;

import com.sun.javadoc.FieldDoc;

public class JavaField {
	String name;
	String[] type;
	ArrayList<String> tags = null;
	
	public JavaField(FieldDoc field) {
		name = field.name();
		if(!field.type().isPrimitive()){
			type = new String[] { field.type().asClassDoc().containingPackage().name(), field.type().typeName() };
		}
		if(field.isStatic()){
			if(tags == null){
				tags = new ArrayList<String>();
			}
			tags.add("java_static");
		}
		if(field.type().isPrimitive()){
			if(tags == null){
				tags = new ArrayList<String>();
			}
			tags.add("java_primitive");
		}else{
			if(field.type().asClassDoc() != null && field.type().asClassDoc().isIncluded()){
				if(tags == null){
					tags = new ArrayList<String>();
				}
				tags.add("java_default");
			}
		}
	}
	
}
