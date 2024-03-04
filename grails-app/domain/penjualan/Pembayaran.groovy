package penjualan

class Pembayaran {
    String id_pembayaran
    Date tgl_bayar
    int total_bayar
    String id_transaksi
    static hasMany = [transaksi:Transaksi]
    
    static constraints = {
    }
}
