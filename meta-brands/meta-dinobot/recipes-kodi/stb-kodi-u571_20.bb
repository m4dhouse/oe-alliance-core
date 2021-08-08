require recipes-mediacenter/kodi/stb-kodi_${PV}.bb

PROVIDES += "virtual/kodi"
RPROVIDES:${PN} += "virtual/kodi"
PROVIDES += "kodi"
RPROVIDES:${PN} += "kodi"
RDEPENDS:${PN} += "dinobot-opengl-${SOC_FAMILY}"

SRC_URI:append = " file://eglwrapper-20.patch "
do_configure:prepend() {
    [ -e ${WORKDIR}/recipe-sysroot/lib/libm.so ] && rm ${WORKDIR}/recipe-sysroot/lib/libm.so;
    ln -sf ${WORKDIR}/recipe-sysroot/lib/libm-2.28.so ${WORKDIR}/recipe-sysroot/lib/libm.so
}

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=mali-cortexa15 \
    -DWITH_FFMPEG=stb \
"

