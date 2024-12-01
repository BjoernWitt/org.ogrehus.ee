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
package org.ogrehus.yafm.competition.api;

import java.time.Instant;

/**
 * An CompetitionSeason represents a time interval that contains competitions.
 * 
 */
public interface CompetitionSeason {



	/**
	 * Provides the name of the Season.
	 * <p>
	 * The name of the season may describe the time interval like a year "2024" or something like "24/25" if the 
	 * interval overlaps a year. 
	 * </p>
	 * 
	 * @return Name of the club. 
	 * 
	 */
	String getName();



	/**
	 * Provides the start date of the season time interval.
	 * <p>
	 * The start date is included within the season. That means, if 15th of July may be the start date, tournaments or
	 * round may take place on the 15th of July. 
	 * 
	 * @return The start date of the season.
	 * 
	 */
	Instant getStart();



	/**
	 * Provides the end date of the season time interval.
	 * <p>
	 * The end date is included within the season. That means, if 14th of July may be the end date, tournaments or
	 * round may take place on the 14th of July. 
	 * 
	 * @return The start date of the season.
	 * 
	 */
	Instant getEnd();
}
