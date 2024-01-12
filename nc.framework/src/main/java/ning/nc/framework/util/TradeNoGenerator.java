package ning.nc.framework.util;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 描述
 *
 * @author allen
 * 2019-07-26 17:34
 */
public class TradeNoGenerator {
    //基准时间截 (2017-01-01)
    private static final long initStamp=1483200000000L;
    //每秒基准容量1000个
    private static final int secondsSpace=1000;
    //基准容量扩容倍数
    private static final int secondsSpaceMulti=10;
    //多少秒不用，重新设定原子初始值
    private static final int secondsRefresh=60;
    //原子初始值
    private AtomicLong atomicLong=new AtomicLong((System.currentTimeMillis()-initStamp)*secondsSpaceMulti);

    private TradeNoGenerator() {
    }

    private static class TradeNoGeneratorHolder{
        private static TradeNoGenerator instance = new TradeNoGenerator();
    }

    public static TradeNoGenerator getInstance() {
        return TradeNoGeneratorHolder.instance;
    }

    //线程安全
    /**
     * 用这个，用这个
     * @return
     * 生成结果例：11983017246298
     * 由三段组成，11983017，2462，98
     * 第一段11983017，位数会随着时间增长增加，计算方式为与initStamp相加，结果为到秒的时间戳
     * 第二段，2462，看容量决定位数，容量=secondsSpace*secondsSpaceMulti，原子增长字段
     * 第三段98，固定2位，随机数
     */
    public synchronized String getNo(){
        long no=atomicLong.getAndIncrement();
        //当前秒时间戳与基准时间戳秒级数量
        long currentSecond = (System.currentTimeMillis()-initStamp) / 1000;
        //计数超过60秒未使用过，则重新给定初始值
        if (currentSecond-no/(secondsSpace*secondsSpaceMulti)>=secondsRefresh){
            //重置原子计数原始值
            atomicLong=new AtomicLong((System.currentTimeMillis()-initStamp)*secondsSpaceMulti);
            no=atomicLong.getAndIncrement();
        }
        //计算容量是否超出
        if (no-currentSecond*secondsSpace*secondsSpaceMulti>=secondsSpace*secondsSpaceMulti){
            //超出则等待下一秒的到来，这里计算到下一整数秒的微秒差
            long millisWithinSecond = System.currentTimeMillis() % 1000;
            try {
                Thread.sleep(1000 - millisWithinSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(">>> new second . "+no +" "+Thread.currentThread().getName());

            //重置原子计数原始值
            atomicLong=new AtomicLong((System.currentTimeMillis()-initStamp)*secondsSpaceMulti);
            no=atomicLong.getAndIncrement();
        }

        int hashCode= UUID.randomUUID().hashCode();
        hashCode=hashCode<0?-hashCode:hashCode;
        String randomStr=String.valueOf(hashCode).substring(0,2);
        return no+randomStr;
    }

    /**
     * 获取时间戳
     * @param tradeNo
     * @return
     */
    public long getTimestamp(String tradeNo){
        int spaceLen = String.valueOf(secondsSpace*secondsSpaceMulti).length()-1;
        int stampLen=tradeNo.length()-spaceLen-2;
        String stampStr=tradeNo.substring(0,stampLen);
        //右侧补齐微秒
        long stamp=Long.parseLong(stampStr+String.format("%1$03d",0));
        stamp+=initStamp;
        return stamp;
    }
}
