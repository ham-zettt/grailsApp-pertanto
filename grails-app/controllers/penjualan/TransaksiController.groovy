package penjualan

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TransaksiController {

    TransaksiService transaksiService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond transaksiService.list(params), model:[transaksiCount: transaksiService.count()]
    }

    def show(Long id) {
        respond transaksiService.get(id)
    }

    def create() {
        respond new Transaksi(params)
    }

    def save(Transaksi transaksi) {
        if (transaksi == null) {
            notFound()
            return
        }

        try {
            transaksiService.save(transaksi)
        } catch (ValidationException e) {
            respond transaksi.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'transaksi.label', default: 'Transaksi'), transaksi.id])
                redirect transaksi
            }
            '*' { respond transaksi, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond transaksiService.get(id)
    }

    def update(Transaksi transaksi) {
        if (transaksi == null) {
            notFound()
            return
        }

        try {
            transaksiService.save(transaksi)
        } catch (ValidationException e) {
            respond transaksi.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'transaksi.label', default: 'Transaksi'), transaksi.id])
                redirect transaksi
            }
            '*'{ respond transaksi, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        transaksiService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'transaksi.label', default: 'Transaksi'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'transaksi.label', default: 'Transaksi'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
