package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.sentence.RSDSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.Rotation;
import net.sf.marineapi.nmea.util.Units;

/**
 *
 * Author: Thomas Chavakis
 */

class RSDParser extends SentenceParser implements RSDSentence {


    private static final int FIELD1 = 0;
    private static final int FIELD2 = 1;
    private static final int FIELD3 = 2;
    private static final int FIELD4 = 3;
    private static final int FIELD5 = 4;
    private static final int FIELD6 = 5;
    private static final int FIELD7 = 6;
    private static final int FIELD8 = 7;
    private static final int CURSOR_RANGE = 8;
    private static final int CURSOR_BEARING = 9;
    private static final int RANGE_SCALE = 10;
    private static final int RANGE_UNITS = 11;
    private static final int DISPLAY_ROTATION = 12;


    /**
     * Creates a new instance of RSDParser
     * @param nmea RSD Sentence
     * @throws IllegalArgumentException If specified sentence is invalid.
     */
    public RSDParser(String nmea) {
        super(nmea, SentenceId.RSD);
    }

    /**
     * Creates a RSDParser with empty sentence
     * @param talker TalkerId to Set
     */
    public RSDParser(TalkerId talker) {
        super(talker, SentenceId.RSD, 13);
    }

    @Override
    public double getField1() {
        return getDoubleValue(FIELD1);
    }

    @Override
    public double getField2() {
        return getDoubleValue(FIELD2);
    }

    @Override
    public double getField3() {
        return getDoubleValue(FIELD3);
    }

    @Override
    public double getField4() {
        return getDoubleValue(FIELD4);
    }

    @Override
    public double getField5() {
        return getDoubleValue(FIELD5);
    }

    @Override
    public double getField6() {
        return getDoubleValue(FIELD6);
    }

    @Override
    public double getField7() {
        return getDoubleValue(FIELD7);
    }

    @Override
    public double getField8() {
        return getDoubleValue(FIELD8);
    }

    @Override
    public double getCursorRange() {
        return getDoubleValue(CURSOR_RANGE);
    }

    @Override
    public double getCursorBearing() {
        return getDoubleValue(CURSOR_BEARING);
    }

    @Override
    public double getRangeScale() {
        return getDoubleValue(RANGE_SCALE);
    }

    @Override
    public Units getRangeUnits() {
         return Units.valueOf(getCharValue(RANGE_UNITS));
    }

    @Override
    public Rotation getDisplayRotation() {
        return Rotation.valueOf(getCharValue(DISPLAY_ROTATION));
    }

    @Override
    public void setField1(double field1) {
        setDoubleValue(FIELD1,field1,1,1);
    }

    @Override
    public void setField2(double field2) {
        setDoubleValue(FIELD2,field2,1,1);
    }

    @Override
    public void setField3(double field3) {
        setDoubleValue(FIELD3,field3,1,1);
    }

    @Override
    public void setField4(double field4) {
        setDoubleValue(FIELD4,field4,1,1);
    }

    @Override
    public void setField5(double field5) {
        setDoubleValue(FIELD5,field5,1,1);
    }

    @Override
    public void setField6(double field6) {
        setDoubleValue(FIELD6,field6,1,1);
    }

    @Override
    public void setField7(double field7) {
        setDoubleValue(FIELD7,field7,1,1);
    }

    @Override
    public void setField8(double field8) {
        setDoubleValue(FIELD8,field8,1,1);
    }

    @Override
    public void setCursorRange(double cursorRange) {
        setDoubleValue(CURSOR_RANGE,cursorRange,1,1);
    }

    @Override
    public void setCursorBearing(double cursorBearing) {
        setDoubleValue(CURSOR_BEARING,cursorBearing,1,1);
    }

    @Override
    public void setRangeScale(double rangeScale) {
        setDoubleValue(RANGE_SCALE,rangeScale,1,1);
    }

    @Override
    public void setRangeUnits(Units unit) {
        setCharValue(RANGE_UNITS, unit.toChar());
    }

    @Override
    public void setDisplayRotation(Rotation rotation) {
        setCharValue(DISPLAY_ROTATION, rotation.toChar());
    }


}
