1. 프로젝트 개요 (Overview)
프로젝트명: Spring Boot 기반 공지사항 관리 시스템 (Notice Board Project)
개발 기간: (예: 2026.09 ~ 2026.09) / 개인 프로젝트 (1인)
프로젝트 소개:
Spring Boot와 Thymeleaf, JPA를 활용하여 웹 애플리케이션의 핵심 기능인 CRUD(생성, 조회, 수정, 삭제) 파이프라인을 처음부터 끝까지 구현한 개인 프로젝트입니다.
비전공자의 한계를 넘어, 백엔드와 프론트엔드의 데이터 흐름을 이해하고 실제 작동하는 서비스를 배포/관리하는 역량을 기르기 위해 제작했습니다.

2. 기술 스택 (Tech Stack)
Backend: Java 17+, Spring Boot, Spring Data JPA
Frontend: Thymeleaf, HTML5, CSS
Database: H2 Database (In-Memory DB)
Tools: Git, GitHub, IntelliJ IDEA, Gradle

3. 핵심 기능 (Key Features)
공지사항 목록 조회 (List): 등록된 전체 공지사항 목록을 리스트 형태로 출력
상세 보기 및 단건 조회 (Detail): 특정 게시글의 상세 내용 확인
게시글 작성 (Create): 제목과 내용을 입력하여 새로운 공지사항 등록
게시글 수정 (Update): 기존 데이터를 불러와 내용을 변경하고 덮어씌우는 수정 기능 (JPA 영속성 컨텍스트 및 save() 메서드 활용)
게시글 삭제 (Delete): 특정 ID를 받아 데이터베이스에서 안전하게 삭제 후 목록으로 리다이렉트

4. 아키텍처 및 데이터 흐름 (Architecture)
Layered Architecture (계층형 구조) 적용
Controller ➔ Service ➔ Repository ➔ Database 순으로 관심사 분리(Separation of Concerns)를 고려하여 설계함.

5. 트러블슈팅 및 배운 점 (Troubleshooting) 
