public class Node
	{
		Node link;
		int data;

		public Node()
		{
			link = null;
			data = 0;
		}

		public int getData()
		{	
			return this.data;
		}

		public void setData(int d)
		{
			this.data = d;
		}
		public Node getLink()
		{
			return this.link; 
		}
		public void setLink(Node n)
		{
			this.link = n;
		}

	}