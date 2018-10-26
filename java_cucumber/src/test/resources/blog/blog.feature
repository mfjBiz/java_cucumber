#noinspection NonAsciiCharacters
Feature: ブログ
  登録、更新、検索、タグ付け

  Scenario: ブログが登録できる
    Given ブログ登録ページに遷移
    When 以下のブログ情報を入力して登録
      |タイトル|バーニーズマウンテンドッグが家にきた|
      |本文|名前は何にしよう、迷うな。|
    Then 登録した記事が表示されている
