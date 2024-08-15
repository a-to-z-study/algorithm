
### 자바 정렬  

---
  
- 초기에 퀵 정렬을 사용했다가 지금은 제한적으로(데이터가 적은 경우, 안정성이 중요하지 않은 경우) 듀얼 피벗 퀵소트를 사용하고, 병합 정렬을 개선해 만든 팀소트(TimSort)를 기본 알고리즘으로 사용  
- 자바의 정렬 알고리즘은 매우 복잡하고 완성도가 높은 편
- 정렬 기준은 `Comparable`, `Comparator` 인터페이스를 통해 적용
- 객체의 정렬이 필요하면 `Comparable`을 구현(implement), 추가 정렬 기준이 필요하다면 `Comparator`를 제공 

```java
public interface Comparable<T> {
  public int compareTo(T o);
}

@FunctionalInterface
public interface Comparator<T> {
  int compare(T o1, T o2);
}

```

<br>

**병합 정렬**
- 안정 정렬  
- 항상 일정한 성능
- `O(n log n)`  

**퀵 정렬**
- 불안정 정렬  
- 매우 빠르고 효율적 `O(n log n)`  
- 입력에 따라 편차가 심한 편으로 최악의 경우(이미 정렬된 배열) `O(n2)`    

(안정 정렬: 중복된 값을 입력 순서와 동일하게 정렬)

<br>

### ArrayList 특징

---

- 기본 `CAPACITY` 10
- `CAPACITY` 를 넘어가면 배열을 50% 증가 (10 15 22 33 49 ..)
- 최적화는 자바 버전에 다름
- 자바가 제공하는 `ArrayList`는 메모리 고속 복사 연산을 사용 
  - 중간 위치에 데이터를 추가하면 해당 위치 이후의 모든 요소를 한 칸씩 뒤로 이동시켜야 한다.
  - 시스템 레벨에서 `System.arraycopy()` 최적화된 메모리 고속 복사 연산을 사용해서 비교적 빠르게 수행
  - 한 칸씩 이동하는 방식에 비해 대략 `O(n/10)` 정도로 추정, 상수를 제거하면 `O(n)`
-  메모리 상에서 연속적으로 위치하여 CPU 캐시 효율이 좋고, 메모리 접근 속도가 빠름

<br>

### LinkedList 특징

---

- 마지막 노드에 대한 참조 제공
  - 데이터를 마지막에 추가하는 경우에도 O(1)의 성능을 제공
  - 마지막 노드부터 역방향으로 조회 가능
- 인덱스 조회 성능 최적화 가능
  - 인덱스가 사이즈의 절반 이하라면 처음부터 찾아서 올라가고, 인덱스가 사이즈의 절반을 넘으면 마지막 노드 부터 역방향으로 조회해서 성능 최적화
- 각 요소가 별도의 객체로 존재하고 다음 요소의 참조를 저장해서 CPU 캐시 효율 이 떨어지고 메모리 접근 속도가 상대적으로 느림  

<br>

### Hashcode, equals

---

- Object가 기본으로 제공하는 `hashCode()` 는 객체의 참조값을 해시 코드로 사용하여 인스턴스마다 서로 다른 값을 반환
- `Integer`, `String` 같은 자바의 기본 클래스들은 대부분 내부 값을 기반으로 해시 코드를 구할 수 있도록 `hashCode()`를 재정의하여 데이터의 값이 같으면 같은 해시 코드를 반환
- `hashCode()` 를 재정의할 때 `Objects.hash()` 에 해시 코드로 사용할 값을 지정해주면 쉽게 해시 코드를 생성 가능
  - id를 기준으로 해시 코드를 생성한다면 `Objects.hash(id)`
  
- `Object` 는 동등성 비교를 위한 `equals()` 메서드를 제공
- 자바는 두 객체가 같다는 표현을 2가지로 분리해서 사용
  - 동일성(Identity): `==` 연산자를 사용해서 두 객체의 참조가 동일한지 확인  
  - 동등성(Equality): `equals()` 메서드를 사용하여 두 객체가 논리적으로 동등한지 확인  

- 해시 자료 구조를 사용시 해시 인덱스가 충돌하면 같은 해시 인덱스에 있는 데이터들을 비교해서 찾는데 이때 `equals()` 를 사용해서 비교

<br>

### Set

---

**HashSet**
- 해시 자료 구조를 사용해서 요소를 저장
- 요소들은 특정한 순서 없이 저장
- 주요 연산(추가, 삭제, 검색)은 평균적으로 `O(1)` 시간 복잡도  
- 데이터의 유일성만 중요하고, 순서가 중요하지 않은 경우에 적합
- 해시 기반 자료 구조는 데이터의 수가 배열의 크기를 75% 정도 넘어가면 해시 인덱스가 자주 충돌 (성능 저하)
  - `HashSet` 은 데이터양이 75%를 넘어가면 배열의 크기를 2배로 늘리고 모든 요소에 해시 인덱스를 다시 적용 (rehashing)

**LinkedHashSet**
- `HashSet` 에 연결 리스트를 추가해서 요소들의 순서를 유지
- 요소들은 추가된 순서대로 유지
- 주요 연산에 대해 평균 `O(1)` 시간 복잡도
- 데이터의 유일성과 함께 삽입 순서를 유지해야 할 때 적합

**TreeSet**
- `TreeSet` 은 이진 탐색 트리를 개선한 레드-블랙 트리를 내부에서 사용
  - 이진 탐색 트리의 핵심은 데이터를 입력하는 시점에 정렬해서 보관
  - 이진 탐색 트리는 트리의 균형이 맞지 않으면 최악의 경우 `O(n)` 시간 복잡도
  - 레드-블랙 트리를 사용하면 균형을 지속해서 유지하여 최악의 경우에도 `O(log n)` 의 성능을 제공
- 요소들은 정렬된 순서로 저장된다. `Comparator`로 정렬 가능  
- 주요 연산들은 `O(log n)` 의 시간 복잡도
- 데이터들을 정렬된 순서로 유지하면서 집합의 특성을 유지해야 할 때 사용  

<br>

### Queue, Stack, Deque

---
  
**Queue**
  
```java
Queue<Object> queue = new ArrayDeque<>(); // 배열 기반 원형 큐 자료구조 사용, 훨씬 빠름
Queue<Object> queue2 = new LinkedList<>();

queue.add() // 큐가 꽉 찬 경우 IllegalStateException
queue.offer() // 큐가 꽉 찬 경우 false
queue.remove() // 큐가 비어있는 경우 NoSuchElementException
queue.poll() // 큐가 비어있을 경우 null
queue.element() // 큐가 비어있는 경우 NoSuchElementException
queue.peek() // 비어있는 경우 null
```
  
**Stack**
  
- 자바의 Stack은 내부에서 Vector 자료 구조(지금은 사용되지 않고 하위 호환을 위해 존재)를 사용
- `Deque`를 사용하는 것이 좋다.

**Deque**
  
```java
Deque<Object> queue1 = new ArrayDeque<>();
```

- Double Ended Queue
- Dequq는 Queue의 자식 인터페이스로 더 많은 기능 제공
- 양쪽 끝에서 요소를 추가하거나 제거
- 큐와 스택의 기능을 모두 포함하는 유연한 자료구조