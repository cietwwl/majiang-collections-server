package com.randioo.majiang_collections_server.module.fight.component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.randioo.majiang_collections_server.entity.bo.Game;
import com.randioo.majiang_collections_server.entity.po.RoleGameInfo;
import com.randioo.majiang_collections_server.module.fight.component.cardlist.CardList;
import com.randioo.majiang_collections_server.module.fight.component.cardlist.Chi;
import com.randioo.majiang_collections_server.module.fight.component.cardlist.Gang;
import com.randioo.majiang_collections_server.module.fight.component.cardlist.Hu;
import com.randioo.majiang_collections_server.module.fight.component.cardlist.Peng;
import com.randioo.randioo_server_base.service.ObservableInterface;
import com.randioo.randioo_server_base.template.Observer;

/**
 * 麻将规则
 * 
 * @author wcy 2017年8月21日
 *
 */
public abstract class MajiangRule implements Observer, ObservableInterface {

    /** 所有观察者 */
    private List<Observer> observers = new LinkedList<>();

    @Override
    public void addObserver(Observer paramObserver) {
        observers.add(paramObserver);
    }

    @Override
    public void deleteObserver(Observer paramObserver) {
        observers.remove(paramObserver);
    }

    @Override
    public void notifyObservers(String msg, Object... params) {
        for (Observer observer : observers) {
            try {
                observer.update(this, msg, params);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int countObservers() {
        return observers.size();
    }

    @Override
    public void deleteObservers() {
        observers.clear();
    }

    /**
     * 麻将状态
     * 
     * @author wcy 2017年8月21日
     *
     */
    public enum MajiangState {
        /** 游戏准备 */
        STATE_GAME_READY,
        /** 游戏开始 */
        STATE_GAME_START,
        /** 发牌 */
        STATE_DISPATCH,
        /** 通知出牌 */
        STATE_NOTICE_SEND_CARD,
        /** 出牌 */
        STATE_GAME_SEND_CARD,
        /** 摸牌 */
        STATE_TOUCH_CARD,
        /** 检查别人的杠碰吃胡 */
        STATE_CHECK_OTHER_GANG_PENG_HU_CHI,
        /** 检查自己的杠碰吃胡 */
        STATE_CHECK_MINE_GANG_PENG_HU_CHI,
        /** 回合结束 */
        STATE_ROUND_OVER,
        /** 游戏结束 */
        STATE_GAME_OVER;
    }

    /**
     * 获得所有牌
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract int[] getCards();

    /**
     * 能否抓胡
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract boolean canZhuaHu(Game game);

    /**
     * 能否白搭抓胡
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract boolean canBaiDaZhuaHu(Game game);

    /**
     * 获得胡
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract Hu getHu();

    /**
     * 获得碰
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract Peng getPeng();

    /**
     * 获得杠
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract Gang getGang();

    /**
     * 获得吃
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract Chi getChi();

    /**
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract Map<Class<? extends CardList>, CardList> checkOtherCardListSequence();

    /**
     * 
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract Map<Class<? extends CardList>, CardList> checkMineCardListSequence();

    /**
     * 执行下一条流程
     * 
     * @param game
     * @author wcy 2017年8月21日
     */
    public void executeNextProcess(RuleableGame game) {
        MajiangState majiangState = game.getMajiangState();

        majiangState = this.execute(majiangState);

        game.setMajiangState(majiangState);

        this.onNotify(game);
    }

    /**
     * 
     * @param majiangState
     * @return
     * @author wcy 2017年8月21日
     */
    public abstract MajiangState execute(MajiangState majiangState);

    /**
     * 
     * @param majiangState
     * @author wcy 2017年8月21日
     */
    public abstract void onNotify(RuleableGame game);
}
