package org.ogrehus.examples.json.adapter;

import org.ogrehus.examples.json.adapter.data.Consts;
import org.ogrehus.yafm.association.api.Association;

import jakarta.json.JsonObject;

public class Main {

	
	public static void main(String[] args) {
		AssociationAdapter adapter = new AssociationAdapter();
		try {
			JsonObject json = adapter.adaptToJson(Consts.FIFA.ASSOCIATION);
			System.out.println(json);
			
			Association<?> association = adapter.adaptFromJson(json);
			
			System.out.println(association.getName());
			System.out.println(association.getMemberships());
			System.out.println(association.getOrganization());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
