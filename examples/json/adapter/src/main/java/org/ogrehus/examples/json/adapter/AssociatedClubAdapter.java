package org.ogrehus.examples.json.adapter;

import org.ogrehus.yafm.association.api.AssociatedClub;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class AssociatedClubAdapter 
implements 
	JsonbAdapter<AssociatedClub, JsonObject>
{



	@Override
	public JsonObject adaptToJson(AssociatedClub club) throws Exception {
		return Json.createObjectBuilder()
		.add("name", club.getName())
		.add("acronym", club.getAcronym())		
		.build();
	}



	@Override
	public AssociatedClub adaptFromJson(JsonObject json) throws Exception {
		return new AssociatedClub() {

			@Override
			public String getName() {
				return json.getString("name", "");
			}
			
			@Override
			public String getAcronym() {
				return json.getString("acronym", "");
			}
		};
	}
}
