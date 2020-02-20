import java.util.LinkedHashSet;
import java.util.TreeSet;

class ship {
private String name; // 名称
private int price; // 価格
public ship(String name, int price) { // コンストラクタ
this.name= name;
this.price = price;
}
public String getName() { // 名称を取得
return name;
}
public int getPrice() { // 価格を取得
return price;
}
}


interface Iterator {
	public void first();
	public void next();
	public void idDone();
	public Object getItem();
}

class shipListIterator implements Iterator { //何これ
	private shipListAggregate aggregate;
	private int current;

	public shipListIterator(shipListAggregate aggregate) {
		this.aggregate = aggregate;
		}

		@Override
		public void first() {
		current = 0;
		}

		@Override
		public void next() {
			current += 1;
			}
			@Override
			public boolean isDone() {
			if (current >= aggregate.getNumberOfStock()) {
			return true;
			}
			else {
			return false;
			}
			}
			@Override
			public Object getItem() {
			return aggregate.getAt(current);
			}
}

interface Aggregate {
public Iterator createIterator();
}

class shipListAggregate implements Aggregate {
private ship[] list = new ship[20];
private int numberOfStock;
@Override
public Iterator createIterator() {
return new shipListIterator(this);
}
public void add(ship ship) {
list[numberOfStock] = ship;
numberOfStock += 1;
}
public Object getAt(int number) {
return list[number];
}
public int getNumberOfStock() {
return numberOfStock;
}
}

public class IteratorSample1 {　//消えないエラー　🤔
	public static void main(String[] args) {
			shipListAggregate shipListAggregate = new shipListAggregate();
			Iterator iterator = shipListAggregate.createIterator();
			shipListAggregate.add(new ship("Arkansas", 3700));
			shipListAggregate.add(new ship("nelson", 7300));
			shipListAggregate.add(new ship("kingGeorgeV", 5400));
			shipListAggregate.add(new ship("vanguard", 5200));

			TreeSet<String> treeSet = new TreeSet<String>(hashSet);
			//一行目にインポートでTreeSetを入れたらエラーが消えたやったぜ
			//そしてこの行でソート処理　ループしてるけどやっている間はソートさせる
			iterator.first(); // まず探す場所を先頭位置にしてもらう
			while ( ! iterator.isDone() ) { // まだある？ まだあるよ！
				ship ship = (ship)iterator.getItem(); // はいどうぞ (と受取る)
				System.out.println(ship.getName());
				iterator.next(); // 次を頂戴
}
}
}