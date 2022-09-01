package ru.netology.MoneyTransferService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.netology.MoneyTransferService.transaction.Amount;
import ru.netology.MoneyTransferService.transaction.TransferPost;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class MoneyTransferServiceIntegrationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Container
	private static final GenericContainer<?> app = new GenericContainer<>("backend:1.0")
			.withExposedPorts(5500);


	@Test
	public void successTransferPostTest() {
		var transfer = new TransferPost("9876543212346789", "07/23", "444", "2345678912345678", new Amount(10L, "RUR"));
		var entity = testRestTemplate.postForEntity("http://localhost:" + app.getMappedPort(5500) + "/transfer", transfer, String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}


	@Test
	public void WrongSumTransferPostTest()  {
		var transfer = new TransferPost("9876543212346789", "07/23", "444", "2345678912345678", new Amount(10000000L, "RUR"));
		var entity = testRestTemplate.postForEntity("http://localhost:" + app.getMappedPort(5500) + "/transfer", transfer, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
	}
}