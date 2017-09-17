package test;

import main.CustomerMessage;
import main.CustomerOrder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerOrderTest {

    // from drink maker protocol

    @Test
    public void order_for_1_tea_with_1_sugar_and_a_stick_should_have_right_format() {
        String expectedOrder = "T:1:0";
        String actualOrder = new CustomerOrder("T", 1).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);
    }

    @Test
    public void order_for_1_chocolate_with_0_sugar_and_no_stick_should_have_right_format() {

        String expectedOrder = "H::";
        String actualOrder = new CustomerOrder("H").toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void order_for_1_coffee_with_2_sugars_and_a_stick_should_have_right_format() {

        String expectedOrder = "C:2:0:";
        String actualOrder = new CustomerOrder("C", 2).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void message_from_drink_maker_should_have_right_format() {

        String expectedOrder = "M:messageExpected";
        String actualOrder = new CustomerMessage("messageExpected").toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);
    }

    // from User stories

    @Test
    public void the_drink_maker_should_receive_the_correct_instructions_for_coffee_order() {
        String expectedDrink = "C";
        String actualDrink = new CustomerOrder("C").getDrinkType();
        assertThat(actualDrink)
                .as("Expected drink is " + expectedDrink + " instead of " + actualDrink)
                .isEqualTo(expectedDrink);


    }

    @Test
    public void the_drink_maker_should_receive_the_correct_instructions_for_tea_order() {
        String expectedDrink = "T";
        String actualDrink = new CustomerOrder("T").getDrinkType();
        assertThat(actualDrink)
                .as("Expected drink is " + expectedDrink + " instead of " + actualDrink)
                .isEqualTo(expectedDrink);
    }

    @Test
    public void the_drink_maker_should_receive_the_correct_instructions_for_chocolate_order() {
        String expectedDrink = "H";
        String actualDrink = new CustomerOrder("H").getDrinkType();
        assertThat(actualDrink)
                .as("Expected drink is " + expectedDrink + " instead of " + actualDrink)
                .isEqualTo(expectedDrink);
    }

    @Test
    public void the_drink_maker_should_receive_instructions_to_add_one_sugar() {
        int expectedSugar = 1;
        int actualSugar = new CustomerOrder("T", 1).getSugar();
        assertThat(actualSugar)
                .as("Expected sugar is " + expectedSugar + " instead of " + actualSugar)
                .isEqualTo(expectedSugar);
    }

    @Test
    public void the_drink_maker_should_receive_instructions_to_add_two_sugar() {
        int expectedSugar = 2;
        int actualSugar = new CustomerOrder("T", 2).getSugar();
        assertThat(actualSugar)
                .as("Expected sugar is " + expectedSugar + " instead of " + actualSugar)
                .isEqualTo(expectedSugar);
    }

    //testing stick with sugars

    @Test
    public void the_drink_maker_should_add_a_stick_when_order_contains_sugar() {

        boolean isStick = new CustomerOrder("T", 1).isStickAdded();
        assertThat(isStick)
                .as("Should be a stick added to the order")
                .isTrue();
    }

    @Test
    public void the_drink_maker_should_not_add_a_stick_when_order_does_not_contains_sugar() {

        boolean isStick = new CustomerOrder("T").isStickAdded();
        assertThat(isStick)
                .as("Should be a stick added to the order")
                .isFalse();
    }

    @Test
    public void the_drink_maker_should_not_add_a_stick_when_order_does_not_contains_wrong_amount_ofsugar() {

        boolean isStick = new CustomerOrder("T",-1).isStickAdded();
        assertThat(isStick)
                .as("Should be a stick added to the order")
                .isFalse();
    }

}
