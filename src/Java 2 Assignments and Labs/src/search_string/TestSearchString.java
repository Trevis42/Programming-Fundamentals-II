package search_string;

import java.io.IOException;

public class TestSearchString {

	public static void main(String[] args) throws IOException {
		
		SearchString ss = new SearchString();
		
		SearchString.main(null); //for static
		ss.main(); //for nonstatic

	}

}
