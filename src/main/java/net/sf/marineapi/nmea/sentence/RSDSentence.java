package net.sf.marineapi.nmea.sentence;


import net.sf.marineapi.nmea.util.Rotation;
import net.sf.marineapi.nmea.util.Units;

/**
 * <p>RSD - Radar System Data.</p>
 *
 * <p>Example:<br/>
 *        1   2   3   4   5   6   7   8   9   10  11 12 13
 *        |   |   |   |   |   |   |   |   |   |   |   | |
 * $--RSD,x.x,x.x,x.x,x.x,x.x,x.x,x.x,x.x,x.x,x.x,x.x,a,a*hh<CR><LF>
 *
 *
 *  1) Unknown
 *  2) Unknown
 *  3) Unknown
 *  4) Unknown
 *  5) Unknown
 *  6) Unknown
 *  7) Unknown
 *  8) Unknown
 *  9) Cursor Range From Own Ship
 * 10) Cursor Bearing Degrees Clockwise From Zero
 * 11) Range Scale in units denoted by field 12
 * 12) Range Units || types:: 'K' --> Kilometers , 'N' --> Nautical Miles, 'S' --> Statute Miles
 * 13) Display Rotation Type currently selected by operator. || types:: 'C' --> Course Up, degrees true, 'H' --> Head Up , ship's heading at 0, North Up, true north at 0 degrees
 * 14) Checksum
 * @author Thomas Chavakis
 */
public interface RSDSentence extends Sentence {

    double getField1();

    double getField2();

    double getField3();

    double getField4();

    double getField5();

    double getField6();

    double getField7();

    double getField8();

    double getCursorRange();

    double getCursorBearing();

    double getRangeScale();

    Units getRangeUnits();

    Rotation getDisplayRotation();


    /**
     *
     * @param field1
     */
    void setField1(double field1);

    /**
     *
     * @param field2
     */
    void setField2(double field2);

    /**
     *
     * @param field3
     */
    void setField3(double field3);

    /**
     *
     * @param field4
     */
    void setField4(double field4);

    /**
     *
     * @param field5
     */
    void setField5(double field5);

    /**
     *
     * @param field6
     */
    void setField6(double field6);

    /**
     *
     * @param field7
     */
    void setField7(double field7);

    /**
     *
     * @param field8
     */
    void setField8(double field8);

    /**
     * Set the Cursor Range
     * @param cursorRange from own shup
     */
    void setCursorRange(double cursorRange);

    /**
     * Set the Cursor Bearing
     * @param cursorBearing degrees from 0 degrees up to 359.9
     */
    void setCursorBearing(double cursorBearing);

    /**
     * Set the Range Scale
     * @param rangeScale in use 0.125 to 96.0 nm (RACAL)
     */
    void setRangeScale(double rangeScale);

    /**
     * Set the Range Units
     * @param unit the unit of measure , K --> Kilometers, N --> Nautical Miles
     */
    void setRangeUnits(Units unit);

    /**
     * Set the Display Rotation
     * @param rotation , C--> Course Up, H --> Head-up, N --> North up
     */
    void setDisplayRotation(Rotation rotation);



}
