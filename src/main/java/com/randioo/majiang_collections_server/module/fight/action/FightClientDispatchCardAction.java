package com.randioo.majiang_collections_server.module.fight.action;

import java.util.List;

import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.randioo.majiang_collections_server.entity.bo.Role;
import com.randioo.majiang_collections_server.module.fight.service.FightService;
import com.randioo.majiang_collections_server.protocol.Entity.ClientCard;
import com.randioo.majiang_collections_server.protocol.Fight.FightClientDispatchRequest;
import com.randioo.randioo_server_base.annotation.PTAnnotation;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.template.IActionSupport;

@Controller
@PTAnnotation(FightClientDispatchRequest.class)
public class FightClientDispatchCardAction implements IActionSupport {

    @Autowired
    private FightService fightService;

    @Override
    public void execute(Object data, IoSession session) {
        FightClientDispatchRequest request = (FightClientDispatchRequest) data;
        Role role = (Role) RoleCache.getRoleBySession(session);
        List<ClientCard> cards = request.getCardsList();
        fightService.clientDispatchCards(role, cards);
    }

}
