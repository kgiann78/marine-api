package net.sf.marineapi.nmea.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.GregorianCalendar;

import net.sf.marineapi.nmea.util.DataStatus;
import net.sf.marineapi.nmea.util.Direction;
import net.sf.marineapi.nmea.util.GpsMode;
import net.sf.marineapi.nmea.util.Position;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the RMC sentence parser.
 * 
 * @author Kimmo Tuukkanen
 */
public class SentenceRMCTest {

    /** Example sentence */
    public static final String EXAMPLE = "$GPRMC,120044,A,6011.552,N,02501.941,E,000.0,360.0,160705,006.1,E,A*11";

    SentenceRMC rmc;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        try {
            rmc = new SentenceRMC(EXAMPLE);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getDataStatus()}.
     */
    @Test
    public void testGetDataStatus() {
        assertEquals(DataStatus.INVALID, rmc.getDataStatus());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getGpsMode()}.
     */
    @Test
    public void testGetGpsMode() {
        assertEquals(GpsMode.AUTOMATIC, rmc.getGpsMode());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getSpeed()} .
     */
    @Test
    public void testGetSpeedOverGround() {
        assertTrue(0.0 == rmc.getSpeed());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getCourse()} .
     */
    @Test
    public void testGetCourseOverGround() {
        assertTrue(360.0 == rmc.getCourse());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getVariation()} .
     */
    @Test
    public void testGetMagneticVariation() {
        assertTrue(-6.1 == rmc.getVariation());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getDirectionOfVariation()}
     * .
     */
    @Test
    public void testGetDirectionOfVariation() {
        assertEquals(Direction.EAST, rmc.getDirectionOfVariation());
        assertTrue(rmc.getVariation() < 0);
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getPosition()}.
     */
    @Test
    public void testGetPosition() {
        final double lat = 60 + (11.552 / 60);
        final double lon = 25 + (1.941 / 60);

        Position p = rmc.getPosition();
        assertNotNull(p);
        assertTrue(lat == p.getLatitude());
        assertTrue(lon == p.getLongitude());
        assertEquals(Direction.NORTH, p.getLatHemisphere());
        assertEquals(Direction.EAST, p.getLonHemisphere());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getUtcTime()}.
     */
    @Test
    public void testGetUtcTime() {
        assertEquals("120044", rmc.getUtcTime());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getUtcHours()}.
     */
    @Test
    public void testGetUtcHours() {
        assertTrue(12 == rmc.getUtcHours());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getUtcMinutes()}.
     */
    @Test
    public void testGetUtcMinutes() {
        assertTrue(0 == rmc.getUtcMinutes());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getUtcSeconds()}.
     */
    @Test
    public void testGetUtcSeconds() {
        assertTrue(44 == rmc.getUtcSeconds());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getUtcDay()}.
     */
    @Test
    public void testGetUtcDay() {
        assertTrue(16 == rmc.getUtcDay());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getUtcMonth()}.
     */
    @Test
    public void testGetUtcMonth() {
        assertTrue(7 == rmc.getUtcMonth());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getUtcYear()}.
     */
    @Test
    public void testGetUtcYear() {
        assertTrue(2005 == rmc.getUtcYear());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.SentenceRMC#getDate()}.
     */
    @Test
    public void testGetDate() {

        GregorianCalendar cal = new GregorianCalendar(2005, 6, 16, 12, 0, 44);
        final Date expected = cal.getTime();
        Date parsed = rmc.getDate();

        assertEquals(expected, parsed);
        assertTrue(expected.getTime() == parsed.getTime());
    }

}
