package com.codestates;

import com.codestates.helper.StampCalculator;
import com.codestates.order.entity.Order;
import com.codestates.order.entity.OrderCoffee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Be39Section3Week3HomeworkJunitApplicationTests {

	@DisplayName("CalculateStampCountTest() Test")
	@Test
	public void CalculateStampCountTest() {
		calculateStampCountTest();

	}
	@DisplayName("calculateEarnedStampCountTest() Test")
	@Test
	public void CalculateEarnedStampCountTest() {

		calculateEarnedStampCountTest();
	}

	@DisplayName("RandomPasswordGeneratorTest() Test")
	@Test
	public void RandomPasswordGeneratorTest() {

		randomPasswordGeneratorTest();
	}


	private static void randomPasswordGeneratorTest(){





	}







	private static void calculateStampCountTest() {
		// given
		int nowCount = 5;
		int earned = 3;


		// when
		int actual = StampCalculator.calculateStampCount(nowCount, earned);

		int expected = 7;

		// then
		assertEquals(expected, actual);
	}

	private static void calculateEarnedStampCountTest() {
		// given
		Order order = new Order();
		OrderCoffee orderCoffee1 = new OrderCoffee();
		orderCoffee1.setQuantity(3);

		OrderCoffee orderCoffee2 = new OrderCoffee();
		orderCoffee2.setQuantity(5);

		order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));

		int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();

		// when
		int actual = StampCalculator.calculateEarnedStampCount(order);


		// then
		assertEquals(expected, actual);
	}
}
