# CRUD기능을 활용한 게시판 글 작성 및 수정 시스템 (notice Project)

## 1. 프로젝트 개요 (Overview)
* **프로젝트명**: Spring Boot 기반 공지사항 관리 시스템 (Notice Board Project)
* **개발 기간**: (예: 2026.09 ~ 2026.09) / 개인 프로젝트 (1인)
* **프로젝트 소개**:
  *Spring Boot와 Thymeleaf, JPA를 활용하여 웹 애플리케이션의 핵심 기능인 CRUD(생성, 조회, 수정, 삭제) 파이프라인을 구현한 개인 프로젝트입니다. 메인 프로젝트에서는 CRUD기능을 충분히 활용하지 못한 것에 아쉬움을 느껴 이를 보완하고자 구성하였습니다.

## 2. 기술 스택 (Tech Stack)
* **Backend**: Java 17+, Spring Boot, Spring Data JPA
* **Frontend**: Thymeleaf, HTML5, CSS
* **Database**: H2 Database (In-Memory DB)
* **Tools**: Git, GitHub, IntelliJ IDEA, Gradle

## 3. 핵심 기능 (Key Features)
* **공지사항 목록 조회 (List)**: 등록된 전체 공지사항 목록을 리스트 형태로 출력
* **상세 보기 및 단건 조회 (Detail)**: 특정 게시글의 상세 내용 확인
* **게시글 작성 (Create)**: 제목과 내용을 입력하여 새로운 공지사항 등록
* **게시글 수정 (Update)**: 기존 데이터를 불러와 내용을 변경하고 덮어씌우는 수정 기능 (JPA 영속성 컨텍스트 및 save() 메서드 활용)
* **게시글 삭제 (Delete)**: 특정 ID를 받아 데이터베이스에서 안전하게 삭제 후 목록으로 리다이렉트

## 4. 아키텍처 및 데이터 흐름 (Architecture)
* **Layered Architecture (계층형 구조)** 적용
  * `Controller` ➔ `Service` ➔ `Repository` ➔ `Database` 순으로 관심사 분리(Separation of Concerns)를 고려하여 설계함.
  * 각각의 역할로는
  * Controller: 기능별로 조작된 데이터를 반환
  * Service: 가져온 데이터를 각각의 CRUD기능 별로 조작
  * Repository: 데이터 조회 및 저장
  * Entity: 데이터를 DB 테이블과 매핑


## 5. 트러블슈팅 및 배운 점 (Troubleshooting) 
*단순 CRUD기능을 학습하는 것을 넘어서 메인프로젝트 제작 당시 가볍게 보거나 건너뛰었던 메서드의 형식과 역할. CRUD기능의 동작 원리에 대해서 알 수 있었습니다. 그 중에서도 인상적인 내용은 @PostMapping이라는 어노테이션을 사용할 때 데이터를 저장하는 어노테이션임에도 불구하고, 반환값을 주지 않는 void를 쓰게 되면 데이터베이스가 같은 내용으로 도배 됨을 알게 되었습니다. 이렇듯 단순히 어떤 상황에 어떤 어노테이션과 메서드를 쓰느냐보다 왜 이걸 이 상황에 써야하는지 알 수 있는 경험이 되었습니다.
