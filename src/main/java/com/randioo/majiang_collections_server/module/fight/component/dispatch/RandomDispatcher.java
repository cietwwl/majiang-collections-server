package com.randioo.majiang_collections_server.module.fight.component.dispatch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.randioo.majiang_collections_server.entity.bo.Game;
import com.randioo.majiang_collections_server.util.CardTools;
import com.randioo.majiang_collections_server.util.Lists;
import com.randioo.randioo_server_base.utils.RandomUtils;

@Component
public class RandomDispatcher implements Dispatcher {

    @Override
    public List<CardPart> dispatch(Game game, List<Integer> cards, int partCount, int everyPartCount) {

        List<CardPart> cardParts = new ArrayList<>(partCount);
        for (int i = 0; i < partCount; i++) {
            CardPart cardPart = new CardPart();
            cardParts.add(cardPart);
            for (int j = 0; j < everyPartCount; j++) {
                int index = RandomUtils.getRandomNum(cards.size());
                cardPart.add(cards.get(index));
                cards.remove(index);
            }
        }
        return cardParts;
    }

    public static void main(String[] args) {
        List<Integer> remainCards = new ArrayList<>(CardTools.CARDS.length);
        Lists.fillList(remainCards, CardTools.CARDS);
        RandomDispatcher dispatcher = new RandomDispatcher();
        List<CardPart> list = dispatcher.dispatch(null, remainCards, 4, 13);
        System.out.println(list);
        System.out.println(remainCards);
    }

}
