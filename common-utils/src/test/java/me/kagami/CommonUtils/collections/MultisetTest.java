package me.kagami.CommonUtils.collections;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Multiset继承自JDK中的Collection接口，而不是Set接口，所以包含重复元素并没有违反原有的接口契约
 * 
 * 可以用两种方式看待Multiset：
 * 没有元素顺序限制的ArrayList<E> Map<E, Integer>，键为元素，值为计数
 * 
 * Multiset中的元素计数只能是正数。任何元素的计数都不能为负，也不能是0。elementSet()和entrySet()视图中也不会有这样的元素。
 * multiset.size()返回集合的大小，等同于所有元素计数的总和。对于不重复元素的个数，应使用elementSet().size()方法。（因此，add(E)把multiset.size()增加1）
 * @author Tian
 *
 */
public class MultisetTest {
	@Test
	public void testMultsetWordCount(){
        String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        //Multiset 有多种实现 ，支持并发的，支持排序的，不可变的等等，这里使用普通的
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
        for(String key:wordsMultiset.elementSet()){
        	//给定元素在Multiset中的计数
            System.out.println(key+" count："+wordsMultiset.count(key));
        }
    }
}
