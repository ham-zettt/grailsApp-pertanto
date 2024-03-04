package penjualan

class Pembeli {
    String id_pembeli
    String nama_pembeli
    String no_telp
    String alamat
    static hasMany =[transaksi:Transaksi]
    
    static constraints = {
    }
}
