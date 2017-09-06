/*
 * TTMSentence.java
 * Copyright (C) 2014 Johan Bergkvist
 *
 * This file is part of Java Marine API.
 * <http://ktuukkan.github.io/marine-api/>
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
package net.sf.marineapi.nmea.sentence;

import net.sf.marineapi.nmea.util.AcquisitionType;
import net.sf.marineapi.nmea.util.TargetStatus;
import net.sf.marineapi.nmea.util.Units;

/**
 * Tracked Target Message. Range and bearing from radar to target. Course and
 * speed of target. One message per target.
 * <p>
 * Example:<br>
 * <code>$RATTM,11,11.4,13.6,T,7.0,20.0,T,0.0,0.0,N,,Q,,154125.82,A,*17</code>
 *
 * 	OSD - Own Ship Data
            1   2 3   4 5   6 7   8   9
            |   | |   | |   | |   |   |
     $--OSD,x.x,A,x.x,a,x.x,a,x.x,x.x,a*hh<CR><LF>

	 Field Number:
	 1. Heading, degrees true
	 2. Status
		- A = Data Valid
		- V = Invalid
	 3. Vessel Course, degrees True
	 4. Course Reference
		 - T = True
	 5. Vessel Speed
	 6. Speed Unit
	 7. Vessel Set, degrees True
	 8. Vessel drift (speed)
	 9. Speed Units

 * @author Konstantinos Giannousis
 */
public interface OSDSentence extends Sentence {

	/**
	 * Get the degrees of the heading to the true North.
	 *
	 * @return Degrees of target to true North.
	 * @throws net.sf.marineapi.nmea.parser.DataNotAvailableException
	 *             If the data is not available.
	 */
	double getHeading();

    /**
     * Get the status of the target.
     * A = Data Valid
     * V = Invalid
     *
     * When the heading status is invalid, null fields shall be transmitted for all
     * fields based on reference systems B, M, W and R because they are based on ships's heading
     * @return The state (A or V)
     */
    String getStatus();

    /**
     * Get the course the target is maintaining.
     *
     * @return True course in degrees.
     */
    double getCourse();

    /**
     * Get the course reference (B, M, W, R or P)
     *
     * The course reference field indicate the reference system on which the calculation
     * of vessel's course is based. The same reference system is used for both the course
     * and speed. This is dependent upon the speed mode selected by the operator.
     * B = bottom tracking log
     * M = manually entered
     * W = Water tracking log
     * R = Radar tracking (stationary target)
     * P = Positioning system ground referenced
     *
     * @return The course reference
     */
    String getCourseReference();

    /**
     * Get the speed the target.
     *
     * @return Speed in kts (nautical miles per hour).
     */
    double getSpeed();

    /**
     * Get the speed reference (B, M, W, R or P)
     *
     * The speed reference field indicate the reference system on which the calculation
     * of vessel's course is based. The same reference system is used for both the course
     * and speed. This is dependent upon the speed mode selected by the operator.
     * B = bottom tracking log
     * M = manually entered
     * W = Water tracking log
     * R = Radar tracking (stationary target)
     * P = Positioning system ground referenced
     *
     * @return The speed reference
     */
    String getSpeedReference();

    /**
     * Get the vessel set.
     * @return The vessel set.
     */
    double getSet();

    /**
     * Get vessel drift.
     * @return The vessel drift.
     */
    double getDrift();

    /**
     * Get the unit of measure used for distance and speeds.
     *
     * @return The unit of measure.
     */
    Units getUnits();


    /**
     * Set the degrees of the heading to the true North.
     *
     * @param heading of target to true North.
     *                Heading in degrees
     */
    void setHeading(double heading);

    /**
     * Set the Status of the target.
     *
     * @see OSDSentence#getStatus()
     * @param status
     *            The status
     */
    void setStatus(String status);


    /**
     * Set the course of the target.
     *
     * @param course
     *            True course in degrees.
     */
    void setCourse(double course);

    /**
     * Set the course reference of the target.
     *
     * @param reference
     *            Course reference.
     */
    void setCourseReference(String reference);


    /**
     * Set the speed of the target.
     *
     * @param speed
     *            Speed in kts (nautical miles per hour).
     */
    void setSpeed(double speed);

    /**
     * Set the speed reference of the target.
     *
     * @param reference
     *            Speed reference.
     */
    void setSpeedReference(String reference);


    /**
     * Set the vessel set.
     * @param set The vessel set.
     */
     void setSet(double set);

    /**
     * Set vessel drift.
     * @param drift The vessel drift.
     */
    void setDrift(double drift);
}
