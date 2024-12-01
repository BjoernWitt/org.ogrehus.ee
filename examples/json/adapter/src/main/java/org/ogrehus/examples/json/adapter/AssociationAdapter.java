package org.ogrehus.examples.json.adapter;

import java.util.Collections;
import java.util.Set;

import org.ogrehus.yafm.association.api.Association;
import org.ogrehus.yafm.association.api.AssociationMembership;
import org.ogrehus.yafm.association.api.Membership;
import org.ogrehus.yafm.association.api.AssociationOrganization;
import org.ogrehus.yafm.association.api.ClubMembership;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class AssociationAdapter 
implements 
	JsonbAdapter<Association<AssociationOrganization>, JsonObject>
{



	@Override
	public JsonObject adaptToJson(Association<AssociationOrganization> association) throws Exception {
		JsonArrayBuilder memberBuilder = Json.createArrayBuilder();
		for (Membership<?> membership : association.getMemberships()) {
			if (membership instanceof ClubMembership clubMembership ) {
				memberBuilder.add(new ClubMembershipAdapter().adaptToJson(clubMembership));
			}
			if (membership instanceof AssociationMembership associationMembership ) {
				memberBuilder.add(new AssociationMembershipAdapter().adaptToJson(associationMembership));
			}
		}
		
		return Json.createObjectBuilder()
		.add("name", association.getName())
		.add("acronym", association.getAcronym())
		.add("organization", new AssociationOrganizationAdapter().adaptToJson(association.getOrganization()))
		.add("memberships", memberBuilder) 
		.build();
	}



	@Override
	public Association<AssociationOrganization> adaptFromJson(JsonObject json) throws Exception {
		return new Association<AssociationOrganization>() {
			
			@Override
			public AssociationOrganization getOrganization()  {
				try {
					return new AssociationOrganizationAdapter().adaptFromJson(json.getJsonObject("organization"));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			
			@Override
			public String getName() {
				return json.getString("name", "");
			}
			
			@Override
			public Set<Membership<?>> getMemberships() {
				// TODO Auto-generated method stub
				return Collections.emptySet();
			}
			
			@Override
			public String getAcronym() {
				return json.getString("acronym", "");
			}
		};

	}
	
}
