package me.kagami.CommonUtils.collections;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * 通常来说，当你想使用多个键做索引的时候，你可能会用类似Map<FirstName, Map<LastName, Person>>的实现。
 * Guava为此提供了新集合类型Table，它有两个支持所有类型的键：”行”和”列”。
 * 
 * @author Tian
 * 
 * HashBasedTable：基于HashMap<R, HashMap<C, V>>的实现。 
 * TreeBasedTable：基于TreeMap<R, TreeMap<C, V>>的实现。 
 * ImmutableTable：基于ImmutableMap<R, ImmutableMap<C, V>>的实现。（注意，ImmutableTable已对稀疏和密集集合做了优化） 
 * ArrayTable：ArrayTable是一个需要在构建的时候就需要定下行列的表格。这种表格由二维数组实现，这样可以在密集数据的表格的场合，提高时间和空间的效率。
 *
 */
public class TableTest {
	@Test
	public void test() {
		Table<String, Integer, String> aTable = HashBasedTable.create();

		for (char a = 'A'; a <= 'C'; ++a) {
			for (Integer b = 1; b <= 3; ++b) {
				aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
			}
		}
//		{A={1=A1, 2=A2, 3=A3}, B={1=B1, 2=B2, 3=B3}, C={1=C1, 2=C2, 3=C3}}
		
		System.out.println(aTable.column(2));
		System.out.println(aTable.row("B"));
		System.out.println(aTable.get("B", 2));

		System.out.println(aTable.contains("D", 1));
		System.out.println(aTable.containsColumn(3));
		System.out.println(aTable.containsRow("C"));
		System.out.println(aTable.columnMap());
		System.out.println(aTable.rowMap());

		System.out.println(aTable.remove("B", 3));
	}
}
