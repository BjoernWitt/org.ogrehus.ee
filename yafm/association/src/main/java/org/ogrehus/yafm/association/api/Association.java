/*
 * GNU Lesser General Public License v3.0
 * https://www.gnu.org/licenses/lgpl-3.0-standalone.html
 * 
 * Copyright (C) 2024 Björn Witt
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 */	
package org.ogrehus.yafm.association.api;

import java.util.LinkedHashSet;
import java.util.Set;

import org.ogrehus.foundation.pattern.nameable.Acronymable;
import org.ogrehus.foundation.pattern.nameable.Nameable;

/**
 * An association represents a union/organization of members that have common competitions with each others.
 * <p>
 * Examples may be the FIFA, UEFA, DFB, etc. 
 * </p>
 * 
 * @param <O> Type of organization that organized the association, must inherit.
 * 
 */
public interface Association<
	O extends AssociationOrganization
> extends
	  Nameable
	, Acronymable
{



	/**
	 * Provides informations of the organization of the association.
	 * 
	 * @return The organization of the association.
	 * 
	 * 
	 */
	O getOrganization();



	/**
	 * Provides the members of this association.
	 * 
	 * @return All active memberships of this association.
	 * 
	 */
	Set<Membership<?>> getMemberships();
	
	
	
	/**
	 * Provides all Members by a specific type.
	 * 
	 * @param <TYPE> The type that shall be returned.
	 * 
	 * @param type The java class of the type that shall be returned.
	 * 
	 * @return A Set of all members that are instance of type.
	 * 
	 */
	default <TYPE extends Membership<?>> Set<TYPE> getMembershipsByType(Class<TYPE> type) {
		Set<TYPE> membershipByType = new LinkedHashSet<>();
		
		for (Membership<?> membership : getMemberships()) {
			if (type.isInstance(membership)) {
				membershipByType.add(type.cast(membershipByType));
			}
		}
		
		return membershipByType;
	}
}
