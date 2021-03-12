package net.ugolok.test;

import net.ugolok.dto.Barrier;
import net.ugolok.dto.Book;
import net.ugolok.dto.Person;
import net.ugolok.generation.JROFactory;
import net.ugolok.generators.BarrierGenerator;
import net.ugolok.generators.BookGenerator;
import net.ugolok.generators.PersonGenerator;
import org.junit.jupiter.api.Test;

import javax.naming.ConfigurationException;
import java.util.Iterator;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaticGenerationTest {

    @Test
    public void embeddingTest() throws ConfigurationException {
        Iterator<PersonGenerator> iterator = JROFactory.create(PersonGenerator.class).iterator();
        TreeMap<Integer, Person> personsMap = new TreeMap<>();

        while (iterator.hasNext()) {
            Person p = iterator.next().getDto();
            personsMap.put(p.getId(), p);
        }

        int prevId = Integer.MIN_VALUE;
        for (Person person : personsMap.values()) {
            assertTrue(prevId < person.getId());
            assertEquals(11, person.getPhone().length());
            prevId = person.getId();
        }
        assertEquals(PersonGenerator.N_PERSONS, personsMap.values().size());
    }

    @Test
    public void rangeTest() throws ConfigurationException {
        JROFactory<BarrierGenerator> factory = JROFactory.create(BarrierGenerator.class);
        Iterator<BarrierGenerator> iterator = factory.iterator();

        TreeMap<Long, Barrier> barriersMap = new TreeMap<>();

        while (iterator.hasNext()) {
            Barrier b = iterator.next().getDto();
            barriersMap.put(b.getId(), b);
        }

        long prevId = Integer.MIN_VALUE;
        for (Barrier person : barriersMap.values()) {
            assertTrue(prevId < person.getId());
            prevId = person.getId();
        }
        assertEquals(BarrierGenerator.N_QUANTITY, barriersMap.values().size());
    }

    @Test
    public void bookTest() throws ConfigurationException {
        JROFactory<BookGenerator> factory = JROFactory.create(BookGenerator.class);
        Iterator<BookGenerator> iterator = factory.iterator();

        TreeMap<Long, Book> bookMap = new TreeMap<>();

        while (iterator.hasNext()) {
            Book b = iterator.next().getDto();
            bookMap.put(b.getIsbn(), b);
        }

        long prevId = Integer.MIN_VALUE;
        for (Book book : bookMap.values()) {
            assertTrue(prevId < book.getIsbn());
            prevId = book.getIsbn();
        }
        assertEquals(BookGenerator.N_BOOKS, bookMap.values().size());
    }
}
