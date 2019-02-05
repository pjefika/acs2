/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.db;

import br.net.gvt.efika.acs.model.entity.AcaoMassivaEntity;
import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.mongo.dao.MongoEndpointEnum;
import java.util.List;

public class AcaoMassivaDAOImpl extends AbstractMongoDAO<AcaoMassivaEntity> implements InterfaceDAO<AcaoMassivaEntity> {

    public AcaoMassivaDAOImpl() {
        super(MongoEndpointEnum.MONGO.getIp(), "acsAPI", AcaoMassivaEntity.class);
    }

    @Override
    public void cadastrar(AcaoMassivaEntity l) throws Exception {
        this.save(l);
    }

    public List<AcaoMassivaEntity> findByLote(String lote) throws Exception {
        return getDatastore().createQuery(AcaoMassivaEntity.class)
                .field("lote")
                .equal(lote)
                .order("data")
                .asList();
    }

}
