package test;

import main.CustomerOrder;
import main.Report;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        String actualOrder = new CustomerOrder('C', true).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void order_for_1_extra_hot_chocolate_with_1_sugar_and_a_stick_should_have_right_format() {

        String expectedOrder = "Hh:1:0";
        String actualOrder = new CustomerOrder('H', true, 1).toString();
        assertThat(actualOrder)
                .as("Expected order is " + expectedOrder + " and not " + actualOrder)
                .isEqualTo(expectedOrder);

    }

    @Test
    public void order_for_1_extra_hot_tea_with_2_sugar__and_a_stick_should_have_right_format() {

        String expectedOrder = "Th:2:0";
        String actualOrder = new CustomerOrder('T', true, 2).toString();
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
                .as("The price should be " + expectedPrice + " for ordering " + order.getDrinkType())
                .isEqualTo(expectedPrice);

    }

    @Test
    public void ordering_a_coffee_cost_60_cents() {
        CustomerOrder order = new CustomerOrder('C');
        double expectedPrice = 0.6;
        double actualPrice = order.getPrice();
        assertThat(actualPrice)
                .as("The price should be " + expectedPrice + " for ordering " + order.getDrinkType())
                .isEqualTo(expectedPrice);
    }

    @Test
    public void ordering_a_chocolate_cost_50_cents() {
        CustomerOrder order = new CustomerOrder('H');
        double expectedPrice = 0.5;
        double actualPrice = order.getPrice();
        assertThat(actualPrice)
                .as("The price should be " + expectedPrice + " for ordering " + order.getDrinkType())
                .isEqualTo(expectedPrice);
    }

    @Test
    public void ordering_an_orange_juice_cost_60_cents() {
        CustomerOrder order = new CustomerOrder('O');
        double expectedPrice = 0.6;
        double actualPrice = order.getPrice();
        assertThat(actualPrice)
                .as("The price should be " + expectedPrice + " for ordering " + order.getDrinkType())
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

    @Test
    public void the_drink_maker_should_received_a_message_if_not_enough_money_is_given() {

        CustomerOrder order = new CustomerOrder('H', 0.2);
        assertThat(order.getMessageForDrinkMaker())
                .as("A message should be display when there is not enough money.")
                .isNotBlank();
    }

    @Test
    public void the_message_received_if_not_enough_money_is_given_should_contains_the_amount_of_money_missing() {

        CustomerOrder order = new CustomerOrder('H', 0.2);
        double missingMoney = 0.5 - 0.2;
        assertThat(order.getMessageForDrinkMaker())
                .as("The displayed message should contains the amount of missing money: " + missingMoney)
                .contains(missingMoney + " euros");
    }

    //testing report


    public String reportPath = "src/test/resources/dataReport/report.txt";


    @Test
    public void the_report_should_print_the_money_earned_so_far() {

        Report report = new Report(reportPath);
        clean_data(reportPath);

        CustomerOrder firstOrder = new CustomerOrder('C', 2, 2.0);
        firstOrder.makeTheDrink();

        double expectedTotal = 0.6;
        double actualTotal = report.print_money_earned();

        assertThat(actualTotal)
                .as("Should have " + expectedTotal + " instead of " + actualTotal)
                .isEqualTo(expectedTotal);

    }

    private void clean_data(String reportPath) {
        try {
            Files.write(Paths.get(reportPath), "".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void the_report_should_print_the_money_earned_anytime() {

        Report report = new Report(reportPath);
        clean_data(reportPath);

        CustomerOrder firstOrder = new CustomerOrder('C', 2, 2.0);
        CustomerOrder secondOrder = new CustomerOrder('T', 2, 4.0);

        firstOrder.makeTheDrink();

        double expectedTotalAfterFirstOrder = 0.6;
        double actualTotalAfterFirstOrder = report.print_money_earned();

        assertThat(actualTotalAfterFirstOrder)
                .as("Should have " + expectedTotalAfterFirstOrder + " instead of " + actualTotalAfterFirstOrder)
                .isEqualTo(expectedTotalAfterFirstOrder);

        secondOrder.makeTheDrink();

        double expectedTotalAfterSecondOrder = 1.0;
        double actualTotalAfterSecondOrder = report.print_money_earned();

        assertThat(actualTotalAfterSecondOrder)
                .as("Should have " + expectedTotalAfterSecondOrder + " instead of " + actualTotalAfterSecondOrder)
                .isEqualTo(expectedTotalAfterSecondOrder);

    }

    @Test
    public void the_report_should_print_how_many_drink_sold_so_far() {

        Report report = new Report(reportPath);
        clean_data(reportPath);

        CustomerOrder firstOrder = new CustomerOrder('C', 2, 2.0);
        firstOrder.makeTheDrink();

        String expectedTotal = "C:1";
        String actualTotal = report.print_sold_drinks();

        assertThat(actualTotal)
                .as("Should have " + expectedTotal + " instead of " + actualTotal)
                .isEqualTo(expectedTotal);

    }

    @Test
    public void the_report_should_print_how_many_drink_sold_anytime() {

        Report report = new Report(reportPath);
        clean_data(reportPath);

        CustomerOrder firstOrder = new CustomerOrder('C', 2, 2.0);
        CustomerOrder secondOrder = new CustomerOrder('T', 2, 4.0);

        firstOrder.makeTheDrink();

        String expectedTotalAfterFirstOrder = "C:1";
        String actualTotalAfterFirstOrder = report.print_sold_drinks();

        assertThat(actualTotalAfterFirstOrder)
                .as("Should have " + expectedTotalAfterFirstOrder + " instead of " + actualTotalAfterFirstOrder)
                .isEqualTo(expectedTotalAfterFirstOrder);

        secondOrder.makeTheDrink();

        String expectedTotalAfterSecondOrder = "C:1 T:2";
        String actualTotalAfterSecondOrder = report.print_sold_drinks();

        assertThat(actualTotalAfterSecondOrder)
                .as("Should have " + expectedTotalAfterSecondOrder + " instead of " + actualTotalAfterSecondOrder)
                .isEqualTo(expectedTotalAfterSecondOrder);

    }


    @Test
    public void the_report_should_print_the_right_number_of_drink_sold() {

        Report report = new Report(reportPath);
        clean_data(reportPath);


        CustomerOrder firstOrder = new CustomerOrder('C', 2, 2.0);
        CustomerOrder secondOrder = new CustomerOrder('C', 2, 4.0);

        firstOrder.makeTheDrink();
        secondOrder.makeTheDrink();

        String expectedTotalAfterSecondOrder = "C:2";
        String actualTotalAfterSecondOrder = report.print_sold_drinks();

        assertThat(actualTotalAfterSecondOrder)
                .as("Should have " + expectedTotalAfterSecondOrder + " instead of " + actualTotalAfterSecondOrder)
                .isEqualTo(expectedTotalAfterSecondOrder);

    }

    @Test
    public void the_report_should_differentiate_drink_and_extra_hot_drink() {
        Report report = new Report(reportPath);
        clean_data(reportPath);

        CustomerOrder firstOrder = new CustomerOrder('C', 2, 2.0);
        CustomerOrder secondOrder = new CustomerOrder('C', true, 2, 4.0);

        firstOrder.makeTheDrink();
        secondOrder.makeTheDrink();

        String expectedTotalAfterSecondOrder = "C:1 Ch:1";
        String actualTotalAfterSecondOrder = report.print_sold_drinks();

        assertThat(actualTotalAfterSecondOrder)
                .as("Should have " + expectedTotalAfterSecondOrder + " instead of " + actualTotalAfterSecondOrder)
                .isEqualTo(expectedTotalAfterSecondOrder);

    }
}
