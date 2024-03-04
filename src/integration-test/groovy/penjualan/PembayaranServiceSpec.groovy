package penjualan

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PembayaranServiceSpec extends Specification {

    PembayaranService pembayaranService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pembayaran(...).save(flush: true, failOnError: true)
        //new Pembayaran(...).save(flush: true, failOnError: true)
        //Pembayaran pembayaran = new Pembayaran(...).save(flush: true, failOnError: true)
        //new Pembayaran(...).save(flush: true, failOnError: true)
        //new Pembayaran(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pembayaran.id
    }

    void "test get"() {
        setupData()

        expect:
        pembayaranService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pembayaran> pembayaranList = pembayaranService.list(max: 2, offset: 2)

        then:
        pembayaranList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pembayaranService.count() == 5
    }

    void "test delete"() {
        Long pembayaranId = setupData()

        expect:
        pembayaranService.count() == 5

        when:
        pembayaranService.delete(pembayaranId)
        sessionFactory.currentSession.flush()

        then:
        pembayaranService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pembayaran pembayaran = new Pembayaran()
        pembayaranService.save(pembayaran)

        then:
        pembayaran.id != null
    }
}
