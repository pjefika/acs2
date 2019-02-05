/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.db;

import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.mongo.dao.MongoEndpointEnum;
import br.net.gvt.efika.acs.model.entity.Lote;

public class LoteDAOImpl extends AbstractMongoDAO<Lote> implements InterfaceDAO<Lote> {

    public LoteDAOImpl() {
        super(MongoEndpointEnum.MONGO.getIp(), "acsAPI", Lote.class);
    }

    @Override
    public void cadastrar(Lote l) throws Exception {
        this.save(l);
    }

}
