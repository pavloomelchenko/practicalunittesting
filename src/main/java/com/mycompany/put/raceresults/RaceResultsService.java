package com.mycompany.put.raceresults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RaceResultsService {

	private Map<Categories, List<Client>> clients = new EnumMap<Categories, List<Client>>(
			Categories.class);
	LogService logService;

	public RaceResultsService(LogService logService) {
		this.logService = logService;
		Arrays.stream(Categories.values())
				.forEach(cat -> clients.put(cat, new ArrayList<Client>()));
	}

	public void send(Message msg) {
		clients.get(msg.getCategory()).forEach(c -> c.receive(msg));
		logService.log(msg.getDate() + msg.getText());
	}

	public void unsubscribe(Client client, Categories category) {
		clients.get(category).remove(client);
	}

	public void subscribe(Client client, Categories category) {
		if (!clients.get(category).contains(client)) {
			clients.get(category).add(client);
		}
	}

}
