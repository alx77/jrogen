package dto;

public class Book {
	protected long isbn;

	protected String title;

	protected String author;

	protected String code;

	protected int amount;

	public Book() {
		super();
	}

	public Book(long isbn, String title, String author, int amount, String code) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.amount = amount;
		this.code = code;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCode() {
		return code;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", code=" + code + ", amount="
				+ amount + "]";
	}
}
