package penjualan

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TransaksiServiceSpec extends Specification {

    TransaksiService transaksiService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Transaksi(...).save(flush: true, failOnError: true)
        //new Transaksi(...).save(flush: true, failOnError: true)
        //Transaksi transaksi = new Transaksi(...).save(flush: true, failOnError: true)
        //new Transaksi(...).save(flush: true, failOnError: true)
        //new Transaksi(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //transaksi.id
    }

    void "test get"() {
        setupData()

        expect:
        transaksiService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Transaksi> transaksiList = transaksiService.list(max: 2, offset: 2)

        then:
        transaksiList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        transaksiService.count() == 5
    }

    void "test delete"() {
        Long transaksiId = setupData()

        expect:
        transaksiService.count() == 5

        when:
        transaksiService.delete(transaksiId)
        sessionFactory.currentSession.flush()

        then:
        transaksiService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Transaksi transaksi = new Transaksi()
        transaksiService.save(transaksi)

        then:
        transaksi.id != null
    }
}
