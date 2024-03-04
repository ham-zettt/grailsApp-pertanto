package penjualan

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PembeliServiceSpec extends Specification {

    PembeliService pembeliService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pembeli(...).save(flush: true, failOnError: true)
        //new Pembeli(...).save(flush: true, failOnError: true)
        //Pembeli pembeli = new Pembeli(...).save(flush: true, failOnError: true)
        //new Pembeli(...).save(flush: true, failOnError: true)
        //new Pembeli(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pembeli.id
    }

    void "test get"() {
        setupData()

        expect:
        pembeliService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pembeli> pembeliList = pembeliService.list(max: 2, offset: 2)

        then:
        pembeliList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pembeliService.count() == 5
    }

    void "test delete"() {
        Long pembeliId = setupData()

        expect:
        pembeliService.count() == 5

        when:
        pembeliService.delete(pembeliId)
        sessionFactory.currentSession.flush()

        then:
        pembeliService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pembeli pembeli = new Pembeli()
        pembeliService.save(pembeli)

        then:
        pembeli.id != null
    }
}
