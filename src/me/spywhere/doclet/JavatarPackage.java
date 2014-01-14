package me.spywhere.doclet;

import java.util.HashMap;

import com.sun.javadoc.PackageDoc;

public class JavatarPackage {
	String name;
	HashMap<String, JavaPackage> packages = new HashMap<String, JavaPackage>();
	
	public JavatarPackage(String name) {
		this.name = name;
	}
	
	public void addPackage(PackageDoc pkg) {
		packages.put(pkg.name(), new JavaPackage(pkg));
	}
}
