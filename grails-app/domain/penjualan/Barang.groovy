package penjualan

class Barang {
    String id_barang
    String nama_barang
    String id_supplier
    int harga
    int stok
    static hasMany = [transaksi:Transaksi, supplier:Supplier]
    
    static constraints = {
    }
}