public class BookLinkedList
{

	public String bookName;
	public int millionsSold;

	public BookLinkedList(String name,int millionsSold)
	{
		this.bookName = name;
		this.millionsSold = millionsSold;
	}

	public String toString()
	{
		return bookName;
	}
}