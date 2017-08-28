import static org.junit.Assert.*;
import org.junit.Test;
import rahul.BcGraph;

public class Testing {
	
	@Test
	public void test1(){
		BcGraph check1 = new BcGraph(4);
        check1.addEdge(1, 0);
        check1.addEdge(0, 2);
        check1.addEdge(2, 1);
        check1.addEdge(0, 3);
        check1.addEdge(3, 4);
        if (check1.isLinked())
            System.out.println("Yes");
        else
            System.out.println("No");
	}
	
	@Test
	public void test2() {
		BcGraph check2 = new BcGraph(2);
	    check2.addEdge(0, 1);
	    check2.addEdge(1, 1);
	    check2.addEdge(0, 0);
	    check2.addEdge(1, 0);
	    if (check2.isLinked())
	        System.out.println("Yes");
	    else
	        System.out.println("No");
	}
}
