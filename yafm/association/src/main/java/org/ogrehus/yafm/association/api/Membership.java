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

import org.ogrehus.foundation.pattern.nameable.Nameable;

/**
 * An Membership represents a belonging of a member to a specific association.
 * <p>
 * The membership stores additional information of the membership.
 * </p>
 * 
 * @param <T> Type of the membership, shall be a nameable member to allow to display all members generically by name. 
 * 
 */
public interface Membership<T extends Nameable> {



	/**
	 * Provides generic access to the member of this membership.
	 * 
	 * @return The member of this membership. 
	 * 
	 */
	T getMember();
}
