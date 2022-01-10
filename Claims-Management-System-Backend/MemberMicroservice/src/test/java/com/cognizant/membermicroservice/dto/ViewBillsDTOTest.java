package com.ayushi.membermicroservice.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains junit test cases for the ViewBillsDTO class 
 * 
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ViewBillsDTOTest {

	@Mock
	private ViewBillsDTO viewBillsDto;

	/**
	 * To Test ViewBillsDTO is not null
	 */

	@Test
	@DisplayName("Checking whether ViewBillsDTO class is loading or not.")
	void viewBillsDTODTOIsLoadedOrNot() {
		assertThat(viewBillsDto).isNotNull();
	}

	/**
	 * To Test ViewBillsDTO constructor
	 */

	@DisplayName("Checking whether ViewBillsDTO class is responding correctly or not.")
	@Test
	void testingViewBillsDTO() throws ParseException {

		String sDate1 = "31/12/2020";
		String sDate2 = "10/01/2021";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		viewBillsDto = new ViewBillsDTO(date2, 100000.0, true, 100.0, date1);
		viewBillsDto.setPaidDate(date2);
		viewBillsDto.setDueDate(date1);
		viewBillsDto.setPremium(100000.0);
		viewBillsDto.setLatePayment(true);
		viewBillsDto.setLatePaymentCharges(100.0);

		assertEquals(100000.0, viewBillsDto.getPremium());
		assertEquals(true, viewBillsDto.isLatePayment());
		assertEquals(date2, viewBillsDto.getPaidDate());
		assertEquals(date1, viewBillsDto.getDueDate());
		assertEquals(100.0, viewBillsDto.getLatePaymentCharges());

	}
}
