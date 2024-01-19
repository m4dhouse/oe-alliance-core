require recipes-mediacenter/kodi/stb-kodi_${PV}.bb

SRC_URI:append = "file://hiplayer_21_opt.patch"

DEPENDS += "anadol-libs-${MACHINE}"
PROVIDES += "virtual/kodi"
RPROVIDES:${PN} += "virtual-kodi"
PROVIDES += "kodi"
RPROVIDES:${PN} += "kodi"

RDEPENDS:${PN} += "anadol-libs-${MACHINE}"
RDEPENDS:${PN} += "anadol-opengl-${SOC_FAMILY}"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=clap-cortexa15 \
    -DWITH_FFMPEG=stb \
"
