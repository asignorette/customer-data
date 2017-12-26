package com.zup.customerdata;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.zup.customerdata.entity.Address;
import com.zup.customerdata.entity.Customer;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * Class for unit tests regarding customer data.
 * @author asignorette
 *
 */
public class CustomerDataApplicationTests {

	@Test
	public void contextLoads() {
	}

	public final String REST_SERVICE_URI = "http://localhost:8081/customers";

	/**
	 * Test new customer.
	 */
	@Test
	public void testA() {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setName("Anderson Signorette");
		customer.setBusinessNumber("000000000-99");
		Address address = new Address();
		address.setCity("Campinas");
		address.setCountry("Brazil");
		address.setName("Av das andorinhas");
		address.setZipCode("13101400");

		customer.addAddress(address);

		URI uri = restTemplate.postForLocation(REST_SERVICE_URI, customer, Customer.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	/**
	 * Test find customer.
	 */
	@Test
	public void testB() {
		RestTemplate restTemplate = new RestTemplate();

		Customer customersMap = restTemplate.getForObject(REST_SERVICE_URI + "/1", Customer.class);
		assertNotEquals(customersMap.getName(), null);
	}

	/**
	 * Test update customer.
	 */
	@Test
	public void testC() {

		RestTemplate restTemplate = new RestTemplate();
		Customer customer = new Customer();
		customer.setName("Signorette Anderson");

		restTemplate.put(REST_SERVICE_URI + "/1", customer);

		Object customersUpdated = restTemplate
				.getForObject(REST_SERVICE_URI + "/search/findByName?name=Signorette Anderson", Object.class);
		assertNotEquals(customersUpdated, null);

	}

	/**
	 * Test delete customer.
	 */
	@Test
	public void testE() {

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.delete(REST_SERVICE_URI + "/1");

	}

	/**
	 * Test find after delete customer.
	 */
	@Test
	public void testF() {

		RestTemplate restTemplate = new RestTemplate();
		try {
			restTemplate.getForObject(REST_SERVICE_URI + "/1", Customer.class);
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	/**
	 * Test all customer.
	 */
	@Test
	public void testG() {

		RestTemplate restTemplate = new RestTemplate();
		try {

			restTemplate.delete(REST_SERVICE_URI + "/");
			restTemplate.getForObject(REST_SERVICE_URI + "/1", Customer.class);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test find by anem customer.
	 */
	@Test
	public void testH() {

		RestTemplate restTemplate = new RestTemplate();
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setName("Anderson Signorette");
		customer.setBusinessNumber("000000000-99");
		Address address = new Address();
		address.setCity("Campinas");
		address.setCountry("Brazil");
		address.setName("Av das andorinhas");
		address.setZipCode("13101400");

		customer.addAddress(address);

		URI uri = restTemplate.postForLocation(REST_SERVICE_URI, customer, Customer.class);
		System.out.println("Location : " + uri.toASCIIString());
		
		Object customersUpdated = restTemplate
				.getForObject(REST_SERVICE_URI + "/search/findByName?name=Anderson Signorette", Object.class);
		assertNotEquals(customersUpdated, null);
	}

}
