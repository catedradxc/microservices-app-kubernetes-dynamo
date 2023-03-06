package com.ewolff.microservice.customer.web;

import javax.servlet.http.HttpServletRequest;

import com.ewolff.microservice.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ewolff.microservice.customer.Customer;

@Controller
public class CustomerController {

	private CustomerRepository customerRepo;

	@Autowired
	public CustomerController( CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}

	@RequestMapping(value = "/{id}.html", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView customer(@PathVariable("id") String id) {
		return new ModelAndView("customer", "customer",
				customerRepo.findById(id).get());
	}

	@RequestMapping("/list.html")
	public ModelAndView customerList() {
		return new ModelAndView("customerlist", "customers",
				customerRepo.findAll());
	}

	@RequestMapping("/checkpost")
	public ModelAndView checkpost() {

		customerRepo.save(new Customer("c","Eberhard", "Wolff",
				"eberhard.wolff@gmail.com", "Unter den Linden", "Berlin"));

		return new ModelAndView("customerlist", "customers",
				customerRepo.findAll());
	}

	@RequestMapping(value = "/form.html", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("customer", "customer", new Customer());
	}

	@RequestMapping(value = "/form.html", method = RequestMethod.POST)
	public ModelAndView post(Customer customer, HttpServletRequest httpRequest) {
		customer = customerRepo.save(customer);
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/{id}.html", method = RequestMethod.POST)
	public ModelAndView put(@PathVariable("id") String id, Customer customer,
			HttpServletRequest httpRequest) {
		customer.setId(id);
		customerRepo.save(customer);
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/{id}.delete", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("id") String id) {
		customerRepo.deleteById(id);
		return new ModelAndView("success");
	}

}
