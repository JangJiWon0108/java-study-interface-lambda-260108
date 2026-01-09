# Java Study Interface Lambda Project

Spring Boot를 사용한 다양한 정렬 알고리즘과 함수형 인터페이스, 람다 표현식 학습용 프로젝트입니다.

## 프로젝트 개요
- **Spring Boot**: 3.5.9
- **Java**: 21
- **Build Tool**: Maven
- **Port**: 7071


## API 사용법

### 정렬 API
**POST** `/jiwon/sort/exec`

**요청 예시:**
```json
{
    "sort_target": "KEY",
    "sort_order": "ASC"
}
```

- `sort_target`: `KEY` 또는 `VALUE`
- `sort_order`: `ASC` (오름차순) 또는 `DESC` (내림차순)

## 구현된 정렬 알고리즘
- List.sort() with Lambda
- List.sort() with Comparator
- Quick Sort
- Dual Pivot Quick Sort
- Tim Sort
- For Loop Sort (버블 정렬 사용)

## 프로젝트 구조
```
src/main/java/com/jjw/study/
├── controller/        # REST API 컨트롤러
├── service/          # 정렬 서비스 인터페이스 및 구현체
└── util/             # 유틸리티 클래스
```