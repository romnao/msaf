public class D1031 {
	public static void main(String[] args) {
		Dog pochi = new Dog();

		pochi.print();

		pochi.roudou();
		pochi.print();

		pochi.roudou();
		pochi.print();

		pochi.shokuji();
		pochi.print();

		pochi.shokuji();
		pochi.print();
	}
}
//連合
class Dog {
	private DogState myState;

	public Dog() {
		myState = TanoshiiState.getInstance();
	}
	public void roudou() {
		myState.tukareta(this);
	}
	public void shokuji() {
		myState.tabeta(this);
	}
	public void changeState(DogState d) {
		myState = d;
	}
	public void print() {
		System.out.print("現在、わたしは「");
		System.out.print( myState.toString() );
		System.out.println("」です。");
	}
}

//EU的な連合
//多分この辺で　パラメータ変動情報が追加されてる
	abstract class DogState {
	public abstract void tukareta(Dog yobidashimoto); //疲れた！
	public abstract void tabeta(Dog yobidashimoto); //食べた！ }
}

//各国家
class TanoshiiState extends DogState {//私の名前は楽しいさん
	private static TanoshiiState s = new TanoshiiState();
	private TanoshiiState() {}

	public static DogState getInstance() {
		return s;
	}
	public void tukareta(Dog moto) {
		moto.changeState(FutsuuState.getInstance());
		//お仕事コードで　チェンジステータス（変更）　普通に路線変更
	}
	public void tabeta(Dog moto) { // なにもしない これ以上良くならない
	}
	public String toString() {
		return "楽しい状態";//結果としての表示　路線変更後表記もこれになる
	}
}

//国境

class FutsuuState extends DogState {//私の名前は普通さん
	private static FutsuuState s = new FutsuuState();//ここは名前と統一
	private FutsuuState() {}

	public static DogState getInstance() {
		return s;
	}
	public void tukareta(Dog moto) {
		moto.changeState(IrairaState.getInstance());
		//労働による疲れだと思う　次はーイライラー
	}
	public void tabeta(Dog moto) {
		moto.changeState(TanoshiiState.getInstance());
		//多分これ食べたから　楽しいっていうほうに飛ばしてる？
	}
	public String toString() {
		return "普通状態";//TDN表示
	}
}

//国境

class IrairaState extends DogState {
	private static IrairaState s = new IrairaState();
	private IrairaState() {}

	public static DogState getInstance() {
		return s;
	}
	public void tukareta(Dog moto) {
		moto.changeState(ByoukiState.getInstance());
		//新要素　病気って項目　多分こんな感じじゃね？ふわー
	}
	public void tabeta(Dog moto) {
		moto.changeState(TanoshiiState.getInstance());
	}
	public String toString() {
		return "いらいら状態";
	}
}

//国境

class ByoukiState extends DogState {
	private static ByoukiState s = new ByoukiState();
	private ByoukiState() {}

	public static DogState getInstance() {
		return s;
	}
	public void tukareta(Dog moto) {
		//moto.changeState(ByoukiState.getInstance()); わんちゃんこれいらない
		//新要素　病気って項目　多分こんな感じじゃね？ふわー
	}
	public void tabeta(Dog moto) {
		moto.changeState(TanoshiiState.getInstance());
	}
	public String toString() {
		return "病気状態";
	}
}

//終点　末尾　末尾　お忘れ物ないよう　ご注意ください
//Mayday! Mayday! Mayday! Speed Bird 9. We've lost all 4 engines!