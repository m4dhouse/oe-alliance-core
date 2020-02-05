FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://hwmac"

do_install_append() {
    install -d ${D}${sysconfdir}/network/if-pre-up.d
    install -m 755 ${WORKDIR}/hwmac ${D}${sysconfdir}/network/if-pre-up.d/hwmac
}

