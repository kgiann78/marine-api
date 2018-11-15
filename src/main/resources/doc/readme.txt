Java Marine API - README
Version @VERSION@ (b@BUILD_ID@)
<http://ktuukkan.github.io/marine-api/>

Java Marine API is an NMEA-0183 library for decoding and encoding the data
provided by various electronic marine instruments such as GPS, echo sounder and
weather instruments.

SYSTEM REQUIREMENTS

 * Java 2 SE JRE/JDK (1.8+ recommended)

 For serial port communication (choose one):

 * Java Communications API
   <http://www.oracle.com/technetwork/java/index-jsp-141752.html>

 * RXTX library
   <http://rxtx.qbang.org/>

 * Neuron Robotics Java Serial Library
   <http://code.google.com/p/nrjavaserial/>

 * PureJavaComm
   <http://www.sparetimelabs.com/purejavacomm/>

LICENSING

Java Marine API is free software: you can redistribute it and/or modify it
under the terms of the GNU Lesser General Public License as published by the
Free Software Foundation, either version 3 of the License, or (at your
option) any later version.

Java Marine API is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
for more details.

You should have received a copy of the GNU Lesser General Public License
along with Java Marine API. If not, see <http://www.gnu.org/licenses/>.

DISCLAIMER

Java Marine API is not official NMEA software. Further, it is not related to
National Marine Electronics Association <http://www.nmea.org/>. The decoding of
NMEA-0183 sentences is based entirely on publicly available resources in the
Internet. Thus, it is NOT guaranteed that the library would follow and implement
the standard accurately and correctly.

SOURCE CODE

The source code is maintained in Github <http://www.github.com>.

Browse code at Github.com:
<https://github.com/ktuukkan/marine-api>

Repository URL (read-only):
<git://github.com/ktuukkan/marine-api.git>

If you wish to contribute new features or bug fixes, please fork and send pull
requests in Github.

DEVELOPERS

* Kimmo Tuukkanen <kimmo.tuukkanen@gmail.com>

REFERENCES

All technical information and specifications have been gathered from the
following documents found publicly available in the Internet. The availability
has been last checked on 2018-11-10.

 * NMEA 0183 article in Wikipedia
   <http://en.wikipedia.org/wiki/NMEA_0183>

 * Manufacturer Mnemonic Codes and Sentence Formatters List (August 1 2013) by NMEA.org
   <https://www.nmea.org/Assets/20130801%200183%20identifier%20list.pdf>

 * Approved 0183 Manufacturer's Mnemonic Codes (November 22, 2011) by NMEA.org
   <https://www.nmea.org/Assets/20160523%200183%20manufacturer%20codes.pdf>

 * Amendment to NMEA0183 Version 4.10 # AT 0183 20130815 Version 2 by NMEA.org
   <https://www.nmea.org/Assets/20131028%200183%20safetynet%20%20v.2%20amendment%20version%204.10%20.pdf>

 * Amendment to NMEA 0183 Version 4.10 # AT 0183 20130814 by NMEA.org
   <https://www.nmea.org/Assets/21030814%20nmea%200183_man%20overboard%20notification_mob_sentence%20amendment.pdf>

 * Amendment to NMEA0183 Version 4.10 # AT 0183 20131216 by NMEA.org
   <https://www.nmea.org/Assets/20131216%200183%20epv_spw_trl%20amendment%20version%204.10.pdf>

 * NMEA 0183 Sentences Not Recommended for New Designs by NMEA.org
   <http://www.nmea.org/Assets/100108_nmea_0183_sentences_not_recommended_for_new_designs.pdf>

 * NMEA International Conference & Expo - Standards Update October 2014 by Steve Spitzer
   <http://www.nmea.org/Assets/20141004%20nmea%20standards%20update%20for%202014%20conference.pdf>

 * Automatic Identification System Overview by Navigation Center of U.S. Department of Homeland Security
   <http://www.navcen.uscg.gov/?pageName=AISMessages>

 * SiRF NMEA Reference Manual (Rev. 2.1, Dec 2007) by SiRF Technology, Inc.
   <https://www.sparkfun.com/datasheets/GPS/NMEA%20Reference%20Manual-Rev2.1-Dec07.pdf>

 * Hydromagic NMEA 0183 documentation by Eye4Software
   <https://www.eye4software.com/hydromagic/documentation/nmea0183/>

 * The NMEA Information Sheet (issue 4, July 2017) by Actisense
   <https://www.actisense.com/wp-content/uploads/2017/07/NMEA-0183-Information-sheet-issue-4-1-1.pdf>

 * PB100 WeatherStation Technical Manual by Airmar
   <http://www.airmartechnology.com/uploads/installguide/PB100TechnicalManual_rev1.007.pdf>

 * BD9xx GNSS Receivers Help by Trimble Navigation Limited
   <http://www.trimble.com/OEM_ReceiverHelp/V4.44/en/>

 * NMEA-0183 Messages - Guide for AgGPS Receivers by Trimble Navigation Limited
   <http://trl.trimble.com/docushare/dsweb/Get/Document-159714/NMEA_Messages_RevA_Guide_ENG.pdf>

 * NM-2C User's Guide/Installation Manual v1.0 by Nuova Marea Ltd
   <http://www.nuovamarea.com/files/product%20manuals/nm%20manuals/NM-2C_v1.00.pdf>

 * SeaTalk <-> NMEA / SeaTalk <-> RS232 Converter installation and operation manual by gadgetPool
   <https://community.atmel.com/sites/default/files/project_files/ManualV3-5.pdf>

 * NMEA Revealed by Eric S. Raymond
   <http://catb.org/gpsd/NMEA.html>

 * AIVDM/AIVDO protocol decoding (v1.52, Aug 2016) by Eric S. Raymond
   <http://catb.org/gpsd/AIVDM.html>

 * NMEA Data by Dale DePriest
   <http://www.gpsinformation.org/dale/nmea.htm>

 * SeaTalk Technical Reference (revision 3.22) by Thomas Knauf
   <http://www.thomasknauf.de/seatalk.htm>

 Unavailable or outdated

 * The NMEA FAQ by Peter Bennett
   <http://vancouver-webpages.com/peter/nmeafaq.txt> [not found]
   <http://www.eoss.org/pubs/nmeafaq.htm> [older copy]

 * RT Intertial+ NMEA Description (rev. 100720) by Oxford Technical Solutions
   <http://www.oxts.com/Downloads/Products/Inertial2/nmeaman.pdf> [not found]

 * NMEA Sentence Information by Glenn Baddeley
   <http://home.mira.net/~gnb/gps/nmea.html> [not found]

 * Eye4Software GPS Toolkit - Description of supported NMEA0183 sentences
   <http://www.eye4software.com/products/gpstoolkit/nmea/> [not found]

 * RS232 SeaTalk <-> NMEA Converter installation and operation manual by gadgetPool
   <http://www.gadgetpool.de/nuke/downloads/ManualRS232.pdf> [not found]

All warnings concerning the accuracy of information in the above documents apply
equally to Java Marine API.
