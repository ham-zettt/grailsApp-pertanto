package penjualan

import grails.gorm.services.Service

@Service(Transaksi)
interface TransaksiService {

    Transaksi get(Serializable id)

    List<Transaksi> list(Map args)

    Long count()

    void delete(Serializable id)

    Transaksi save(Transaksi transaksi)

}