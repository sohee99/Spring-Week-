
## 결과 

< 미완성 >

기존 article과 추가 cmment테이블을 조인 관계 1: N 을 만들기 위해     
    @ManyToOne
    @JoinColumn(name = "article_id")

    article_id를 참조 외래키로 사용하고 ManyToOne 어노테이션을 사용하였다.

    - 생각보다 댓글 정보를 조회/ 생성 부분이 작성하기 힘들었고 코드를 작성 하는 도중 댓글 조회,생성부분을 어떻게 해야할 지 모르겠다,,,,,,,,,,

    ㅜㅜ 내일 강사님의 코드를 통해 배워서 다시 만들어 봐야겠다...

## 1. 댓글 정보 comment 테이블 추가 (기본Ver.)

해당 테이블의 데이터도 자동 생성되도록 data.sql에 INSERT INTO 구문을 추가합니다.

### comment 테이블 추가

- article 테이블과 comment 테이블은 `article.id = comment.article_id` 로 조인할 수 있는 관계(1:1)에 있습니다.


  ![image](https://github.com/sohee99/Spring-Week-/assets/155497383/43a91fce-c53e-4cd1-804d-da8e9b883cb8)


## 2. 댓글 정보를 조회/생성 하는 REST API 개발

- POST `/comments/{articleId}` : articleId 게시글의 댓글 생성
    
    ```json
    {
      "body": "댓글 내용1"
    }
    ```
    
- GET `/comments/{articleId}/{commentId}` :  commentId 댓글 정보 조회
    
    ```json
    {
      "id": 1,
      "body": "댓글 내용1",
      "createdAt": "2024-03-13 12:00:00"
    }
    ```

    ## 심화 Ver.

### article 테이블과 comment 테이블과의 관계 (1:N)

![image](https://github.com/sohee99/Spring-Week-/assets/155497383/6a34f176-add0-4eff-bcab-7e9859bf7d68)


- article 테이블과 comment 테이블은 `article.id = comment.article_id` 로 조인할 수 있는 연관 관계(1:N)에 있습니다.

- GET `/comments/{articleId}` : 하나의 게시글의 댓글(리스트) 조회

  GET /comments/{articleId} : 하나의 게시글의 댓글(리스트) 조회
// HTTP Status Code 200 (성공)응답

```
{
  "articleId": 12345,
  "title": "게시글 제목",
  "content": "게시글 내용",
  "createdAt": "2024-03-13 12:00:00",
  "updatedAt": "2024-03-13 12:00:00",
  "comments": [
    {
      "id": 1,
      "body": "댓글 내용1",
      "createdAt": "2024-03-13 12:00:00"
    },
    {
      "id": 2,
      "body": "댓글 내용2",
      "createdAt": "2024-03-13 12:30:00"
    },
    {
      "id": 3,
      "body": "댓글 내용3",
      "createdAt": "2024-03-13 13:00:00"
    }
  ]
}
```

Response 예시 
