package penjualan

import grails.gorm.services.Service

@Service(Pembeli)
interface PembeliService {

    Pembeli get(Serializable id)

    List<Pembeli> list(Map args)

    Long count()

    void delete(Serializable id)

    Pembeli save(Pembeli pembeli)

}