package aimnxt.testPages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Demo {

	public static ArrayList<String> getMenuItems() throws IOException {
		ArrayList<String> expectedMenus = new ArrayList<String>();
		String content = new String(Files.readAllBytes(
				Paths.get(System.getProperty("user.dir") + "//src//test//java//aimnxt//data//data.json")));
		JSONObject jsonObject = new JSONObject(content);
		JSONArray menuItemsArray = jsonObject.getJSONArray("menuItems");
		ArrayList<String> menuItems = new ArrayList<String>();
		for (int i = 0; i < menuItemsArray.length(); i++) {
			// menuItems[i] =
			menuItems.add(menuItemsArray.getString(i).toString());
		}

		return menuItems;
	}
	
	
	
	

	public static void main(String[] args) throws IOException {

		ArrayList<String> menuItems = getMenuItems();
		System.out.println(menuItems);
		// Print the menu items to verify
//		for (String item : menuItems) {
//			System.out.println(item);
//		}
	}
}
