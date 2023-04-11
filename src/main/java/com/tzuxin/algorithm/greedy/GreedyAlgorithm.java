package com.tzuxin.algorithm.greedy;

import com.tzuxin.algorithm.greedy.entity.Radio;
import lombok.Data;

import java.awt.image.renderable.RenderableImageOp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 贪心算法，解决集合覆盖问题
 * @author chenzixin
 */
@Data
public class GreedyAlgorithm {
    public static void main(String[] args) {
        ArrayList<Radio> radios = new ArrayList<>();
        radios.add(new Radio("K1",0, new String[]{"北京", "上海", "天津"}));
        radios.add(new Radio("K2",0, new String[]{"广州", "北京", "深圳"}));
        radios.add(new Radio("K3",0, new String[]{"成都", "上海", "杭州"}));
        radios.add(new Radio("K4",0, new String[]{"上海", "天津"}));
        radios.add(new Radio("K5",0, new String[]{"杭州", "大连"}));

        GreedyAlgorithm ga = new GreedyAlgorithm(radios);
        ga.greedyAlgorithm();
    }

    /**
     * 所有电台的列表
     */
    ArrayList<Radio> radios;
    /**
     * 从radios中获取到的所有城市的列表
     */
    HashSet<String> allAreas;
    /**
     * 贪婪算法选择的对象的列表
     */
    ArrayList<Radio> selects;


    /**
     * 获得所有城市的列表（去重）
     */
    public void getAllAreasFromRadios(){
        for (Radio radio : radios) {
            HashSet<String> cityList = radio.getCityList();
            this.allAreas.addAll(cityList);
        }
    };

    /**
     * 设置匹配城市值
     * @return 匹配度最高的对象
     */
    public Radio getMateRadio(){
        int maxValue = 0;
        int index = 0;
        for (Radio radio : radios) {
            radio.setMateValue(0);
            for (String s : radio.getCityList()) {
                // 如果rio覆盖的地区在地区列表中
                if (this.allAreas.contains(s)){
                    radio.setMateValue(radio.getMateValue()+1);
                }
            }
            // 记录最大的值
            if (radio.getMateValue() > maxValue){
                maxValue = radio.getMateValue();
                index = radios.indexOf(radio);
            }
        }
        return this.radios.get(index);
    }

    /**
     *
     * @param radios 电台对象列表
     */
    public GreedyAlgorithm(ArrayList<Radio> radios) {
        this.radios = radios;
        this.allAreas = new HashSet<>();
        this.selects = new ArrayList<>();
    }

    /**
     * 贪婪算法实现
     */
    public void greedyAlgorithm(){
        getAllAreasFromRadios(); // 获取到所有城市，存储到this.allAreas属性中
        while (this.allAreas.size() > 0){
            // 获取匹配值最高的对象
            Radio radio = getMateRadio();
            // 放入列表中
            selects.add(radio);
            // 删除该对象覆盖的地区
            for (String s : radio.getCityList()) {
                this.allAreas.remove(s);
            }
        }
        System.out.println("结果：");
        System.out.println(this.selects);
    }
}
