package com.ayushi.membermicroservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class test the FileNotFoundException class
 * 
 *
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileNotFoundExceptionTest {

	@Mock
	private FileNotFoundException fileNotFoundException;

	@Test
	public void testOneArgConstructor() {
		FileNotFoundException exception = new FileNotFoundException("File Not Found.");
		assertEquals("File Not Found.", exception.getMessage());
	}

	@Test
	public void testNoArgConstructor() {
		FileNotFoundException exception = new FileNotFoundException();
		assertEquals(null, exception.getMessage());
	}
}
