package penjualan

import grails.gorm.services.Service

@Service(Barang)
interface BarangService {

    Barang get(Serializable id)

    List<Barang> list(Map args)

    Long count()

    void delete(Serializable id)

    Barang save(Barang barang)

}