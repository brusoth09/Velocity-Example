package com.atuts.examples.Velocity_Example;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * Hello world!
 *
 */
public class SimpleExample {
	private VelocityContext velocityContext;
	private Template template;
	
	SimpleExample() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		
		template = velocityEngine.getTemplate("template/sample.vm");
	}

	public void generateMessage(String name) {
		velocityContext = new VelocityContext();
		velocityContext.put("name", name);
		
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		
		System.out.println(stringWriter.toString());
	}
	
	public static void main(String[] args) {
		new SimpleExample().generateMessage("Brusoth");
	}
}
