# epoxyRecycleView
---
## 소개
Epoxy 라이브러리란?
에폭시 라고 불리는 이 라이브러리는 Airbnb에서 제작한 안드로이드 라이브러리이다.
오픈소스로 되어 있으므로, 해당 라이브러리의 내부 구조를 파악하거나 버그 또는 오류등을 수정요청 할 수 있습니다.
더 자세한 내용은 https://github.com/airbnb/epoxy 깃허브에서 확인하시면 도움 되실 겁니다.

## Epoxy 와 RecyclerView의 차이
Recyclerview를 사용하여 복잡한 뷰를 다들 한번 씩 만들어 보았을 것 입니다.
예를 들어 중첩된 리싸이클러뷰 (vertical in horizontal) 같은 경우인데 이렇게 중첩하여 리싸이클러뷰를 생성할 때 가장 큰 문제는 어뎁터와 뷰홀더 등이 계속해서 늘어나므로 관리에 용이하지 못하게 됩니다.
이를 epoxy에서는 Controller를 사용하여 단순화 할 수 있습니다.

## 성능 차이
Epoxy의 성능이 RecycleView보다 좋지 못하다면 사용하지 않을 것 입니다.
Epoxy 같은 경우 RecycleView를 래핑하였기에 기본은 RecyclerView와 같으며, airBnB에서 diffing 알고리즘을 적용하여
보다 성능이 뛰어나다고 알려주고 있습니다.

