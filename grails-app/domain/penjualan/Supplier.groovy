package penjualan

class Supplier {   
    String id_supplier
    String nama_supplier
    String no_telp
    String alamat
    static belongsTo = [barang:Barang]

    static constraints = {
    }
}
