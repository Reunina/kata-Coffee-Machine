package test;

import main.CustomerOrder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerOrderTest {

    // from drink maker protocol

    @Test
    public void order_for_1_tea_with_1_sugar_and_a_stick_should_have_right_format() {
        String expectedOrder = "T:1:0";
        String actualOrder = new CustomerOrder('T', 1).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);
    }

    @Test
    public void order_for_1_chocolate_with_0_sugar_and_no_stick_should_have_right_format() {

        String expectedOrder = "H::";
        String actualOrder = new CustomerOrder('H', 0).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void order_for_1_coffee_with_2_sugars_and_a_stick_should_have_right_format() {

        String expectedOrder = "C:2:0";
        String actualOrder = new CustomerOrder('C', 2).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void order_for_1_orange_juice_should_have_right_format() {

        String expectedOrder = "O::";
        String actualOrder = new CustomerOrder('O').toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }
    @Test
    public void order_for_1_extra_hot_coffee_with_no_sugar_should_have_right_format() {

        String expectedOrder = "Ch::";
        String actualOrder = new CustomerOrder('C').toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void order_for_1_extra_hot_chocolate_with_1_sugar_and_a_stick_should_have_right_format() {

        String expectedOrder = "Hh:1:";
        String actualOrder = new CustomerOrder('H', 1).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void order_for_1_extra_hot_tea_with_2_sugar__and_a_stick_should_have_right_format() {

        String expectedOrder = "Th:2:";
        String actualOrder = new CustomerOrder('T', 2).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void message_from_drink_maker_should_have_right_format() {

        String expectedOrder = "M:messageExpected";
        String actualOrder = new CustomerOrder("messageExpected").getMessage();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);
    }

    // from User stories

    @Test
    public void the_drink_maker_should_receive_the_correct_instructions_for_coffee_order() {
        char expectedDrink = 'C';
        char actualDrink = new CustomerOrder('C').getDrinkType();
        assertThat(actualDrink)
                .as("Expected drink is " + expectedDrink + " instead of " + actualDrink)
                .isEqualTo(expectedDrink);

    }

    @Test
    public void the_drink_maker_should_receive_the_correct_instructions_for_tea_order() {
        char expectedDrink = 'T';
        char actualDrink = new CustomerOrder('T').getDrinkType();
        assertThat(actualDrink)
                .as("Expected drink is " + expectedDrink + " instead of " + actualDrink)
                .isEqualTo(expectedDrink);
    }

    @Test
    public void the_drink_maker_should_receive_the_correct_instructions_for_chocolate_order() {
        char expectedDrink = 'H';
        char actualDrink = new CustomerOrder('H').getDrinkType();
        assertThat(actualDrink)
                .as("Expected drink is " + expectedDrink + " instead of " + actualDrink)
                .isEqualTo(expectedDrink);
    }

    @Test
    public void the_drink_maker_should_receive_instructions_to_add_one_sugar() {
        int expectedSugar = 1;
        int actualSugar = new CustomerOrder('T', 1).getSugar();
        assertThat(actualSugar)
                .as("Expected sugar is " + expectedSugar + " instead of " + actualSugar)
                .isEqualTo(expectedSugar);
    }

    @Test
    public void the_drink_maker_should_receive_instructions_to_add_two_sugar() {
        int expectedSugar = 2;
        int actualSugar = new CustomerOrder('T', 2).getSugar();
        assertThat(actualSugar)
                .as("Expected sugar is " + expectedSugar + " instead of " + actualSugar)
                .isEqualTo(expectedSugar);
    }

    //testing stick with sugars

    @Test
    public void the_drink_maker_should_add_a_stick_when_order_contains_sugar() {

        boolean isStick = new CustomerOrder('T', 1).isStickAdded();
        assertThat(isStick)
                .as("Should be a stick added to the order")
                .isTrue();
    }

    @Test
    public void the_drink_maker_should_not_add_a_stick_when_order_does_not_contains_sugar() {

        boolean isStick = new CustomerOrder('T').isStickAdded();
        assertThat(isStick)
                .as("Should be a stick added to the order")
                .isFalse();
    }

    @Test
    public void the_drink_maker_should_not_add_a_stick_when_order_does_not_contains_wrong_amount_of_sugar() {

        boolean isStick = new CustomerOrder('T', -1).isStickAdded();
        assertThat(isStick)
                .as("Should be a stick added to the order")
                .isFalse();
    }


    //testing prices

    @Test
    public void ordering_a_tea_cost_40_cents() {
        CustomerOrder order = new CustomerOrder('T');
        double expectedPrice = 0.4;
        double actualPrice = order.getPrice();
        assertThat(actualPrice)
                .as("The price should be "+expectedPrice+" for ordering "+order.getDrinkType())
                .isEqualTo(expectedPrice);

    }

    @Test
    public void ordering_a_coffee_cost_60_cents() {
        CustomerOrder order = new CustomerOrder('C');
        double expectedPrice = 0.6;
        double actualPrice = order.getPrice();
        assertThat(actualPrice)
                .as("The price should be "+expectedPrice+" for ordering "+order.getDrinkType())
                .isEqualTo(expectedPrice);
    }

    @Test
    public void ordering_a_chocolate_cost_50_cents() {
        CustomerOrder order = new CustomerOrder('H');
        double expectedPrice = 0.5;
        double actualPrice = order.getPrice();
        assertThat(actualPrice)
                .as("The price should be "+expectedPrice+" for ordering "+order.getDrinkType())
                .isEqualTo(expectedPrice);
    }

    @Test
    public void ordering_an_orange_juice_cost_60_cents() {
        CustomerOrder order = new CustomerOrder('O');
        double expectedPrice = 0.6;
        double actualPrice = order.getPrice();
        assertThat(actualPrice)
                .as("The price should be "+expectedPrice+" for ordering "+order.getDrinkType())
                .isEqualTo(expectedPrice);
    }

    // testing money handling
    @Test
    public void the_drink_maker_should_make_the_drinks_if_the_correct_amount_of_money_is_given() {

        CustomerOrder order = new CustomerOrder('H', 0.5);
        assertThat(order.makeTheDrink())
                .as("The drink should be make with the right amount of money.")
                .isTrue();
    }

    @Test
    public void the_drink_maker_should_not_make_the_drinks_if_not_enough_money_is_not_given() {

        CustomerOrder order = new CustomerOrder('H', 0.2);
        assertThat(order.makeTheDrink())
                .as("The drink should not be make with not enough money.")
                .isFalse();
    }

    @Test
    public void the_drink_maker_should_not_make_the_drinks_if_no_money_is_given() {

        CustomerOrder order = new CustomerOrder('H', 0.0);
        assertThat(order.makeTheDrink())
                .as("The drink should not be make with no money.")
                .isFalse();
    }

    @Test
    public void the_drink_maker_should_make_the_drinks_if_more_of_money_is_given() {

        CustomerOrder order = new CustomerOrder('H', 12.0);
        assertThat(order.makeTheDrink())
                .as("The drink should be make with more than enough money.")
                .isTrue();
    }

    //_The_message_should_contains_at_least_the_amount_of_money_missing.
    @Test
    public void the_drink_maker_should_received_a_message_if_not_enough_money_is_given() {

        CustomerOrder order = new CustomerOrder('H', 0.2);
        assertThat(order.getMessageForDrinkMaker())
                .as("A message should be display when there is not enough money.")
                .isNotBlank();
    }


}
