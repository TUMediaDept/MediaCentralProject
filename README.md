＃ 191203 commit 부터 확인... ＃

MVP: model과 view를 완전히 분리하기 위해 등장한 패턴


1. Model: 앱 데이터 및 상태에 대한 비즈니스 로직 수행

 ※ Business logic ※
  컴퓨터 프로그래밍의 규칙에 따라 데이터를 생성·표시·저장·변경하는 부분

2. View: 실제 view에 대한 직접적인 접근 담당

 ※ 안드로이드에서의 view ※
  ex) Activity / Fragment


 ☆★ View에서 발생하는 이벤트는 Presenter에 위임하도록 함 --> MVP 목적 ☆★



 ● 위임하는 방법 ●

  액티비티가 뷰 인터페이스를 구현해서(activity implements view(interface))
  Presenter에서 코드를 만들 인터페이스를 갖도록 하면 됨.  ==> 특정 뷰와 결합되지 않고 가상 뷰 구현 가능



3. Preseneter: 뷰(View)와 모델(Model) 사이에서 자료 전달 역할

 ∴ 본질적으로는 MVC의 컨트롤러와 같지만, 뷰에 연결되는 것이 아니라 인터페이스로 연결된다는 점이 다름.


  ==> 데이터 저장 및 모델(model)에 데이터 전송