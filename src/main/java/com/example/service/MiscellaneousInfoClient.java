package com.example.service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.example.rest.JsonContentTypeResponseFilter;
import com.example.rest.model.misc.MiscellaneousInfo;
import com.example.util.Cache;
import com.example.util.FlightRange;
import com.example.util.RestClient;


/**
 * @author Ravisankar C
 *
 */
@ApplicationScoped
public class MiscellaneousInfoClient {
	
	public static final String url  = "https://raw.githubusercontent.com/Ravisankar-Challa/tomee_embedded/master/src/main/resources/miscellaneousinfo.js";
	
	@Inject
	@RestClient
	private Client client;

	private static final Logger LOG = Logger.getLogger(MiscellaneousInfoClient.class.getName());
	
	public MiscellaneousInfo getMiscellaneousInfo() {

		//LOG.info("Calling MiscellaneousInfo URL :: "+url);
		try {
			// We have registered a JsonContentTypeResponseFilter since the url 
			// Using JsonContentTypeResponseFilter we will override the content type to application/json
			return  client.target(url)
						  .register(JsonContentTypeResponseFilter.class)
					      .request()
					      .get(MiscellaneousInfo.class);
		} catch(ProcessingException | NotFoundException e) {
			LOG.severe("Calling MiscellaneousInfo URL :: "+url);
			LOG.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}
	
	public void updateMiscellaneousInfo() {
		MiscellaneousInfo miscInfo = getMiscellaneousInfo();
		if(miscInfo != null) {
			Cache.store.setMiscInfo(miscInfo);
			//Below logic is used to store tiles in case insensitive format
			//Copying from MiscInfo tiles Map to Cache.store tiles TreeMap
			//Using TreeMap we can do case insensitive comparison.
			//ex: From Amadeus reservation system we get title as "LTGEN" but in json it is "LtGen"
			Cache.store.getMiscInfo()
			.getTitles()
			.forEach((key, value) -> {
				Cache.store.getTitles().put(key.trim(), value.trim());
			});
			
			//We get airline code and airline name in json as "AA":"American Airlines"
			//Here key is AA and value is American Airlines
			//But our requirement is to map airline name to airline code.
			//So we are storing key as airline name "American Airlines" and value as airline code "AA"
			Map<String, String> tempMap = new HashMap<>(Cache.store.getMiscInfo().getAirlines());
			tempMap.forEach((key, value) -> {
						//Key and value are swapped here
						Cache.store.getMiscInfo().getAirlines().put(value.toLowerCase().trim(), key.trim());
			});
			
			Cache.store.setCodeShareFlightRanges(
					miscInfo.getCode_share_flight_range().stream()
					.map(this::createFlightRange)
					.collect(toList()));
			
			Cache.store.setInternationalFlightRanges(
					miscInfo.getInternational_flight_range().stream()
					.map(this::createFlightRange)
					.collect(toList()));
		}	
	}

	private FlightRange createFlightRange(String range) {
		String[] ranges = range.split("-");
		return new FlightRange(Integer.parseInt(ranges[0].trim()), Integer.parseInt(ranges[1].trim()));
	}
}