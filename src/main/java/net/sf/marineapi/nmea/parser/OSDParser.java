/*
 * TTMParser.java
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
package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.sentence.OSDSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.Units;

/**
 * OSD sentence parser.
 *
 * @author Johan Bergkvist
 */
class OSDParser extends SentenceParser implements OSDSentence {

	/// @brief OSD - Own Ship Data
    ///
    /// @code
    ///        1   2 3   4 5   6 7   8   9
    ///        |   | |   | |   | |   |   |
    /// $--OSD,x.x,A,x.x,a,x.x,a,x.x,x.x,a*hh<CR><LF>
    /// @endcode
    ///
    /// Field Number:
    /// 1. Heading, degrees true
    /// 2. Status
    ///    - A = Data Valid
    ///    - V = Invalid
    /// 3. Vessel Course, degrees True
    /// 4. Course Reference
    ///    - T = True
    /// 5. Vessel Speed
    /// 6. Speed Unit
    /// 7. Vessel Set, degrees True
    /// 8. Vessel drift (speed)
    /// 9. Speed Units
    ///

	private static final int HEADING = 0;
	private static final int STATUS = 1;
	private static final int VESSEL_COURSE = 2;
	private static final int COURSE_REFERENCE = 3;
	private static final int VESSEL_SPEED = 4;
	private static final int SPEED_REFERENCE = 5;
	private static final int VESSEL_SET = 6;
	private static final int VESSEL_DRIFT = 7;
	private static final int UNITS = 8;

	/**
	 * Create a new instance of TTMParser.
	 *
	 * @param nmea
	 *            OSD sentence String.
	 * @throws IllegalArgumentException
	 *             If specified sentence is invalid.
	 */
	public OSDParser(String nmea) {
		super(nmea, SentenceId.OSD);
	}

	/**
	 * Create a TTM parser with an empty sentence.
	 *
	 * @param talker
	 *            TalkerId to set
	 */
	public OSDParser(TalkerId talker) {
		super(talker, SentenceId.OSD, 9);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.sf.marineapi.nmea.sentence.OSDSentence#getHeading()
	 */
	@Override
	public double getHeading() {
		return getDoubleValue(HEADING);
	}


	@Override
	public void setHeading(double heading) {
		setDoubleValue(HEADING, heading);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.sf.marineapi.nmea.sentence.TTMSentence#getStatus()
	 */
	@Override
	public String getStatus() {
		return getStringValue(getCharValue(STATUS));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.sf.marineapi.nmea.sentence.TTMSentence#setStatus()
	 */
	@Override
	public void setStatus(String status) {
		setStringValue(STATUS, status);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.sf.marineapi.nmea.sentence.OSDSentence#getCourse()
	 */
	@Override
	public double getCourse() {
		return getDoubleValue(VESSEL_COURSE);
	}

    /*
     * (non-Javadoc)
     *
     * @see net.sf.marineapi.nmea.sentence.TTMSentence#setCourse()
     */
    @Override
    public void setCourse(double course) {
        setDoubleValue(VESSEL_COURSE, course, 1, 1);
//        setCharValue(UNITS, 'T');
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.marineapi.nmea.sentence.OSDSentence#getCourseReference()
     */
    @Override
    public String getCourseReference() {
        return getStringValue(COURSE_REFERENCE);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.marineapi.nmea.sentence.TTMSentence#setCourseReference()
     */
    @Override
    public void setCourseReference(String reference) {
        setStringValue(COURSE_REFERENCE, reference);
    }

	/*
	 * (non-Javadoc)
	 *
	 * @see net.sf.marineapi.nmea.sentence.OSDSentence#getSpeed()
	 */
	@Override
	public double getSpeed() {
		return getDoubleValue(VESSEL_SPEED);
	}

    /*
     * (non-Javadoc)
     *
     * @see net.sf.marineapi.nmea.sentence.OSDSentence#setSpeed()
     */
    @Override
    public void setSpeed(double speed) {
        setDoubleValue(VESSEL_SPEED, speed, 1, 1);
        setCharValue(UNITS, 'N');
    }

	@Override
	public String getSpeedReference() {
		return getStringValue(SPEED_REFERENCE);
	}

    @Override
    public void setSpeedReference(String reference) {
        setStringValue(SPEED_REFERENCE, reference);
    }

	@Override
	public double getSet() {
		return getDoubleValue(VESSEL_SET);
	}

    @Override
    public void setSet(double set) {
        setDoubleValue(VESSEL_SET, set);
    }

	@Override
	public double getDrift() {
		return getDoubleValue(VESSEL_DRIFT);
	}

    @Override
    public void setDrift(double drift) {
        setDoubleValue(VESSEL_DRIFT, drift);
    }

	/*
	 * (non-Javadoc)
	 *
	 * @see net.sf.marineapi.nmea.sentence.OSDSentence#getUnits()
	 */
	@Override
	public Units getUnits() {
		return Units.valueOf(getCharValue(UNITS));
	}
}
