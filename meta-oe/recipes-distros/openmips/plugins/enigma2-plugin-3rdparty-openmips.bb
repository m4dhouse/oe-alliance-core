SUMMARY = "3rd Party plugins for openMips"
MAINTAINER = "openMips Team"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=8e37f34d0e40d32ea2bc90ee812c9131"

inherit gitpkgv autotools deploy

SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"
SRC_URI="git://github.com/openmips/openMips-3rdpart.git;protocol=git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-boxtype=${MACHINEBUILD} \
"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

DEPENDS = "enigma2"

# THIRDPARTY_MACHINE_PLUGINS_machine = " \
#     enigma2-plugin-extensions-....ipk \
#     "


do_install() {
}

do_deploy() {
    install -d 0755 ${DEPLOY_DIR_IPK}/3rdparty
    install -d 0755 ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty
    install -m 0644 ${S}/*all.ipk ${DEPLOY_DIR_IPK}/3rdparty #|| true
    install -m 0644 ${S}/*mipsel.ipk ${DEPLOY_DIR_IPK}/3rdparty #|| true
    install -m 0644 ${S}/*mips32el.ipk ${DEPLOY_DIR_IPK}/3rdparty #|| true

#    rm -f ${DEPLOY_DIR_IPK}/3rdparty/enigma2-plugin-extensions...* || true
#    [ -e ${S}/*enigma2-plugin-extensions....ipk ] && install -m 0644 ${S}/*enigma2-plugin-extensions....ipk ${DEPLOY_DIR_IPK}/3rdparty || true
    [ -e ${S}/*${MACHINE}.ipk ] && install -m 0644 ${S}/*${MACHINE}.ipk ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty #|| true
    [ -e ${S}/*${MACHINEBUILD}.ipk ] && install -m 0644 ${S}/*${MACHINEBUILD}.ipk ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty #|| true
    for i in ${THIRDPARTY_MACHINE_PLUGINS}; do
        if [ -f $i ]; then
            install -m 0644 $i ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty || true
        fi
    done;
    for i in ${THIRDPARTY_EXTRA_PLUGINS}; do
        if [ -f $i ]; then
            install -m 0644 $i ${DEPLOY_DIR_IPK}/3rdparty || true
        fi
    done;
    pkgdir=${DEPLOY_DIR_IPK}/3rdparty
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
    pkgdir=${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
}

addtask do_deploy before do_package_write after do_package_write_ipk
