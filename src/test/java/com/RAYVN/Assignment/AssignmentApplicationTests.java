package com.RAYVN.Assignment;

import com.RAYVN.Assignment.models.Incident;
import com.RAYVN.Assignment.services.IncidentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssignmentApplicationTests {


	private final IncidentService service;

	AssignmentApplicationTests(IncidentService service) {
		this.service = service;
	}

	@Test
	void contextLoads() {
		var i = new Incident();
		i.setId("test1");
		i.setName("test1");
		service.newIncident(i);
		var i2 = new Incident();
		i2.setId("test2");
		i2.setName("test2");
		service.newIncident(i2);
		var latest = service.latest();
		var a = latest.getId() == i2.getId();
	}

}
