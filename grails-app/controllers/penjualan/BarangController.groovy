package penjualan

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BarangController {

    BarangService barangService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond barangService.list(params), model:[barangCount: barangService.count()]
    }

    def show(Long id) {
        respond barangService.get(id)
    }

    def create() {
        respond new Barang(params)
    }

    def save(Barang barang) {
        if (barang == null) {
            notFound()
            return
        }

        try {
            barangService.save(barang)
        } catch (ValidationException e) {
            respond barang.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'barang.label', default: 'Barang'), barang.id])
                redirect barang
            }
            '*' { respond barang, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond barangService.get(id)
    }

    def update(Barang barang) {
        if (barang == null) {
            notFound()
            return
        }

        try {
            barangService.save(barang)
        } catch (ValidationException e) {
            respond barang.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'barang.label', default: 'Barang'), barang.id])
                redirect barang
            }
            '*'{ respond barang, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        barangService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'barang.label', default: 'Barang'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'barang.label', default: 'Barang'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
