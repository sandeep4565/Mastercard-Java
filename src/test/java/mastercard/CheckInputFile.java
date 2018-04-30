package mastercard;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.test.mastercard.cities.CityService;

import junit.framework.Assert;

public class CheckInputFile {
	
	CityService cityService;
	Map<String, Set<String>> m = new HashMap<String, Set<String>>();
	
	@Test
	@BeforeClass
	public void isFileNull(String file) throws IOException {
		
		m = cityService.readCityConnections(file);
		
		URL url = getClass().getResource(file);
		
		Assert.assertNotNull(url);
		System.out.println("File is not empty");
	}
	
	@Test
	public void checkMap(String file) throws IOException {
		
		m = cityService.readCityConnections(file);
		Assert.assertEquals(m, cityService.cityConnectionList);
	}
}
