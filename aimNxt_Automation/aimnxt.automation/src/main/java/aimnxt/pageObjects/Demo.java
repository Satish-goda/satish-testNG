package aimnxt.pageObjects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Demo {

	public static 
	//ArrayList<String> 
	void getExpectedMenuItemsds() throws IOException {
//		String content = new String(Files.readAllBytes(
//				Paths.get(System.getProperty("user.dir") + "//src//test//java//aimnxt//data//menuItems.json")));
//		JSONObject jsonObject = new JSONObject(content);
//		JSONArray menuItemsArray = jsonObject.getJSONArray("menuItems");
//		JSONArray contentArray = jsonObject.getJSONArray("content");
//
//		System.out.println(contentArray);
//		ArrayList<String> menuItems = new ArrayList<String>();
//		for (int i = 0; i < menuItemsArray.length(); i++) {
//			menuItems.add(menuItemsArray.getString(i).toString());
//		}
//		return menuItems;
		
		
		int array[][];

		array = new int[10][];

		array[0] = new int[9];
		array[1] = new int[8];
		array[2] = new int[7];
		array[3] = new int[6];
		array[4] = new int[5];
		array[5] = new int[4];
		array[6] = new int[3];
		array[7] = new int[2];
		array[8] = new int[1];
		array[9] = new int[0];
		
		for(int i=0;i<array.length;i++) {
			for(int j=0; j<array.length; j++) {
				System.out.println(array[i][j]);
			}
		}
		System.out.println(array[1][1]);
		
//
	}
	
	


	public static void main(String[] args) throws IOException {

		getExpectedMenuItemsds();

	}
}
