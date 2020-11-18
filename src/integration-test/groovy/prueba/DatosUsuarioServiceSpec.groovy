package prueba

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DatosUsuarioServiceSpec extends Specification {

    DatosUsuarioService datosUsuarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DatosUsuario(...).save(flush: true, failOnError: true)
        //new DatosUsuario(...).save(flush: true, failOnError: true)
        //DatosUsuario datosUsuario = new DatosUsuario(...).save(flush: true, failOnError: true)
        //new DatosUsuario(...).save(flush: true, failOnError: true)
        //new DatosUsuario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //datosUsuario.id
    }

    void "test get"() {
        setupData()

        expect:
        datosUsuarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DatosUsuario> datosUsuarioList = datosUsuarioService.list(max: 2, offset: 2)

        then:
        datosUsuarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        datosUsuarioService.count() == 5
    }

    void "test delete"() {
        Long datosUsuarioId = setupData()

        expect:
        datosUsuarioService.count() == 5

        when:
        datosUsuarioService.delete(datosUsuarioId)
        sessionFactory.currentSession.flush()

        then:
        datosUsuarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DatosUsuario datosUsuario = new DatosUsuario()
        datosUsuarioService.save(datosUsuario)

        then:
        datosUsuario.id != null
    }
}
