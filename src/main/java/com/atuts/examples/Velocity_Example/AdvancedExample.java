package com.atuts.examples.Velocity_Example;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class AdvancedExample {
	private VelocityContext velocityContext;
	private Template template;
	
	public AdvancedExample() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		
		template = velocityEngine.getTemplate("template/vacancies.vm");
	}
	
	public void generateExample(List<Map<String,String>> list){
		velocityContext = new VelocityContext();
		velocityContext.put("vacancies", list);
		
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		
		System.out.println(stringWriter.toString());
	}
	
	public static void main(String[] args) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("position", "Software Engineer");
		map.put("salary", "120000.00");
		
		list.add(map);
		
		Map<String, String> map1 = new HashMap<String,String>();
		map1.put("position", "UI Engineer");
		map1.put("salary", "12000.00");
		
		list.add(map1);
		
		new AdvancedExample().generateExample(list);
	}
}
