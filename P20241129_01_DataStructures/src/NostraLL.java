//La mia LinkedList
public class NostraLL<T> {
	
	T data;
	NostraLL<T> next;
	
	private NostraLL<T> first;
	
	public NostraLL() {
		
		first = null;
	}
	
	void AddFirst(T info) {
		
		NostraLL<T> l = new NostraLL<T>();
		l.data = info;
		l.next = null;
		
		if (first == null) {
			
			first = l;
		}else {
			l.next = first;
			first = l;
		}
	}
	
	void AddLast(T info) {
		
		NostraLL<T> l = new NostraLL<T>();
		l.data = info;
		l.next = null;
		
		if (first == null) {
			first = l;
		} else {
			
			if (next == null) {
				next = l;
			} else {
				while (next.next != null) {
					next = next.next;
				}
			}
		}
		
	}

}
