package algorismProject2;

import algorismProject2.BinaryTree.Node;

public class BinaryTree<K, V> {
	//	객체 1개를 저장할 노드 클래스
	//				key, Data(values)
	static class Node<K, V>{			//	제너릭으로
		private K key;					//	key
		private V data;					//	data
		private Node<K,V> left;			//	왼쪽 노드 저장
		private Node<K,V> right;		//	오른쪽 노드 저장
		
		//	Node<K,V> 클래스의 생성자 메소드
		Node(K key, V data, Node<K,V> left, Node<K,V> right){
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		//	키값 내보내기
		K getKey() {
			return key;
		}
		//	데이터값 내보내기
		V getValue() {
			return data;
		}
		
		//	출력
		void print() {
			System.out.println(data);
		}
	}//	Node 클래스 만든거 (정보 1개를 담을 수 있는 클래스 생성)
	
	private Node<K,V> root;				//	루트 노드
	BinaryTree(){
		root = null;					//	루트노드 초기화
	}
	
	public int comp(K key1, K key2) {
		//		key1-key2	0: Key1과 key2 같다.,	양수 : key1이 크다, 음수: key2가 크다
		return ((Comparable<K>)key1).compareTo(key2);
		
	}
	//	노드추가(위치를 찾아서 노드추가하는 기능)
	public void addNode(Node<K,V> node, K key, V data) {
		//비교 10		50
		int result = comp(key, node.getKey());
		
		if(result == 0){				//	이미 있는 키 값일 때, 메소드를 끝낸다.
			return;
		}else if(result < 0) {			//	result가 0보다 작으면 왼쪽노드를 검색
			if(node.left == null) {						//	node의 왼쪽이 비어있으면, 새로운 노드를 node 왼쪽에 추가
				node.left = new  Node<K,V>(key, data, null, null);
			}else {
				addNode(node.left, key, data);
			}
		}else {	//	양수 : 오른쪽 노드를 검색
			if(node.right == null) {
				node.right = new Node <K, V>(key, data, null, null);
			}else {
				addNode(node.right, key, data);
			}
		}
	}
	//	노드추가
	public void add(K key, V data) {
		if(root == null) {
			//	루트가 비어있으면 data를 노드로 만들어 root에 대입하면된다.
			root = new Node<K, V>(key, data, null, null);
			
		}else {
			//	루트가 비어있지 않으면 key를 이용하여 위치를 찾아 추가해야한다.
			addNode(root, key, data);	
		}		
	}
	
	//	노드 출력
	public void subNodePrint(Node node) {
		if(node != null) {
			subNodePrint(node.left);
			System.out.println(node.getKey() + " "+ node.data);
			subNodePrint(node.right);
		}
	}
	//	노드 출력
	public void print() {
		if(root == null) {			//	노드가 비어 있을 때
			System.out.println("등록된 상품이 없습니다.");
		}else {
			subNodePrint(root);
		}
	}
	
	
	//	노드 검색
	public V search(K key) {
		Node<K,V> point = root;
		
		while(true) {
			if(point == null) {		//	노드가 없을 때
				return null;		
			}
			//	입력받은 키와 point에 있는 키의 크기를 구하여
			//	음수가 나오면, 0이 나오면, 양수가 나오면
			int result = comp(point.getKey(), key);
			if(result == 0) {		//	key와 같은 정보를 가진 Data가 검색됨
				return point.getValue();
			}else if(result > 0) {
				point = point.left;
			}else {
				point = point.right;
			}
		}		
	}
	
	//	노드 삭제
	public boolean remove(K key) {
		Node<K, V> point = root;			//	root
		Node<K, V> parent = null;			//	부모
		boolean isLeftChild = true;			//	왼쪽, 오른쪽노드인지 정보가 필요함
		
		while(true) {
			if(point == null){ 				//	root가 null이면 노드가 존재하지 않는다.
				return false;
			}
			
			//	삭제할 노드 찾기
			int cond = comp(key, point.getKey());	//	양수 -> 오른쪽 검색/ 음수 -> 왼쪽검색
			
			if(cond == 0) {					//	검색할 노드 찾음
				break;
			}else {
				parent = point;				//	부모 노드
				if(cond < 0) {
					point = point.left;		//	다음 노드(왼쪽의 다음 노드)
					isLeftChild = true;
				}else {
					point = point.right;
					isLeftChild = false;
				}
			}
		}
		//	부모 노드, 삭제할 노드 정해짐
		if(point.left == null && point.right == null) {		//	삭제할 노드의 자식이
			if(point == root) root = null;
			else if(isLeftChild) {
				parent.left = null;
			}else {
				parent.right = null;
			}
		} else if(point.left == null) {		//	left 노드가 없을 때 (삭제할 노드의 right를 부모노드의 left에 대입한다.)
			//	삭제할 노드가 root이면 오른쪽노드를 root
			if(point == root) {
				root = point.right;
			}else if(isLeftChild) {
				parent.left = point.right;
			}else {
				parent.right = point.right;
			}
		} else if(point.right == null) {	//	삭제할 노드에 right가 없을 때
			if(point == root) {
				root = point.left;
			}else if(isLeftChild) {
				parent.left = point.left;
			}else {
				parent.right = point.right;
			}
		} else {	//	left노드와 right 노드가 모두 있을 때
			//	point의 자식들 중 제일 큰 노드 구하기
			parent = point;
			Node<K,V> maxNode = point.left;
			isLeftChild = true;
			while(maxNode.right != null) {
				parent = maxNode;
				maxNode = maxNode.right;
				isLeftChild = false;
			}
			
			point.key= maxNode.key;
			point.data= maxNode.data;
			
			if(isLeftChild) {
				parent.left = maxNode.left;
			}else {
				parent.right = maxNode.left;
			}
		}
		// 노드 삭제 끝	
		
		return true;
	}
}