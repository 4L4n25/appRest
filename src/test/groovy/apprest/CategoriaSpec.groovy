package apprest

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CategoriaSpec extends Specification implements DomainUnitTest<Categoria> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
    void 'test the search action find results' (){
        given:
        controller.Categoriaservice = Stub(CategoriaService){
            findByNameLike(_, _) >> [new Categoria(name: 'jhg25698','libros de garrison')]
        }
        when: 'a query is executed that finds results'
        controller.search('pp',10)

        then: 'the response is correct'
        response.Json.size() == 1
        response.Json[0].name == 'jhg25698'
    }
}
