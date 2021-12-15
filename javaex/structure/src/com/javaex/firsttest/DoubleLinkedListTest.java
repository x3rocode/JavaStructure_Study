package com.javaex.firsttest;


 
class MyLinkedList<T>{//LinkedList<제네릭> list = new LinkedList<제네릭>();
    public Node head;//노드가 헤드인지 표시하기 위해서 적음
    //private Node tail;//노드가 테일인지 표시하기 위해서 적음
    public int size=0;//연결리스트는 size라는 속성을 가지니까 적고 0으로 초기화
    class Node{//노드는 연결리스트의 한 부분이므로 연결리스트 클래스 안에 내부 클래스로 존재한다
        public Node next;//각각의 노드 클래스의 인스턴스는. 즉 노드 객체는 다음 노드의 주소인 next
        public Node prev;
        public T data;//그리고 data를 속성으로 갖는다
        public Node(T data) {//데이터가 새로 들어와서 노드가 새로 생성될때, 즉 생성자를 사용해야 한다
            this.data = data;
            this.next = null;//새로운 노드가 생성될 당시에는 이게 head인지 tail인지
            this.prev = null;
            //정하지 않는다 그래서 null로 지정한다
        }
    }
    public void add(int index,T data) {
        if (index==0) {
            addFirst(data);
        }
        else {
            Node temp1 = node(index-1);
            Node temp2 = temp1.next;
            Node newNode = new Node(data);
        
            temp1.next = newNode;
            newNode.next = temp2;
            newNode.prev = temp1;
            temp2.prev = newNode;
            size++;
            if (newNode.next==null) {//새로운 노드가 마지막 노드이면
                //tail = newNode;//tail이 새로운 노드를 가리키게 한다
                newNode.next = head;

            }
        }
    }
    public void addFirst(T data) {
        //값이 추가될때 노드가 하나 생성되기 때문에
        //생성자를 호출한다
        Node newNode = new Node(data);
       
       // newNode.next = head;//첫번째 인덱스에 생성된 노드이다
        //newNode.prev = node(size);
        //head.prev = head;
        if (head == null) {//헤드 노드의 다음이 없으면
            //즉 이 노드가 처음이자 마지막 유일한 노드라면
            //tail이 head의 값과 같은 값을 갖게 한다
            head = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
            
            //head.prev= head;
            //즉 head 와 tail이 가리키는 곳이 같아진다
        }
        else{
            Node tmp1 = head;
            Node tmpprv = tmp1.prev;

            newNode.prev = tmpprv;
            newNode.next = tmp1;
            tmp1.prev = newNode;
            tmpprv.next = newNode;
            head = newNode;
        }

       // tmp1.next = head;
        //head역시 새로운 첫번째 노드를 가리킨다
        
        size++;//리스트의 사이즈가 1 증가한다
    }
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (size==0) {//addLast를 호출했으나
            //리스트의 사이즈가 0이라면 노드의 생성 위치가 상관이 없다
            addFirst(data);//그래서  addFirst를 호출한다
        }
        else {

            Node last = head;
            while(last.next!=head){
                last = last.next;
            }
            Node nexts = last.next;

            newNode.next = nexts;
            nexts.prev = newNode;
            last.next = newNode;
            newNode.prev = last;

            size++;
        }    
    }
    private Node node(int index) {
        Node x = head;//바로 x=x.next로 하지 않는 이유
        //이렇게 대입하면 x에 현재 헤드의 값이 담긴다
        //x = x.next;//그리고 head의 다음 노드를 x가 가리킨다
        //연결리스트는 주소를 통해서 헤드부터 차례로 탐색을 한다
        //그렇다면  x = x.next를 몇번 수행하는지가 데이터를 탐색하는 데 관건이다
        for (int i = 0; i < index; i++) {
            //그래서 index크기 만큼 x=x.next를 수행한다
            x = x.next;
        }
        return x;//그리고 x를 리턴한다 x는 객체이기에 출력하기 위한 메소드 get을 정의한다
    }
    public void getAll() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(" "+get(i)+" ");
        }
        System.out.println("]");
    }
    public T get(int index) {

        return node(index).data;
        
        //node(index)까지의 결과는 사용자가 대입한 index만큼 노드를 탐색하고 주소를 반환한다
        //그리고 그곳의 .data값을 가져온다
    }

    public Node Testget(int index) {
        return node(index);
        //node(index)까지의 결과는 사용자가 대입한 index만큼 노드를 탐색하고 주소를 반환한다
        //그리고 그곳의 .data값을 가져온다
    }
    public T removeFirst() {
        Node temp = head;

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        head = head.next;
        T returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }
    public T remove(int index) {
        if (index==0) {
            return removeFirst();
        }
        Node temp = node(index-1);
        //temp의 다음노드가 삭제하려는 노드이다
        
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        T returnData = todoDeleted.data;
        // if (todoDeleted == node(size-1)) {
        //     node(size-1) = temp;
        // }
        todoDeleted = null;
        size--;
        return returnData;
    }
    public T removeLast() {
        return remove(size-1);
        // TODO Auto-generated method stub
    }
    public int size() {
        return size;
    }
    public int indexOf(T data) {
        Node temp = head;
        int index = 0;
        while (temp.data!=data) {
            temp = temp.next;
            index++;
            if (temp==null) {
                return -1;
            }
        }
        return index;
    }
    
}

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);
        list.addLast(101);

        list.get(5);

        //list.addLast(202);
       // list.addLast(202);
        // list.removeFirst();
        // list.removeFirst();
    
        //list.removeFirst();
        //list.add(0, 80);
  
        list.getAll();
        //list.add(2, 10);

        for(int i = 0; i  < list.size(); i++){
            System.out.print(list.Testget(i).next.data + "  ");
            
            
        }
        System.out.println();
        for(int i = 0; i  < list.size(); i++){
            
            System.out.print(list.Testget(i).prev.data + "  ");
            
            
        }
    }
}
