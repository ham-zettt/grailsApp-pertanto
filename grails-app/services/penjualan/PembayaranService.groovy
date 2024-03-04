package penjualan

import grails.gorm.services.Service

@Service(Pembayaran)
interface PembayaranService {

    Pembayaran get(Serializable id)

    List<Pembayaran> list(Map args)

    Long count()

    void delete(Serializable id)

    Pembayaran save(Pembayaran pembayaran)

}