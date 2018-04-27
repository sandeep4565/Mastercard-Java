package org.test.mastercard.cities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CityService {
	
	public Map<String, Set<String>> readCityConnections(String cityFile) throws IOException{
		
		Map<String, Set<String>> cityConnectionList = new HashMap<String, Set<String>>();
		BufferedReader bufferedReader = null;
		
		try {
			Reader fileReader = new FileReader(cityFile);
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			
			while (line != null && !line.isEmpty()) {
				String[] cities = line.split(",");
				String sourceCity = cities[0].trim();
				String destinationCity = cities[1].trim();

				Set<String> firstCityConnections = getAllConnectionsForCity(cityConnectionList, sourceCity);
				Set<String> secondCityConnections = getAllConnectionsForCity(cityConnectionList, destinationCity);
				firstCityConnections.add(destinationCity);
				secondCityConnections.add(sourceCity);

				line = bufferedReader.readLine();
			}

		}finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		
		return cityConnectionList;
		
	}
	
	private Set<String> getAllConnectionsForCity(Map<String, Set<String>> map, String city) {
		if (!map.containsKey(city)) {
			map.put(city, new HashSet<String>());
		}
		return map.get(city);
	}
	
	public boolean checkConnection(Map<String, Set<String>> cityConnectionList, String city1, String city2) {
		
		boolean isPath = city1.equals(city2);
		
		if (cityConnectionList.containsKey(city1) && cityConnectionList.containsKey(city2)) {
		
			Queue<String> citiesNotTraversed = new LinkedList<String>();
			Set<String> citiesTraversed = new HashSet<String>();

			citiesNotTraversed.add(city1);

			while (!citiesNotTraversed.isEmpty() && !isPath) {
				String city = citiesNotTraversed.poll();
				isPath = city.equals(city2);

				Set<String> possiblePaths = cityConnectionList.get(city);
				for (String p : possiblePaths) {
					if (!citiesTraversed.contains(p)) {
						citiesNotTraversed.add(p);
						citiesTraversed.add(p);
					}
				}
			}
		}

		return isPath;
	}
}

