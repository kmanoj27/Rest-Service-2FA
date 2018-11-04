package com.services.controller;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.services.listener.OnRegistrationCompleteEvent;
import com.services.model.AddResponse;
import com.services.model.EmployeeDtls;
import com.services.model.UserDto;
import com.services.service.EmployeeDetailsService;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RestController
public class EmployeeDetailsController {

	@Autowired
	@Qualifier("EmployeeDetailsService")
	private EmployeeDetailsService employeeDetailsService;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	@RequestMapping(value = "/getEmployeeDtls", method = { RequestMethod.GET })
	public EmployeeDtls getEmployeeDtls(
			@RequestParam(value = "employeeId") String employeeId) throws Exception {
		System.out.println("Request : employeeId : " + employeeId);
		EmployeeDtls employeeDtls = employeeDetailsService.getEmployeeDtls(employeeId);
		return employeeDtls;
	}
	
	@RequestMapping(value = "/updateEmployeeDtls", method = { RequestMethod.PUT })
	public EmployeeDtls updateEmployeeDtls(
			@RequestParam(value = "employeeId") String employeeId) throws Exception {
		System.out.println("Request : employeeId : " + employeeId);
		EmployeeDtls employeeDtls = employeeDetailsService.updateEmployeeDtls(employeeId);
		return employeeDtls;
	}
	
	@RequestMapping(value = "/addNumbers", method = { RequestMethod.PUT })
	public AddResponse addNumbers(
			@RequestParam(value = "intA") int intA,
			@RequestParam(value = "intB") int intB) throws Exception {
		System.out.println("Request : intA : " + intA);
		System.out.println("Request : intB : " + intB);
		AddResponse addResponse = employeeDetailsService.addNumbers(intA,intB);
		Gson gsonBuilder = new GsonBuilder().create();
		UserDto userDto = new UserDto();
		userDto.setEmail("xxx@xxx.com");
		userDto.setFirstName("Test");
		userDto.setLastName("Mail");
		String jsonFromPojo = gsonBuilder.toJson(userDto);
		System.out.println("Request : jsonFromPojo : " + jsonFromPojo);
		
		return addResponse;
	}
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String registerUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {
		System.out.println("Registering user account with information: {}");
		Gson gsonBuilder = new GsonBuilder().create();
		String jsonFromPojo = gsonBuilder.toJson(accountDto);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent("n081194", request.getLocale(), getAppUrl(request)));
        return "success";
	}
	
	private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
	
	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration(final HttpServletRequest request, final Model model, @RequestParam("token") final String token) 
    		throws UnsupportedEncodingException {
        Locale locale = request.getLocale();
        System.out.println("User registered::::");
        return "Successfully acknowledged::" + locale.getLanguage();
    }
}
