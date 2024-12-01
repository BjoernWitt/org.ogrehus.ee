package org.ogrehus.examples.json.adapter;

import java.time.Instant;

import org.ogrehus.yafm.association.api.AssociationOrganization;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class AssociationOrganizationAdapter 
implements 
	JsonbAdapter<AssociationOrganization, JsonObject>
{



	@Override
	public JsonObject adaptToJson(AssociationOrganization organization) throws Exception {
		return Json.createObjectBuilder()
		.add("foundedDate", ""+organization.getFoundedDate())
		.build();
	}



	@Override
	public AssociationOrganization adaptFromJson(JsonObject json) throws Exception {
		return new AssociationOrganization() {
			
			@Override
			public Instant getFoundedDate() {
				return Instant.parse(json.getString("foundedDate"));
			}
		};
	}
	
}
