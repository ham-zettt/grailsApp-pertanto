package penjualan

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PembeliController {

    PembeliService pembeliService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pembeliService.list(params), model:[pembeliCount: pembeliService.count()]
    }

    def show(Long id) {
        respond pembeliService.get(id)
    }

    def create() {
        respond new Pembeli(params)
    }

    def save(Pembeli pembeli) {
        if (pembeli == null) {
            notFound()
            return
        }

        try {
            pembeliService.save(pembeli)
        } catch (ValidationException e) {
            respond pembeli.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pembeli.label', default: 'Pembeli'), pembeli.id])
                redirect pembeli
            }
            '*' { respond pembeli, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pembeliService.get(id)
    }

    def update(Pembeli pembeli) {
        if (pembeli == null) {
            notFound()
            return
        }

        try {
            pembeliService.save(pembeli)
        } catch (ValidationException e) {
            respond pembeli.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pembeli.label', default: 'Pembeli'), pembeli.id])
                redirect pembeli
            }
            '*'{ respond pembeli, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pembeliService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pembeli.label', default: 'Pembeli'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pembeli.label', default: 'Pembeli'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
