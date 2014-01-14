package me.spywhere.doclet;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;

public class JavaPackage {
	@SerializedName("default")
	boolean defaultPackage = false;
	@SerializedName("class")
	ArrayList<JavaClass> classes = null;
	@SerializedName("interface")
	ArrayList<JavaClass> interfaces = null;
	@SerializedName("enum")
	ArrayList<JavaClass> enums = null;
	ArrayList<JavaClass> error = null;
	ArrayList<JavaClass> annotation = null;
	ArrayList<JavaClass> exception = null;
	
	public JavaPackage(PackageDoc pkg) {
		defaultPackage = pkg.isIncluded();
		for(ClassDoc cls:pkg.allClasses()){
			if(cls.isPrivate()){
				continue;
			}
			if(cls.isClass()){
				if(classes == null){
					classes = new ArrayList<JavaClass>();
				}
				classes.add(new JavaClass(cls));
			}else if(cls.isInterface()){
				if(interfaces == null){
					interfaces = new ArrayList<JavaClass>();
				}
				interfaces.add(new JavaClass(cls));
			}else if(cls.isEnum()){
				if(enums == null){
					enums = new ArrayList<JavaClass>();
				}
				enums.add(new JavaClass(cls));
			}else if(cls.isError()){
				if(error == null){
					error = new ArrayList<JavaClass>();
				}
				error.add(new JavaClass(cls));
			}else if(cls.isAnnotationType()){
				if(annotation == null){
					annotation = new ArrayList<JavaClass>();
				}
				annotation.add(new JavaClass(cls));
			}else if(cls.isException()){
				if(exception == null){
					exception = new ArrayList<JavaClass>();
				}
				exception.add(new JavaClass(cls));
			}
		}
	}
}
