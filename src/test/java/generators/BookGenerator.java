package generators;

import dto.Book;
import net.ugolok.generation.annotations.Generate;
import net.ugolok.generation.annotations.Generator;
import net.ugolok.generation.providers.FileStringProvider;
import net.ugolok.generation.providers.IntegerProvider;
import net.ugolok.generation.providers.LongProvider;
import net.ugolok.generation.providers.StringProvider;

@Generator
public class BookGenerator {
	public static final int N_BOOKS = 100;
	public static final int MIN_CODE_LEN = 10;
	public static final int MAX_CODE_LEN = 20;

	@Generate(provider = LongProvider.class, unique = true, min = 1, max = N_BOOKS + 1)
	long isbn;

	@Generate(provider = FileStringProvider.class, source = "booknames.dta")
	String title;

	@Generate(provider = FileStringProvider.class, source = "writers.dta", max = 10)
	String author;

	@Generate(provider = StringProvider.class, min = MIN_CODE_LEN, max = MAX_CODE_LEN)
	String code;

	@Generate(provider = IntegerProvider.class, min = 5, max = 30)
	int amount;

	public Book getDto() {
		return new Book(isbn, title, author, amount, code);
	}
}
