SUMMARY = "Stalker for QT browser"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
require conf/license/license-close.inc
PACKAGE_ARCH := "${MACHINE_ARCH}"

inherit gitpkgv

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"
SRCREV = "${AUTOREV}"
PR = "r2"
VER ?= ""

SRC_URI = "git://github.com/oe-alliance/e2plugins.git;protocol=https;branch=python3"

RDEPENDS:${PN}  = "qtwebkit ${PYTHON_PN}-netifaces" 

S = "${WORKDIR}/git/qtstalker${VER}"

FILES:${PN} =  "${bindir} ${libdir} /usr/share/stalker"

do_install(){
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/Stalker
	install -m 0755 ${S}/plugin/*.py ${D}${libdir}/enigma2/python/Plugins/Extensions/Stalker
	install -m 0755 ${S}/plugin/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/Stalker

	install -d ${D}/${bindir}
	install -m 0755 ${S}/stalker* ${D}/${bindir}

	cp -rp ${S}/plugin/locale ${D}${libdir}/enigma2/python/Plugins/Extensions/Stalker

	install -d ${D}/usr/share/stalker
	cp -rp ${S}/usr/share/stalker/* ${D}/usr/share/stalker/
	chmod -R a+rX ${D}/usr/share/stalker/
}

pkg_postinst_ontarget:${PN}(){
#!/bin/sh
ln -sf /usr/share/fonts /usr/lib/fonts
exit 0
}

pkg_postrm:${PN} () {
#!/bin/sh
rm -rf /usr/lib/enigma2/python/Plugins/Extensions/Stalker
exit 0
}

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
do_package_qa[noexec] = "1"

INSANE_SKIP:${PN} += "already-stripped"
