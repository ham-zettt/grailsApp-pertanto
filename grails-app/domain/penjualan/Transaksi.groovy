package penjualan

class Transaksi {
    String id_transaksi
    String id_barang
    String id_pembeli
    String keterangan
    Date tanggal
    static belongsTo = [barang:Barang, pembayaran:Pembayaran, pembeli:Pembeli]
    
    static constraints = {
        
    }
}
