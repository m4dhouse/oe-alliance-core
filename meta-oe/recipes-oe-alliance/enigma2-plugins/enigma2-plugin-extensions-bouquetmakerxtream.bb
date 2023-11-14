SUMMARY = "IPTV bouquet maker"
DESCRIPTION = "Bouquet Maker Xtream"
HOMEPAGE = "https://github.com/kiddac/Bouquet_Maker_Xtream"
MAINTAINER = "kiddac"
PRIORITY = "optional"

require conf/license/license-gplv2.inc
require conf/python/python3-compileall.inc

RDEPENDS:${PN} += "${PYTHON_PN}-backports-lzma"

SRCREV="${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "${GITPKGVTAG}"
PR = "r2"

inherit gittag allarch

SRC_URI = "git://github.com/kiddac/Bouquet_Maker_Xtream.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

FILES:${PN} = " ${sysconfdir}/enigma2/bouquetmakerxtream/playlists.txt \
                ${libdir}/enigma2/python/Plugins/Extensions/BouquetMakerXtream \
                ${libdir}/enigma2/python/Components/Renderer"

CONFFILES:${PN} = "${sysconfdir}/enigma2/bouquetmakerxtream/playlists.txt"

do_install() {
    install -d ${D}${sysconfdir}/enigma2/bouquetmakerxtream
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/BouquetMakerXtream
    install -d ${D}${libdir}/enigma2/python/Components/Renderer ${D}${libdir}/enigma2/python/Components/Renderer
    cp -f ${S}/BouquetMakerXtream/usr/lib/enigma2/python/Plugins/Extensions/BouquetMakerXtream/playlists/playlists.txt ${D}${sysconfdir}/enigma2/bouquetmakerxtream/playlists.txt
    cp -rf ${S}/BouquetMakerXtream/usr/lib/enigma2/python/Plugins/Extensions/BouquetMakerXtream/* ${D}${libdir}/enigma2/python/Plugins/Extensions/BouquetMakerXtream
    cp -rf ${S}/BouquetMakerXtream/usr/lib/enigma2/python/Components/Renderer/* ${D}${libdir}/enigma2/python/Components/Renderer
}
