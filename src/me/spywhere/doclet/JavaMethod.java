package me.spywhere.doclet;

import java.util.ArrayList;

import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Parameter;

public class JavaMethod {
	String method;
	String returnType;
	ArrayList<String> args = null;
	ArrayList<String> tags = null;
	
	public JavaMethod(MethodDoc method) {
		for(AnnotationDesc anno:method.annotations()){
			if(tags == null){
				tags = new ArrayList<String>();
			}
			tags.add(anno.annotationType().name());
		}
		this.method = method.name();
		if(method.returnType().asParameterizedType() != null){
			returnType = method.returnType().asParameterizedType().typeName();
		}else if(method.returnType().asTypeVariable() != null){
			returnType = "Object";
		}else if(method.returnType().asWildcardType() != null){
			returnType = method.returnType().asWildcardType().typeName();
		}else{
			returnType = method.returnType().typeName();
		}
		if(method.isStatic()){
			if(tags == null){
				tags = new ArrayList<String>();
			}
			tags.add("java_static");
		}
		if(method.returnType().isPrimitive()){
			if(tags == null){
				tags = new ArrayList<String>();
			}
			tags.add("java_primitive");
		}else{
			if(method.returnType().asClassDoc() != null && method.returnType().asClassDoc().isIncluded()){
				if(tags == null){
					tags = new ArrayList<String>();
				}
				tags.add("java_default");
			}
		}
		
		for(Parameter param:method.parameters()){
			if(args == null){
				args = new ArrayList<String>();
			}
			args.add(param.name());
		}
	}
	
}
