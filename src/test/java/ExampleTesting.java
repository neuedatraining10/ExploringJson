import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class ExampleTesting {

    @Test
    public void testSalesTaxIsCalculatedCorrectly() {
        //given: that we have a book
        Book book = new Book(1, "Learninf Java", "Matt");

        //when: the price is $100
        book.setPrice(new BigDecimal("100"));

        //then: the price with sales tax is $107
        assertEquals(new BigDecimal("107.00"), book.getPriceWithSalesTax());

    }

    @Test
    public void testNoSalesTaxonFreeBooks(){
        Book book = new Book(1, "Learninf Java", "Matt");
        book.setPrice(BigDecimal.ZERO);
        assertEquals(new BigDecimal("0.00"), book.getPriceWithSalesTax());
    }

    @Test
    public void testExceptionIsThrownIfPriceIsNegative() {
        Book book = new Book(1, "Learninf Java", "Matt");
        book.setPrice(new BigDecimal("-10"));

        assertThrows(RuntimeException.class, () -> {
            book.getPriceWithSalesTax();
        });
    }
}
