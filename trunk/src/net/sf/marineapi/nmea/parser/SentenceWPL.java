/* 
 * SentenceWPL.java
 * Copyright (C) 2010 Kimmo Tuukkanen
 * 
 * This file is part of Java Marine API.
 * <http://sourceforge.net/projects/marineapi/>
 * 
 * Java Marine API is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Java Marine API is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java Marine API. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.util.Direction;
import net.sf.marineapi.nmea.util.SentenceId;
import net.sf.marineapi.nmea.util.Waypoint;

/**
 * WPL sentence parser. Waypoint location (latitude/longitude) and waypoint ID.
 * This sentence is transmitted by some GPS models in GOTO mode.
 * <p>
 * Example: <br>
 * <code>$GPWPL,5536.200,N,01436.500,E,RUSKI*1F</code>
 * 
 * @author Kimmo Tuukkanen
 * @version $Revision$
 */
public class SentenceWPL extends PositionParser {

    // field ids
    private static final int LATITUDE = 1;
    private static final int LAT_HEMISPHERE = 2;
    private static final int LONGITUDE = 3;
    private static final int LON_HEMISPHERE = 4;
    private static final int WAYPOINT_ID = 5;

    /**
     * Constructor.
     * 
     * @param nmea WPL sentence String.
     * @throws IllegalArgumentException
     */
    public SentenceWPL(String nmea) {
        super(nmea, SentenceId.WPL);
    }

    /**
     * Get the destination waypoint.
     * 
     * @return waypoint object
     */
    public Waypoint getWaypoint() {
        String id = getStringValue(WAYPOINT_ID);
        double lat = parseLatitude(LATITUDE);
        double lon = parseLongitude(LONGITUDE);
        Direction lath = parseHemisphereLat(LAT_HEMISPHERE);
        Direction lonh = parseHemisphereLon(LON_HEMISPHERE);
        return new Waypoint(id, lat, lath, lon, lonh);
    }
}
