SUMMARY = "Merge machine and distro options to create a enigma2 machine task/package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "1.0"
PR = "r1"

inherit packagegroup

DEPENDS = "enigma2-pliplugins opendroid-feeds"

RRECOMMENDS_${PN} = " \
    enigma2-skindefault \
    opendroid-version-info \
    enigma2-plugin-drivers-usbserial \
    enigma2-plugin-extensions-infopanel \
    enigma2-plugin-extensions-addonopendroid \
    enigma2-plugin-extensions-autosettings \
    enigma2-plugin-extensions-autotimer \
    enigma2-plugin-extensions-epgsearch \
    enigma2-plugin-extensions-imdb \
    enigma2-plugin-extensions-cutlisteditor \
    enigma2-plugin-extensions-dvdplayer \
    enigma2-plugin-extensions-volume-adjust \
    enigma2-plugin-systemplugins-videotune \
    ${@base_contains("MACHINE_FEATURES", "videoenhancement", "", "enigma2-plugin-systemplugins-videoenhancement", d)} \
    enigma2-plugin-systemplugins-softwaremanager \
    enigma2-plugin-systemplugins-hotplug \
    enigma2-plugin-extensions-mediaplayer \
    enigma2-plugin-extensions-enhancedmoviecenter \
    enigma2-plugin-extensions-supportchannel \	
    ${@base_contains("MACHINE_FEATURES", "dreambox", "enigma2-plugin-extensions-dflash mtd-utils-jffs2", "", d)} \
    ${@base_contains("MACHINE_FEATURES", "boxmodel", "boxmodel", "", d)} \
    "
	
RRECOMMENDS_${PN}_append_gb800solo = ""
RRECOMMENDS_${PN}_append_gb800se = ""
RRECOMMENDS_${PN}_append_gb800ue = ""
RRECOMMENDS_${PN}_append_gbquad = ""
RRECOMMENDS_${PN}_append_dags1 = ""
RRECOMMENDS_${PN}_append_dags2 = ""
RRECOMMENDS_${PN}_append_dags3 = ""
RRECOMMENDS_${PN}_append_ixussone = ""
RRECOMMENDS_${PN}_append_vuduo = "" 
RRECOMMENDS_${PN}_append_vusolo = "" 
RRECOMMENDS_${PN}_append_vusolo2 = "" 
RRECOMMENDS_${PN}_append_et9x00 = "" 
RRECOMMENDS_${PN}_append_et6x00 = "" 
RRECOMMENDS_${PN}_append_et5x00 = "" 
RRECOMMENDS_${PN}_append_et4x00 = "" 

