package me.spywhere.doclet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.gson.Gson;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;
import com.sun.tools.doclets.internal.toolkit.AbstractDoclet;
import com.sun.tools.doclets.internal.toolkit.Configuration;
import com.sun.tools.doclets.internal.toolkit.util.ClassTree;

public class Javatar extends AbstractDoclet {
	public static boolean start(RootDoc root) {
		Gson gson = new Gson();
		JavatarPackage jpkg = new JavatarPackage("Untitled");
		for(String[] option:root.options()){
			if(option[0].equalsIgnoreCase("-name")){
				jpkg.name = option[1];
			}
		}
		for(PackageDoc pkg:root.specifiedPackages()){
			jpkg.addPackage(pkg);
		}
		try{
			FileWriter fw = new FileWriter(new File(jpkg.name + ".json"));
			fw.write("// " + jpkg.name + "\n");
			fw.write("// Generated on " + new SimpleDateFormat("EEE d MMM yyyy HH:mm").format(Calendar.getInstance().getTime()) + "\n");
			fw.write(gson.toJson(jpkg));
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return true;
	}

	public static int optionLength(String option) {
		if(option.equals("-name")){ return 2; }
		return 0;
	}


	@Override
	public Configuration configuration() {
		return null;
	}

	@Override
	protected void generateProfileFiles() throws Exception {

	}

	@Override
	protected void generateClassFiles(ClassDoc[] cs, ClassTree ct) {

	}

	@Override
	protected void generatePackageFiles(ClassTree ct) throws Exception {

	}
}
