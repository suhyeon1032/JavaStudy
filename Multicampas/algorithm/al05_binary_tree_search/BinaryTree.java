package al05_binary_tree_search;
public class BinaryTree<K, V> {
	//��ü 1���� ������ ���Ŭ����
	//				key, Data
	static class Node<K, V>{
		private K key;//key
		private V data;//data
		private Node<K,V> left;//���ʳ��
		private Node<K,V> right;//�����ʳ��
		
		Node(K key, V data, Node<K,V> left, Node<K,V> right) {
			this.key=key;//����� �ִ� key�� ���������� �ִ� key�� ������
			this.data=data;//����� �ִ� data�� ���������� �ִ� data�� ������
			this.left=left;//����� �ִ� left�� ���������� �ִ� left�� ������
			this.right=right;//����� �ִ� right�� ���������� �ִ� right�� ������
		}
		K getKey() {
			return key;
		}
		//������
		V getValue() {
			return data;
		}
		//���
		void print() {
			System.out.println(data);
		}
		
	}//Node
	
	private Node<K,V> root;//��Ʈ���
	
	BinaryTree(){
		root = null;//��Ʈ����ʱ�ȭ
	}
	
	public int comp(K key1, K key2) {
		//		key1-key2	  0 : key1�� key2����.	������� ����� key1�� �� ũ��, ������� ������ key2�� �� ũ��. 
		return ((Comparable<K>)key1).compareTo(key2);
	}
	//����߰�(��ġ�� ã�Ƽ� ����߰�)
	public void addNode(Node<K,V> node, K key, V data) {
		//��
		int result = comp(key, node.getKey());
		if(result==0) {//�̹� �ִ� Ű���϶�
			return;
		} else if(result<0) {//���ʳ�带 �˻�
			if(node.left==null) {//node�� ������ ���������
				node.left = new Node<K,V>(key,data,null,null);
			}else {
				addNode(root, key, data);
			}
		} else {//���:������ ��带 �˻�
			if(node.right==null) {
				node.right = new Node<K,V>(key,data,null,null);
			}else {
				addNode(node.right, key, data);
			}
		}
	}
	
	//����߰�
	public void add(K key, V data) {
		if(root==null) {
			//��Ʈ�� ��������� data�� ��带 ����� root�� �����ϸ� �ȴ�.
			root = new Node<K,V>(key, data, null, null);
		} else {
			//��Ʈ�� ������� ������ key�� �̿��Ͽ� ��ġ�� ã�Ƽ� �߰��ؾ��Ѵ�.
			addNode(root, key, data);
		}
	}
	//������
	public boolean remove(K key) {
		Node<K, V> point = root;//root
		Node<K, V> parent = null;//�θ� (root�� �θ� �����Ƿ� ���� �صΰ� null�� �ʱ�ȭ)
		boolean isLeftChild = true;//����, �����ʳ�������� ������ �ʿ���
		
		while(true) {
			if(point==null){//point�� null�̸� ��尡 �������� �ʴ´�.
				return false;
			}
			
			//������ ��� ã��
			int cond = comp(key, point.getKey());//��� -> �����ʰ˻�
			
			if(cond==0) {//�˻��� ��� ã��.
				break;
			}else {
				parent = point;//�θ���
				if(cond<0) {
					point = point.left;//�������(������ �������)
					isLeftChild = true;
				}else {
					point = point.right;
					isLeftChild = false;
				}
			}
		}
		//�θ��� , �����ҳ�� ������
		if(point.left==null && point.right==null) {//������ ����� �ڽ��� ������
			if(point==root) {
				root=null;
			}else if(isLeftChild) {
				parent.left = point.right;
			}else {
				parent.right = point.right;
			}
		}else if(point.left == null) {
			//������ ��尡 root�̸� �����ʳ�带
			if(point==root) {
				root = point.right;
			}else if(isLeftChild) {
				parent.left = point.right;
			}else {
				parent.right = point.right;
				
			}
		}else if(point.right==null) {//������ ��尡 ������
			if(point==root) {
				root = point.left;
			}else if(isLeftChild) {
				parent.left = point.left;
			}else {
				parent.right = point.right;
			}
		}else {//left���� right��尡 ��� ������
			//point�� �ڽĵ��� ���� ū ��� ���ϱ�
			parent = point;
			Node<K,V> maxNode = point.left;
			isLeftChild = true;
			while(maxNode.right!=null) {
				parent = maxNode;
				maxNode = maxNode.right;
				isLeftChild = false;
			}
			
			point.key = maxNode.key;
			point.data = maxNode.data;
			
			if(isLeftChild) {
				parent.left = maxNode.left;
			}else {
				parent.right = maxNode.left;
			}
		}
		//������
		System.out.println(key + "�� ȸ���� �����Ǿ����ϴ�.");
		return true;
		//left��尡 ������ (������ ����� right�� �θ����� left�� �����Ѵ�.
	}
	//���˻�
	public V search(K key) {
		Node<K,V> point = root;  // root, left
		
		while(true) {
			if(point == null) {
				return null; //��尡 ������
			}
			//�Է¹��� Ű�� point�� �ִ� Ű�� ũ�⸦ ���Ͽ�
			//������ ������, 0�� ������, ����� ������ key�� �۴�.
			int result = comp(point.getKey() , key);
			if(result==0) {//key�� ���� ������ ���� Data�˻���
				return point.getValue();
			}else if(result>0) {
				point = point.left;
			}else {
				point = point.right;
			}
		}
	}
	
	//������
	public void subNodePrint(Node node) {
		if(node!=null) {
			subNodePrint(node.left);
			System.out.println(node.getKey() +" "+ node.data);
			subNodePrint(node.right);
		}
	}
	//������
	public void print() {
		if(root==null) {//��尡 ��� ������
			System.out.println("��ϵ� ȸ���� �����ϴ�.");
		}else {
			subNodePrint(root);
		}
	}
}