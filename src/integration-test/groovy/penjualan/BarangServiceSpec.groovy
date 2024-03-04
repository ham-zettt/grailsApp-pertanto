package penjualan

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BarangServiceSpec extends Specification {

    BarangService barangService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Barang(...).save(flush: true, failOnError: true)
        //new Barang(...).save(flush: true, failOnError: true)
        //Barang barang = new Barang(...).save(flush: true, failOnError: true)
        //new Barang(...).save(flush: true, failOnError: true)
        //new Barang(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //barang.id
    }

    void "test get"() {
        setupData()

        expect:
        barangService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Barang> barangList = barangService.list(max: 2, offset: 2)

        then:
        barangList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        barangService.count() == 5
    }

    void "test delete"() {
        Long barangId = setupData()

        expect:
        barangService.count() == 5

        when:
        barangService.delete(barangId)
        sessionFactory.currentSession.flush()

        then:
        barangService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Barang barang = new Barang()
        barangService.save(barang)

        then:
        barang.id != null
    }
}
