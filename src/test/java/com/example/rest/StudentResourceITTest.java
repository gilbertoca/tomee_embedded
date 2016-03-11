package com.example.rest;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static net.javacrumbs.jsonunit.JsonAssert.when;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.COMPARING_ONLY_STRUCTURE;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.javacrumbs.jsonunit.core.Option;

@RunWith(Arquillian.class)
public class StudentResourceITTest {
	
	private static final Client client = ClientBuilder.newClient();

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "testtomee.war")
				 .addPackages(true, "com.example")
				 .addAsWebInfResource("beans.xml")
				 .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				 .addAsResource("test.properties")
				 .addAsResource("base.properties");
		webArchive.as(ZipExporter.class).exportTo(new File("/home/ravi/hello.war"), true);
		return webArchive;
	}
	
	@ArquillianResource
	private URI baseUrl;
	
	/*@Test
	public void test_add_student() {
		String response = client.target("http://localhost:8080/api/student")
		.request()
		.post(Entity.entity("{\"name\":\"Hello\"}", MediaType.APPLICATION_JSON), String.class);
	}*/
	
	@Test
	public void test_find_student_by_id() {
		String response = client.target(baseUrl.toString()+"api/student/{id}")
								.resolveTemplate("id", 1)
								.request()
								.get(String.class);
		String expected = readFile("student1.json");
		assertJsonEquals(expected, response, when(Option.COMPARING_ONLY_STRUCTURE));
	}
	
	public String readFile(String fileName)  {
		try {
			return new String(Files.readAllBytes(Paths.get("src/test/resources/"+fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
