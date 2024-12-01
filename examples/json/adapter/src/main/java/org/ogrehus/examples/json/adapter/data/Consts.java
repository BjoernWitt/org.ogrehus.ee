package org.ogrehus.examples.json.adapter.data;

import java.time.Instant;
import java.util.Set;

import org.ogrehus.yafm.association.api.AssociatedClub;
import org.ogrehus.yafm.association.api.Association;
import org.ogrehus.yafm.association.api.AssociationMembership;
import org.ogrehus.yafm.association.api.Membership;
import org.ogrehus.yafm.association.api.AssociationOrganization;
import org.ogrehus.yafm.association.api.ClubMembership;

public class Consts {

	public static final class FIFA {
		public static final Association<AssociationOrganization> ASSOCIATION = new Association<>() {
			
			@Override
			public AssociationOrganization getOrganization() {
				return ORG;
			}
			
			@Override
			public String getName() {
				return "Fédération Internationale de Football Association";
			}
	
			@Override
			public Set<Membership<?>> getMemberships() {
				return Set.of(UEFA.MEMBER, CONMEBOL.MEMBER);
			}

			@Override
			public String getAcronym() {
				return "FIFA";
			}
		};
		public static final AssociationOrganization ORG = new AssociationOrganization() {
			
			@Override
			public Instant getFoundedDate() {
				return Instant.parse("1904-05-21T12:00:00.000Z"); 
			}
		};		
	}

	public static final class UEFA { 
		public static final Association<AssociationOrganization> ASSOCIATION = new Association<>() {
			
			@Override
			public AssociationOrganization getOrganization() {
				return UEFA.ORG;
			}
			
			@Override
			public String getName() {
				return "Union of European Football Associations (UEFA)";
			}
			
			@Override
			public Set<Membership<?>> getMemberships() {
				return Set.of(DFB.MEMBER_UEFA);
			}

			@Override
			public String getAcronym() {
				return "UEFA";
			}
		};
		
		public static final AssociationMembership MEMBER = new AssociationMembership() {
			
			@Override
			public Instant getSince() {
				return Instant.parse("1954-06-15T12:00:00.000Z");
			}
			
			@Override
			public Association<AssociationOrganization> getMember() {
				return UEFA.ASSOCIATION;
			}
		};
		public static final AssociationOrganization ORG = new AssociationOrganization() {
			
			@Override
			public Instant getFoundedDate() {
				return Instant.parse("1954-06-15T12:00:00.000Z");
			}
		};
	}
	
	
	public static final class CONMEBOL { 
		public static final Association<AssociationOrganization> ASSOCIATION = new Association<>() {
			
			@Override
			public AssociationOrganization getOrganization() {
				return CONMEBOL.ORG;
			}
			
			@Override
			public String getName() {
				return "Confederación Sudamericana de Fútbol";
			}
			
			@Override
			public Set<Membership<?>> getMemberships() {
				return Set.of(); // todo CBF...
			}

			@Override
			public String getAcronym() {
				return "CONMEBOL";
			}
		};
		public static final AssociationMembership MEMBER = new AssociationMembership() {
			
			@Override
			public Instant getSince() {
				return Instant.parse("1916-07-09T12:00:00.000Z");
			}
			
			@Override
			public Association<AssociationOrganization> getMember() {
				return CONMEBOL.ASSOCIATION;
			}
		};
		public static final AssociationOrganization ORG = new AssociationOrganization() {
			
			@Override
			public Instant getFoundedDate() {
				return Instant.parse("1916-07-09T12:00:00.000Z");
			}
		};
	}
	
	public static final class DFB { 
		public static final Association<AssociationOrganization> ASSOCIATION = new Association<>() {
			
			@Override
			public AssociationOrganization getOrganization() {
				return DFB.ORG;
			}
			
			@Override
			public String getName() {
				return "Deutscher Fussball Bund";
			}
			
			@Override
			public Set<Membership<?>> getMemberships() {
				return Set.of(BAYERN_MUENCHEN.MEMBER_DFB);
			}

			@Override
			public String getAcronym() {
				return "DFB";
			}
		};
		
		public static final AssociationMembership MEMBER_UEFA = new AssociationMembership() {
			
			@Override
			public Instant getSince() {
				return Instant.parse("1954-06-15T12:00:00.000Z");
			}
			
			@Override
			public Association<AssociationOrganization> getMember() {
				return DFB.ASSOCIATION;
			}
		};
		public static final AssociationOrganization ORG = new AssociationOrganization() {
			
			@Override
			public Instant getFoundedDate() {
				return Instant.parse("1900-01-28T12:00:00.000Z"); 
			}
		};
	}
	
	public static final class BAYERN_MUENCHEN {
		public static final AssociatedClub CLUB = new AssociatedClub() {
			
			@Override
			public String getAcronym() {
				return "FCB";
			}
			
			@Override
			public String getName() {
				return "FC Bayern München";
			}
		};
		public static final ClubMembership MEMBER_DFB = new ClubMembership() {
			@Override
			public AssociatedClub getMember() {
				return BAYERN_MUENCHEN.CLUB;
			}
		};
	}
}
