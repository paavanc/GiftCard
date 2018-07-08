package com.giftcard.price;



import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.giftcard.price.manager.impl.GiftCardManagerImpl;

@RunWith(MockitoJUnitRunner.class)
public class PriceApplicationTests {

	ClassLoader classLoader = getClass().getClassLoader();
	
	private static final String FILE = "prices.txt";
	private static final int INPUT_ONE = 2500;
	private static final int INPUT_TWO = 2300;
	private static final int INPUT_THREE = 10000;
	private static final int INPUT_FOUR = 1100;

	private static final String RESULT_ONE = "Candy Bar 500, Earmuffs 2000";
	private static final String RESULT_TWO = "Paperback Book 700, Headphones 1400";
	private static final String RESULT_THREE = "Earmuffs 2000, Bluetooth Stereo 6000";
	private static final String RESULT_FOUR = "Not possible";


	@InjectMocks
	private GiftCardManagerImpl giftCardManager;

	@Test
	public void testExact() throws IOException {
		assertEquals(RESULT_ONE, giftCardManager.findPair(classLoader.getResourceAsStream(FILE), INPUT_ONE));
	}
	@Test
	public void testApproximateOne() throws IOException {
		assertEquals(RESULT_TWO, giftCardManager.findPair(classLoader.getResourceAsStream(FILE), INPUT_TWO));

	}
	@Test
	public void testApproximateTwo() throws IOException {
		assertEquals(RESULT_THREE, giftCardManager.findPair(classLoader.getResourceAsStream(FILE), INPUT_THREE));

	}
	@Test
	public void testNotPossible() throws IOException {
		assertEquals(RESULT_FOUR, giftCardManager.findPair(classLoader.getResourceAsStream(FILE), INPUT_FOUR));

	}
}
