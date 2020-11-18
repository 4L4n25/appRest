package prueba

import grails.gorm.services.Service

@Service(DatosUsuario)
interface DatosUsuarioService {

    DatosUsuario get(Serializable id)

    List<DatosUsuario> list(Map args)

    Long count()

    void delete(Serializable id)

    DatosUsuario save(DatosUsuario datosUsuario)

}