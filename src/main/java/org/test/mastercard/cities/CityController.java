package org.test.mastercard.cities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	Map<String, Set<String>> map = new HashMap<String, Set<String>>();
	Boolean flag = false;
	String result;

	@RequestMapping(method = RequestMethod.GET,value="/connected")
	public String connected(@RequestParam String origin,
					   @RequestParam String destination) throws IOException
	{
		System.out.println(origin);
		System.out.println(destination);
		
		map = cityService.readCityConnections("C:\\Users\\admin\\Downloads\\MasterCard\\MasterCard\\src\\main\\resources\\static\\city.txt");
		flag = cityService.checkConnection(map, origin, destination);
		
		if(flag==true) {
			System.out.println("YES");
			return "Yes";
		}else {
			System.out.println("NO");
			return "No";
		}

	}
	
}
