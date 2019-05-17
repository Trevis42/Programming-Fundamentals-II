import java.util.StringTokenizer;

public class IsPalindrome {

	public static void main(String[] args) {
		
		String s1 = new String("A dog a panic in a pagoda");
		String s2 = new String("Rats live on no evil star");
		String s3 = new String("I am the best");
		
		System.out.println("Are any of these strings palindromes?\n");
		System.out.println(s1 + ": " + isPal(s1) + " ");
		System.out.println(s2 + ": " + isPal(s2) + " ");
		System.out.println(s3 + ": " + isPal(s3) + " ");

	}
	
	public static boolean isPal(String str) 
	{
		QueueReferenceBased rQueue = new QueueReferenceBased();
		StackReferenceBased rStack = new StackReferenceBased();
		
		StringTokenizer st = new StringTokenizer(str.toUpperCase());

		String s = new String();
		while (st.hasMoreTokens()){
			s += st.nextToken();
		}

		//System.out.println(s);
		for(int i = 0; i < s.length(); i++){
			
			rQueue.enqueue(s.charAt(i));
			rStack.push(s.charAt(i));
		}
		
		//Compare queue and stack contents
		
		while(!rQueue.isEmpty()) 
		{
			if(rQueue.dequeue() != rStack.pop())
				return false;
		}
		return true;
	}

}
