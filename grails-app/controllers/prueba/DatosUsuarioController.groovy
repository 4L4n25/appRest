package prueba

import grails.validation.ValidationException
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.http.HttpStatus.*
@RestController
@RequestMapping("/datos")
class DatosUsuarioController {

    DatosUsuarioService datosUsuarioService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond datosUsuarioService.list(params), model:[datosUsuarioCount: datosUsuarioService.count()]
    }

    def show(Long id) {
        respond datosUsuarioService.get(id)
    }

    def save(DatosUsuario datosUsuario) {
        if (datosUsuario == null) {
            render status: NOT_FOUND
            return
        }

        try {
            datosUsuarioService.save(datosUsuario)
        } catch (ValidationException e) {
            respond datosUsuario.errors, view:'create'
            return
        }

        respond datosUsuario, [status: CREATED, view:"show"]
    }

    def update(DatosUsuario datosUsuario) {
        if (datosUsuario == null) {
            render status: NOT_FOUND
            return
        }

        try {
            datosUsuarioService.save(datosUsuario)
        } catch (ValidationException e) {
            respond datosUsuario.errors, view:'edit'
            return
        }

        respond datosUsuario, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        datosUsuarioService.delete(id)

        render status: NO_CONTENT
    }
}
