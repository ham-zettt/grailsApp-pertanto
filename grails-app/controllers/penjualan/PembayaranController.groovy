package penjualan

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PembayaranController {

    PembayaranService pembayaranService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pembayaranService.list(params), model:[pembayaranCount: pembayaranService.count()]
    }

    def show(Long id) {
        respond pembayaranService.get(id)
    }

    def create() {
        respond new Pembayaran(params)
    }

    def save(Pembayaran pembayaran) {
        if (pembayaran == null) {
            notFound()
            return
        }

        try {
            pembayaranService.save(pembayaran)
        } catch (ValidationException e) {
            respond pembayaran.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pembayaran.label', default: 'Pembayaran'), pembayaran.id])
                redirect pembayaran
            }
            '*' { respond pembayaran, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pembayaranService.get(id)
    }

    def update(Pembayaran pembayaran) {
        if (pembayaran == null) {
            notFound()
            return
        }

        try {
            pembayaranService.save(pembayaran)
        } catch (ValidationException e) {
            respond pembayaran.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pembayaran.label', default: 'Pembayaran'), pembayaran.id])
                redirect pembayaran
            }
            '*'{ respond pembayaran, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pembayaranService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pembayaran.label', default: 'Pembayaran'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pembayaran.label', default: 'Pembayaran'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
