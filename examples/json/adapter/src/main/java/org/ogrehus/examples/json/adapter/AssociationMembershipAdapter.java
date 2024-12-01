package org.ogrehus.examples.json.adapter;

import java.time.Instant;

import org.ogrehus.yafm.association.api.Association;
import org.ogrehus.yafm.association.api.AssociationMembership;
import org.ogrehus.yafm.association.api.AssociationOrganization;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class AssociationMembershipAdapter 
implements 
	JsonbAdapter<AssociationMembership, JsonObject>
{



	@Override
	public JsonObject adaptToJson(AssociationMembership membership) throws Exception {
		return Json.createObjectBuilder()
			.add("type", "AssociationMembership")
			.add("since", membership.getSince().toString())
			.add("member", new AssociationAdapter().adaptToJson(membership.getMember())) 
			.build();
	}



	@Override
	public AssociationMembership adaptFromJson(JsonObject json) throws Exception {
		return new AssociationMembership() {

			@Override
			public Association<AssociationOrganization> getMember() {
				try {
					return new AssociationAdapter().adaptFromJson(json.getJsonObject("member"));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

			@Override
			public Instant getSince() {
				return Instant.parse(json.getString("since", ""));
			}
			
		};
	}
}
