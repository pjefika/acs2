/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.db;

import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.mongo.dao.MongoEndpointEnum;
import model.entity.LogEntity;

public class LogDAOImpl extends AbstractMongoDAO<LogEntity> implements InterfaceDAO<LogEntity> {

    public LogDAOImpl() {
        super(MongoEndpointEnum.MONGO.getIp(), "acsAPI", LogEntity.class);
    }

    @Override
    public void cadastrar(LogEntity l) throws Exception {
        this.save(l);
    }

}
