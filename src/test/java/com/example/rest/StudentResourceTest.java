package com.example.rest;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static net.javacrumbs.jsonunit.JsonAssert.when;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.COMPARING_ONLY_STRUCTURE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import net.javacrumbs.jsonunit.core.Option;

/*@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentResourceTest {
	
	private static final Client client = ClientBuilder.newClient();

	@Test
	public void test_add_student() {
		String response = client.target("http://localhost:8080/api/student")
		.request()
		.post(Entity.entity("{\"name\":\"Hello\"}", MediaType.APPLICATION_JSON), String.class);
	}
	
	@Test
	public void test_find_student_by_id() {
		String response = client.target("http://localhost:8080/api/student/{id}")
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
}*/
