package net.sf.marineapi.nmea.util;

/**
 * Defines the radar display rotation, e.g. "course-up", "head-up" and "north-up".
 *
 * @author Thomas Chavakis
 */
public enum Rotation {

    /**Course-up, Course over ground, degrees true*/
    COURSE_UP('C'),

    /**Head-up, ship's heading (centre-line) 0 degrees up*/
    HEAD_UP('H'),

    /**North-up, True north is 0 degrees up*/
    NORTH_UP('N');


    private char ch;

    private Rotation(char c) {
        ch = c;
    }

    /**
     * Returns the corresponding char constant.
     *
     * @return Char indicator for Direction
     */
    public char toChar() {
        return ch;
    }


    /**
     * Get the enum corresponding to specified char.
     *
     * @param c Char indicator for Direction
     * @return Direction
     */
    public static Rotation valueOf(char c) {
        for (Rotation d : values()) {
            if (d.toChar() == c) {
                return d;
            }
        }
        return valueOf(String.valueOf(c));
    }


}
