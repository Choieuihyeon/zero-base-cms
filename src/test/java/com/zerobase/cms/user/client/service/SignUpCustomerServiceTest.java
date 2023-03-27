package com.zerobase.cms.user.client.service;


import com.zerobase.cms.user.UserApiApplication;
import com.zerobase.cms.user.domain.SignUpForm;
import com.zerobase.cms.user.domain.model.Customer;
import com.zerobase.cms.user.user.client.service.SignUpCustomerService;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@WebAppConfiguration
@SpringBootTest
class SignUpCustomerServiceTest {

	@Autowired
	private SignUpCustomerService service;

	@Test
	void signUp() {
		SignUpForm form = SignUpForm.builder()
			.name("name")
			.birth(LocalDate.now())
			.email("abc@gmail.com")
			.password("1")
			.phone("0100000000")
			.build();

		Customer c = service.signUp(form);
		Assert.notNull(c.getId());
		Assert.notNull(c.getCreatedAt());

	}
}