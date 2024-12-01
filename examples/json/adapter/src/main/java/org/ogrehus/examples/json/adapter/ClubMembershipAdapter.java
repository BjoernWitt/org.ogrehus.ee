package org.ogrehus.examples.json.adapter;

import org.ogrehus.yafm.association.api.AssociatedClub;
import org.ogrehus.yafm.association.api.ClubMembership;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class ClubMembershipAdapter 
implements 
	JsonbAdapter<ClubMembership, JsonObject>
{



	@Override
	public JsonObject adaptToJson(ClubMembership membership) throws Exception {
		return Json.createObjectBuilder()
		.add("member", new AssociatedClubAdapter().adaptToJson(membership.getMember()))
		.build();
	}



	@Override
	public ClubMembership adaptFromJson(JsonObject json) throws Exception {
		return new ClubMembership() {

			@Override
			public AssociatedClub getMember() {
				try {
					return new AssociatedClubAdapter().adaptFromJson(json.getJsonObject("member"));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		};
	}
	
}
